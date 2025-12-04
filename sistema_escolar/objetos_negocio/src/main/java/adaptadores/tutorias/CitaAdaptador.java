/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores.tutorias;

import dto.tutorias.CitaDTO;
import tutorias.dominio.Cita;
import tutorias.dominio.enums.EstadoCita;
import tutorias.dominio.enums.Modalidad;

/**
 *
 * @author katia
 */
public class CitaAdaptador {
    
    public static CitaDTO toDTO(Cita entidad) {
        if (entidad == null) return null;
        CitaDTO dto = new CitaDTO();
        dto.setId(entidad.getId());
        dto.setMatriculaAlumno(entidad.getMatriculaAlumno());
        dto.setIdTutor(entidad.getIdTutor());
        if (entidad.getMateria() != null) {
            dto.setIdMateria(entidad.getMateria().getId());
            dto.setNombreMateria(entidad.getMateria().getNombre());
        }
        dto.setTema(entidad.getTema());
        dto.setModalidad(entidad.getModalidad().name()); 
        dto.setFecha(entidad.getFecha());
        dto.setHora(entidad.getHora());
        dto.setUbicacion(entidad.getUbicacion());
        dto.setEstado(entidad.getEstado().name()); 
        return dto;
    }
    
    public static Cita toDominio(CitaDTO dto) {
        if (dto == null) return null;
        Cita entidad = new Cita();
        entidad.setId(dto.getId());
        entidad.setMatriculaAlumno(dto.getMatriculaAlumno());
        entidad.setIdTutor(dto.getIdTutor());
        entidad.setTema(dto.getTema());
        if (dto.getModalidad() != null) {
            entidad.setModalidad(Modalidad.valueOf(dto.getModalidad()));
        }
        entidad.setFecha(dto.getFecha());
        entidad.setHora(dto.getHora());
        entidad.setUbicacion(dto.getUbicacion());
        if (dto.getEstado() != null) {
            entidad.setEstado(EstadoCita.valueOf(dto.getEstado()));
        }
        return entidad;
    }
    
}
