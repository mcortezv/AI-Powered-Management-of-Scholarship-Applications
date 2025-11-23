/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;
import dominio.Solicitud;
import dto.SolicitudDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudAdaptador {

    public static SolicitudDTO toDTO(Solicitud solicitud) {
        SolicitudDTO dto = new SolicitudDTO();
        dto.setId(solicitud.getId());
        dto.setBeca(solicitud.getBeca());
        dto.setEstudiante(solicitud.getEstudiante());
        dto.setInformacionSocioeconomica(solicitud.getInformacionSocioeconomica());
        dto.setHistorialAcademico(solicitud.getHistorialAcademico());
        dto.setDocumentos(solicitud.getDocumentos());
        dto.setFecha(solicitud.getFecha());
        dto.setEstado(solicitud.getEstado());
        return dto;
    }

    public static Solicitud toEntity(SolicitudDTO dto) {
        Solicitud solicitud = new Solicitud();
        solicitud.setId(dto.getId());
        solicitud.setBeca(dto.getBeca());
        solicitud.setEstudiante(dto.getEstudiante());
        solicitud.setInformacionSocioeconomica(dto.getInformacionSocioeconomica());
        solicitud.setHistorialAcademico(dto.getHistorialAcademico());
        solicitud.setDocumentos(dto.getDocumentos());
        solicitud.setFecha(dto.getFecha());
        solicitud.setEstado(dto.getEstado());
        return solicitud;
    }
}
