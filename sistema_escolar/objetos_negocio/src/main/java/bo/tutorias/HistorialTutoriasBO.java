/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.tutorias;

import adaptadores.tutorias.CitaAdaptador;
import bo.tutorias.excepciones.HistorialTutoriasException;
import dto.tutorias.CitaDTO;
import interfaces.tutorias.IHistorialTutoriasBO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tutorias.dao.interfaces.ICitaDAO;
import tutorias.dao.interfaces.IMateriaDAO;
import tutorias.dao.interfaces.ITutorDAO;
import tutorias.dominio.Cita;
import tutorias.dominio.Materia;
import tutorias.dominio.Tutor;

/**
 *
 * @author katia
 */
public class HistorialTutoriasBO implements IHistorialTutoriasBO{
    private final ICitaDAO citaDAO;
    private final ITutorDAO tutorDAO;
    private final IMateriaDAO materiaDAO;

    public HistorialTutoriasBO(ICitaDAO citaDAO, ITutorDAO tutorDAO, IMateriaDAO materiaDAO) {
        this.citaDAO = citaDAO;
        this.tutorDAO = tutorDAO;
        this.materiaDAO = materiaDAO;
    }

    @Override
    public List<CitaDTO> obtenerHistorialCompletoAlumno(Long matriculaAlumno) throws HistorialTutoriasException {
        try {
            List<Cita> citas = citaDAO.obtenerHistorialCompletoAlumno(matriculaAlumno);
            return convertirListaCitaADTO(citas);
        } catch (Exception ex) {
            throw new HistorialTutoriasException("Error al obtener el historial completo del alumno");
        }
    }

    @Override
    public List<CitaDTO> obtenerHistorialPorFecha(Long matriculaAlumno, LocalDate fecha) throws HistorialTutoriasException {
        if (fecha == null) {
            throw new HistorialTutoriasException("La fecha no puede ser nula");
        }
        try {
            List<Cita> citas = citaDAO.obtenerHistorialPorFecha(matriculaAlumno, fecha);
            return convertirListaCitaADTO(citas);
        } catch (Exception ex) {
            throw new HistorialTutoriasException("Error al obtener el historial por fecha");
        }
    }

    @Override
    public List<CitaDTO> obtenerHistorialPorMateria(Long matriculaAlumno, Long idMateria) throws HistorialTutoriasException {
        if (idMateria == null) {
            throw new HistorialTutoriasException("La materia no puede ser nula");
        }
        try {
            List<Cita> citas = citaDAO.obtenerHistorialPorMateria(matriculaAlumno, idMateria);
            return convertirListaCitaADTO(citas);
        } catch (Exception ex) {
            throw new HistorialTutoriasException("Error al obtener el historial por materia");
        }
    }

    @Override
    public List<CitaDTO> obtenerHistorialPorFechaYMateria(Long matriculaAlumno, LocalDate fecha, Long idMateria) throws HistorialTutoriasException {
        if (fecha == null || idMateria == null) {
            throw new HistorialTutoriasException("La fecha y la materia no pueden ser nulas");
        }
        try {
            List<Cita> citas =
                    citaDAO.obtenerHistorialPorFechaYMateria(matriculaAlumno, fecha, idMateria);
            return convertirListaCitaADTO(citas);
        } catch (Exception ex) {
            throw new HistorialTutoriasException("Error al obtener el historial por fecha y materia");
        }
    }

    private List<CitaDTO> convertirListaCitaADTO(List<Cita> citas) throws HistorialTutoriasException {
        List<CitaDTO> resultado = new ArrayList<>();
        if (citas == null || citas.isEmpty()) {
            return resultado;
        }

        try {
            for (Cita cita : citas) {
                CitaDTO dto = CitaAdaptador.toDTO(cita);
                if (cita.getIdTutor() != null) {
                    Tutor tutor = tutorDAO.obtenerPorId(cita.getIdTutor());
                    if (tutor != null) {
                        dto.setNombreTutor(tutor.getNombre());
                    }
                }
                if (cita.getMateria() != null && cita.getMateria().getId() != null) {
                    Materia materia = materiaDAO.obtenerPorId(cita.getMateria().getId());
                    if (materia != null) {
                        dto.setNombreMateria(materia.getNombre());
                    }
                }
                resultado.add(dto);
            }
        } catch (Exception e) {
            throw new HistorialTutoriasException("Error al convertir la lista de citas a DTO");
        }
        return resultado;
    }
}
