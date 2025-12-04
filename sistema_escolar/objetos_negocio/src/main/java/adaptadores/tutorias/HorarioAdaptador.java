/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores.tutorias;

import adaptadores.tutorias.excepciones.HorarioAdaptadorException;
import dto.tutorias.HorarioDTO;
import org.bson.types.ObjectId;
import tutorias.dominio.Horario;
import tutorias.dominio.enums.EstadoDisponibilidad;
import tutorias.repository.documents.HorarioDocument;

/**
 *
 * @author katia
 */
public class HorarioAdaptador {
    public static Horario toEntity(HorarioDTO dto) {
        try {
            if (dto == null) return null;

            Horario horario = new Horario();
            horario.setId(dto.getId());
            horario.setIdTutor(dto.getIdTutor());
            horario.setFecha(dto.getFecha());
            horario.setHora(dto.getHora());
            if (dto.getEstadoDisponibilidad() != null) {
                horario.setEstadoDisponibilidad(
                        EstadoDisponibilidad.valueOf(dto.getEstadoDisponibilidad())
                );
            }
            return horario;
        } catch (Exception ex) {
            throw new HorarioAdaptadorException("Error al convertir HorarioDTO a entidad");
        }
    }

    public static HorarioDTO toDTO(Horario horario) {
        try {
            if (horario == null) return null;

            HorarioDTO dto = new HorarioDTO();
            dto.setId(horario.getId());
            dto.setIdTutor(horario.getIdTutor());
            dto.setFecha(horario.getFecha());
            dto.setHora(horario.getHora());
            if (horario.getEstadoDisponibilidad() != null) {
                dto.setEstadoDisponibilidad(horario.getEstadoDisponibilidad().toString());
            }
            return dto;
        } catch (Exception ex) {
            throw new HorarioAdaptadorException("Error al convertir entidad Horario a DTO");
        }
    }

    public static Horario toEntity(HorarioDocument doc) {
        try {
            if (doc == null) return null;

            Horario horario = new Horario();
            horario.setId(doc.getId());
            horario.setIdTutor(doc.getIdTutor());
            horario.setFecha(doc.getFecha());
            horario.setHora(doc.getHora());
            horario.setEstadoDisponibilidad(doc.getEstadoDisponibilidad());
            return horario;
        } catch (Exception ex) {
            throw new HorarioAdaptadorException("Error al convertir HorarioDocument a entidad");
        }
    }

    public static HorarioDocument toDocument(Horario horario) {
        try {
            if (horario == null) return null;

            HorarioDocument doc = new HorarioDocument();
            doc.set_id(new ObjectId());
            doc.setId(horario.getId());
            doc.setIdTutor(horario.getIdTutor());
            doc.setFecha(horario.getFecha());
            doc.setHora(horario.getHora());
            doc.setEstadoDisponibilidad(horario.getEstadoDisponibilidad());
            return doc;
        } catch (Exception ex) {
            throw new HorarioAdaptadorException("Error al convertir entidad Horario a HorarioDocument");
        }
    }
}
