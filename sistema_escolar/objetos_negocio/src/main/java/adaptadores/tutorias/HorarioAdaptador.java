/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores.tutorias;

import dto.tutorias.HorarioDTO;
import tutorias.dominio.Horario;
import tutorias.dominio.enums.EstadoDisponibilidad;

/**
 *
 * @author katia
 */
public class HorarioAdaptador {
    public static HorarioDTO toDTO(Horario entidad) {
        if (entidad == null) return null;

        HorarioDTO dto = new HorarioDTO();
        dto.setId(entidad.getId());
        dto.setIdTutor(entidad.getIdTutor());
        dto.setFecha(entidad.getFecha());
        dto.setHora(entidad.getHora());
        dto.setEstadoDisponibilidad(entidad.getEstadoDisponibilidad().name());
        return dto;
    }

    public static Horario toDominio(HorarioDTO dto) {
        if (dto == null) return null;

        Horario entidad = new Horario();
        entidad.setId(dto.getId());
        entidad.setIdTutor(dto.getIdTutor());
        entidad.setFecha(dto.getFecha());
        entidad.setHora(dto.getHora());
        if (dto.getEstadoDisponibilidad() != null) {
            entidad.setEstadoDisponibilidad(
                    EstadoDisponibilidad.valueOf(dto.getEstadoDisponibilidad())
            );
        }
        return entidad;
    }
}
