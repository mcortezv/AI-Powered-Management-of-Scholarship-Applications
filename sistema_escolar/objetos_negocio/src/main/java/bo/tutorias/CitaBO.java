/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.tutorias;

import adaptadores.tutorias.CitaAdaptador;
import bo.tutorias.excepciones.CitaInvalidaException;
import dto.tutorias.CitaDTO;
import interfaces.tutorias.ICitaBO;
import interfaces.tutorias.IHorarioBO;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import tutorias.dao.interfaces.ICitaDAO;
import tutorias.dominio.Cita;
import tutorias.dominio.Materia;
import tutorias.dominio.enums.EstadoCita;

/**
 *
 * @author katia
 */
public class CitaBO implements ICitaBO{
    private final ICitaDAO citaDAO;
    private final IHorarioBO horarioBO;
    
    private static final int MAX_CANCELACIONES_POR_MES = 3;

    public CitaBO(ICitaDAO citaDAO, IHorarioBO horarioBO) {
        this.citaDAO = citaDAO;
        this.horarioBO = horarioBO;
    }
    
    @Override
    public CitaDTO agendarCita(CitaDTO citaDTO) {
        validarDatosCita(citaDTO);
        
        if (!puedeAgendarCita(citaDTO.getMatriculaAlumno())) {
            throw new CitaInvalidaException(
                "No puedes agendar citas porque has cancelado 3 o más veces en este mes. " +
                "Intenta nuevamente el próximo mes."
            );
        }
        
        if (citaDTO.getFecha().isBefore(LocalDate.now())) {
            throw new CitaInvalidaException("No se pueden agendar citas en fechas pasadas");
        }
        
        verificarDisponibilidadAlumno(citaDTO.getMatriculaAlumno(), citaDTO.getFecha(), citaDTO.getHora());
        
        try {
            Cita cita = CitaAdaptador.toEntity(citaDTO);
            cita.setEstado(EstadoCita.PENDIENTE);
            
            if (citaDTO.getIdMateria() != null) {
                Materia materia = new Materia();
                materia.setId(citaDTO.getIdMateria());
                cita.setMateria(materia);
            }
            
            Cita citaCreada = citaDAO.crear(cita);
            
            horarioBO.marcarHorarioComoOcupado(citaDTO.getIdHorario());
            
            CitaDTO resultado = CitaAdaptador.toDTO(citaCreada);
            return resultado;
            
        } catch (Exception ex) {
            throw new CitaInvalidaException("Error al agendar la cita: " + ex.getMessage());
        }
    }

    @Override
    public boolean cancelarCita(Long idCita, Long matriculaAlumno) {
        if (idCita == null || idCita <= 0) {
            throw new CitaInvalidaException("El ID de la cita no puede ser nulo o inválido");
        }
        if (matriculaAlumno == null) {
            throw new CitaInvalidaException("La matrícula del alumno no puede ser nula");
        }
        
        try {
            List<Cita> citasFuturas = citaDAO.obtenerFuturasPorAlumno(matriculaAlumno);
            Cita cita = citasFuturas.stream()
                .filter(c -> c.getId().equals(idCita))
                .findFirst()
                .orElseThrow(() -> new CitaInvalidaException("No se encontró la cita con ID " + idCita));
            
            LocalDateTime ahora = LocalDateTime.now();
            LocalDateTime horaCita = cita.getFecha().atTime(cita.getHora());
            Duration tiempoRestante = Duration.between(ahora, horaCita);
            
            if (tiempoRestante.toMinutes() < 60) {
                throw new CitaInvalidaException(
                    "No se puede cancelar la cita porque falta menos de 1 hora. " +
                    "Por favor, contacta directamente al tutor."
                );
            }
            Cita citaActualizada = citaDAO.actualizarEstado(idCita, EstadoCita.CANCELADA);
            //horarioBO.liberarHorario(cita.getIdHorario());
            return citaActualizada != null && citaActualizada.getEstado() == EstadoCita.CANCELADA;
        } catch (CitaInvalidaException e) {
            throw e;
        } catch (Exception ex) {
            throw new CitaInvalidaException("Error al cancelar la cita");
        }
    }

    @Override
    public boolean puedeAgendarCita(Long matriculaAlumno) {
        if (matriculaAlumno == null) {
            throw new CitaInvalidaException("La matrícula del alumno no puede ser nula");
        }
        try {
            LocalDate hoy = LocalDate.now();
            int cancelaciones = citaDAO.contarCitasPorAlumnoYEstadoEnMes(
                matriculaAlumno,
                EstadoCita.CANCELADA,
                hoy.getMonthValue(),
                hoy.getYear()
            );
            return cancelaciones < MAX_CANCELACIONES_POR_MES;
        } catch (Exception ex) {
            throw new CitaInvalidaException("Error al verificar si puede agendar cita" );
        }
    }

    @Override
    public List<CitaDTO> obtenerCitasActivas(Long matriculaAlumno) {
        if (matriculaAlumno == null) {
            throw new CitaInvalidaException("La matrícula del alumno no puede ser nula");
        }
        try {
            List<Cita> citasFuturas = citaDAO.obtenerFuturasPorAlumno(matriculaAlumno);
            List<CitaDTO> citasDTO = new ArrayList<>();
            
            for (Cita cita : citasFuturas) {
                if (cita.getEstado() == EstadoCita.PENDIENTE) {
                    CitaDTO dto = CitaAdaptador.toDTO(cita);
                    citasDTO.add(dto);
                }
            }
            return citasDTO;
        } catch (Exception ex) {
            throw new CitaInvalidaException("Error al obtener citas activas" );
        }
    }


    
    private void validarDatosCita(CitaDTO citaDTO) {
        if (citaDTO == null) {
            throw new CitaInvalidaException("Los datos de la cita no pueden ser nulos");
        }
        if (citaDTO.getMatriculaAlumno() == null) {
            throw new CitaInvalidaException("La matrícula del alumno es requerida");
        }
        if (citaDTO.getIdTutor() == null) {
            throw new CitaInvalidaException("El tutor es requerido");
        }      
        if (citaDTO.getIdMateria() == null) {
            throw new CitaInvalidaException("La materia es requerida");
        }      
        if (citaDTO.getTema() == null || citaDTO.getTema().trim().isEmpty()) {
            throw new CitaInvalidaException("El tema es requerido");
        }
        if (citaDTO.getModalidad() == null || citaDTO.getModalidad().trim().isEmpty()) {
            throw new CitaInvalidaException("La modalidad es requerida");
        }
        if (citaDTO.getFecha() == null) {
            throw new CitaInvalidaException("La fecha es requerida");
        }
        if (citaDTO.getHora() == null) {
            throw new CitaInvalidaException("La hora es requerida.");
        }
    }
    
    private void verificarDisponibilidadAlumno(Long matriculaAlumno, LocalDate fecha, LocalTime hora) {
        try {
            List<Cita> citasMismoDia = citaDAO.obtenerHistorialPorFecha(matriculaAlumno, fecha);
            for (Cita cita : citasMismoDia) {
                if (cita.getEstado() == EstadoCita.PENDIENTE && cita.getHora().equals(hora)) {
                    throw new CitaInvalidaException(
                        "Ya tienes una cita agendada para el " + fecha + " a las " + hora
                    );
                }
            }
        } catch (CitaInvalidaException e) {
            throw e;
        } catch (Exception ex) {
            throw new CitaInvalidaException("Error al verificar disponibilidad" );
        }
    }
}
