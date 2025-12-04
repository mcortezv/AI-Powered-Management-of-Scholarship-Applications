/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores.tutorias;

import dto.tutorias.MateriaDTO;
import tutorias.dominio.Materia;

/**
 *
 * @author katia
 */
public class MateriaAdaptador {
    public static MateriaDTO toDTO(Materia entidad) {
        if (entidad == null) return null;
        MateriaDTO dto = new MateriaDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        return dto;
    }

    public static Materia toDominio(MateriaDTO dto) {
        if (dto == null) return null;
        Materia entidad = new Materia();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        return entidad;
    }
}
