package objetosNegocio.interfaces;

import dto.DatosSolicitanteDTO;
import dto.DocumentoDTO;
import dto.HistorialAcademicoDTO;
import dto.InformacionSocioeconomicaDTO;

public interface IControlBeca {
    boolean iniciarSesion(String usuario, String contrasenia) throws Exception;
    void guardarDatosSolicitante(DatosSolicitanteDTO datosSolicitanteDTO);
    void guardarInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomicaDTO);
    void guardarHistorialAcademico(HistorialAcademicoDTO historialAcademicoDTO);
    void guardarDocumento(DocumentoDTO documentoDTO);
    void confirmarSolicitud(int idSolicitud);
}
