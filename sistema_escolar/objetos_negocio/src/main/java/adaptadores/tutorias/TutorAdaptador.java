/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores.tutorias;

import dto.tutorias.TutorDTO;
import tutorias.dominio.Tutor;

/**
 *
 * @author katia
 */
public class TutorAdaptador {
    public static TutorDTO toDTO(Tutor entidad) {
        if (entidad == null) return null;
        TutorDTO dto = new TutorDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setCarrera(entidad.getCarrera());
        dto.setCubiculo(entidad.getCubiculo());
        dto.setEnlace(entidad.getEnlace());
        return dto;
    }

    public static Tutor toDominio(TutorDTO dto) {
        if (dto == null) return null;
        Tutor entidad = new Tutor();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setCarrera(dto.getCarrera());
        entidad.setCubiculo(dto.getCubiculo());
        entidad.setEnlace(dto.getEnlace());
        return entidad;
    }
}
