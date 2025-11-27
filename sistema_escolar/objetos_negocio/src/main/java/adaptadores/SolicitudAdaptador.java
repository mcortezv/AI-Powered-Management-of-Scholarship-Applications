/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;
import solicitarBeca.dominio.Documento;
import solicitarBeca.dominio.Solicitud;
import solicitarBeca.dominio.enums.EstadoSolicitud;
import dto.DocumentoDTO;
import dto.SolicitudDTO;
import solicitarBeca.repository.documents.SolicitudDocument;

import java.util.ArrayList;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudAdaptador {

    public static SolicitudDTO toDTO(Solicitud solicitud) {
        SolicitudDTO dto = new SolicitudDTO();
        dto.setId(solicitud.getId());
        dto.setBeca(BecaAdaptador.toDTO(solicitud.getBeca()));
        dto.setEstudiante(EstudianteAdaptador.toDTO(solicitud.getEstudiante()));
        dto.setInformacionSocioeconomica(InformacionSocioeconomicaAdaptador.toDTO(solicitud.getInformacionSocioeconomica()));
        dto.setHistorialAcademico(HistorialAcademicoAdaptador.toDTO(solicitud.getHistorialAcademico()));
        ArrayList<DocumentoDTO> documentosDTO = new ArrayList<>();
        for (Documento documento : solicitud.getDocumentos()) {
            documentosDTO.add(DocumentoAdaptador.toDTO(documento));
        }
        dto.setDocumentos(documentosDTO);
        dto.setFecha(solicitud.getFecha());
        dto.setEstado(solicitud.getEstado().toString());
        return dto;
    }

    public static Solicitud toEntity(SolicitudDTO dto) {
        Solicitud solicitud = new Solicitud();
        solicitud.setId(dto.getId());
        solicitud.setBeca(BecaAdaptador.toEntity(dto.getBeca()));
        solicitud.setEstudiante(EstudianteAdaptador.toEntity(dto.getEstudiante()));
        solicitud.setInformacionSocioeconomica(InformacionSocioeconomicaAdaptador.toEntity(dto.getInformacionSocioeconomica()));
        solicitud.setHistorialAcademico(HistorialAcademicoAdaptador.toEntity(dto.getHistorialAcademico()));
        ArrayList<Documento> documentos = new ArrayList<>();
        for (DocumentoDTO documento : dto.getDocumentos()) {
            documentos.add(DocumentoAdaptador.toEntity(documento));
        }
        solicitud.setDocumentos(documentos);
        solicitud.setFecha(dto.getFecha());
        solicitud.setEstado(EstadoSolicitud.valueOf(dto.getEstado()));
        return solicitud;
    }

    public static SolicitudDocument toDocument(Solicitud solicitud) {
        SolicitudDocument document = new SolicitudDocument();
        document.setId(solicitud.getId());
        document.setBeca(solicitud.getBeca());
        document.setEstudiante(solicitud.getEstudiante().getMatricula());
        document.setInformacionSocioeconomica(InformacionSocioeconomicaAdaptador.toDTO(solicitud.getInformacionSocioeconomica()));
        document.setHistorialAcademico(HistorialAcademicoAdaptador.toDTO(solicitud.getHistorialAcademico()));
        ArrayList<DocumentoDTO> documentosDTO = new ArrayList<>();
        for (Documento documento : solicitud.getDocumentos()) {
            documentosDTO.add(DocumentoAdaptador.toDTO(documento));
        }
        dto.setDocumentos(documentosDTO);
        dto.setFecha(solicitud.getFecha());
        dto.setEstado(solicitud.getEstado().toString());
        return dto;
    }
}
