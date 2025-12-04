/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores.tutorias;

import adaptadores.tutorias.excepciones.MateriaAdaptadorException;
import dto.tutorias.MateriaDTO;
import tutorias.dominio.Materia;
import tutorias.repository.documents.MateriaDocument;

/**
 *
 * @author katia
 */
public class MateriaAdaptador {
    public static Materia toEntity(MateriaDTO dto) {
        try {
            if (dto == null) return null;

            Materia materia = new Materia();
            materia.setId(dto.getId());
            materia.setNombre(dto.getNombre());
            return materia;
        } catch (Exception ex) {
            throw new MateriaAdaptadorException("Error al convertir MateriaDTO a entidad");
        }
    }

    public static MateriaDTO toDTO(Materia materia) {
        try {
            if (materia == null) return null;

            MateriaDTO dto = new MateriaDTO();
            dto.setId(materia.getId());
            dto.setNombre(materia.getNombre());
            return dto;
        } catch (Exception ex) {
            throw new MateriaAdaptadorException("Error al convertir entidad Materia a DTO");
        }
    }

    public static Materia toEntity(MateriaDocument doc) {
        try {
            if (doc == null) return null;

            Materia materia = new Materia();
            materia.setId(doc.getIdMateria());
            materia.setNombre(doc.getNombre());
            return materia;
        } catch (Exception ex) {
            throw new MateriaAdaptadorException("Error al convertir MateriaDocument a entidad");
        }
    }
}
