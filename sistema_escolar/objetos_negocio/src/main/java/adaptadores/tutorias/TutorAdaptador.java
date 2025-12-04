/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores.tutorias;

import adaptadores.solicitarBeca.excepciones.TutorAdaptadorException;
import dto.tutorias.TutorDTO;
import tutorias.dominio.Tutor;
import tutorias.repository.documents.TutorDocument;

/**
 *
 * @author katia
 */
public class TutorAdaptador {
    public static Tutor toEntity(TutorDTO dto) {
        try {
            if (dto == null) return null;

            Tutor tutor = new Tutor();
            tutor.setId(dto.getId());
            tutor.setNombre(dto.getNombre());
            tutor.setCarrera(dto.getCarrera());
            tutor.setCubiculo(dto.getCubiculo());
            tutor.setEnlace(dto.getEnlace());
            return tutor;
        } catch (Exception ex) {
            throw new TutorAdaptadorException("Error al convertir TutorDTO a entidad");
        }
    }

    public static TutorDTO toDTO(Tutor tutor) {
        try {
            if (tutor == null) return null;

            TutorDTO dto = new TutorDTO();
            dto.setId(tutor.getId());
            dto.setNombre(tutor.getNombre());
            dto.setCarrera(tutor.getCarrera());
            dto.setCubiculo(tutor.getCubiculo());
            dto.setEnlace(tutor.getEnlace());
            return dto;
        } catch (Exception ex) {
            throw new TutorAdaptadorException("Error al convertir entidad Tutor a DTO");
        }
    }

    public static Tutor toEntity(TutorDocument doc) {
        try {
            if (doc == null) return null;

            Tutor tutor = new Tutor();
            tutor.setId(doc.getIdTutor());
            tutor.setNombre(doc.getNombre());
            tutor.setCarrera(doc.getCarrera());
            tutor.setCubiculo(doc.getCubiculo());
            tutor.setEnlace(doc.getEnlace());
            return tutor;
        } catch (Exception ex) {
            throw new TutorAdaptadorException("Error al convertir TutorDocument a entidad");
        }
    }
}
