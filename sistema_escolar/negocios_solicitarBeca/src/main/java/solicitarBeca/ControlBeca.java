package solicitarBeca;

import dto.DatosSolicitanteDTO;
import dto.DocumentoDTO;
import dto.HistorialAcademicoDTO;
import dto.InformacionSocioeconomicaDTO;
import objetosNegocio.interfaces.IControlBeca;

public class ControlBeca implements IControlBeca {

    @Override
    public boolean iniciarSesion(String usuario, String contrasenia) throws Exception {
        if(usuario == null || usuario.trim().isEmpty()){
            throw new Exception("algo salio mal");
        }
        return true;

    }

    @Override
    public void guardarDatosSolicitante(DatosSolicitanteDTO datosSolicitanteDTO) {

    }

    @Override
    public void guardarInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomicaDTO) {

    }

    @Override
    public void guardarHistorialAcademico(HistorialAcademicoDTO historialAcademicoDTO) {

    }

    @Override
    public void guardarDocumento(DocumentoDTO documentoDTO) {

    }

    @Override
    public void confirmarSolicitud(int idSolicitud) {

    }
}
