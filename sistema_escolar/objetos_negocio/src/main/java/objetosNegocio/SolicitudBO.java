package objetosNegocio;
import adaptadores.SolicitudAdaptador;
import dao.interfaces.ISolicitudDAO;
import dominio.*;
import dominio.enums.EstadoSolicitud;
import dto.SolicitudDTO;
import excepciones.*;
import interfaces.IFachadaGobierno;
import interfaces.ISolicitudBO;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudBO implements ISolicitudBO {
    private IFachadaGobierno fachadaGobierno;
    private ISolicitudDAO solicitudDAO;

    public SolicitudBO(IFachadaGobierno fachadaGobierno, ISolicitudDAO solicitudDAO) {
        this.fachadaGobierno = fachadaGobierno;
        this.solicitudDAO = solicitudDAO;
    }

    @Override
    public Solicitud crearSolicitudVacia() {
        Solicitud solicitud = new Solicitud();
        solicitud.setEstado(EstadoSolicitud.ACTIVA);
        return solicitud;
    }

    @Override
    public void asignarEstudiante(Solicitud solicitud, Estudiante estudiante) throws SolicitudInvalidaException {
        if (solicitud == null) {
            throw new SolicitudInvalidaException("Solicitud nula.");
        }
        if (estudiante == null) {
            throw new SolicitudInvalidaException("Estudiante nulo.");
        }
        solicitud.setEstudiante(estudiante);
    }

    @Override
    public void asignarBeca(Solicitud solicitud, Beca beca) throws SolicitudInvalidaException {
        if (solicitud.getEstudiante() == null){
            throw new SolicitudInvalidaException("Debe agregar primero al estudiante.");
        }
        if (beca == null){
            throw new SolicitudInvalidaException("Beca nula.");
        }
        solicitud.setBeca(beca);
    }

    @Override
    public void asignarDocumentos(Solicitud solicitud, List<Documento> documentos) throws SolicitudInvalidaException {
        if (solicitud.getBeca() == null) {
            throw new SolicitudInvalidaException("Debe asignar la beca antes de documentos.");
        }
        if (documentos == null || documentos.isEmpty()) {
            throw new SolicitudInvalidaException("Debe adjuntar documentos.");
        }
        solicitud.setDocumentos(documentos);
    }

    @Override
    public void asignarHistorial(Solicitud solicitud, HistorialAcademico historialAcademico) throws SolicitudInvalidaException {
        if (solicitud.getDocumentos() == null) {
            throw new SolicitudInvalidaException("Debe agregar documentos primero.");
        }
        if (historialAcademico == null) {
            throw new SolicitudInvalidaException("Historial nulo.");
        }
        solicitud.setHistorialAcademico(historialAcademico);
    }

    @Override
    public void asignarSocioeconomico(Solicitud solicitud, InformacionSocioeconomica informacionSocioeconomica) throws SolicitudInvalidaException {
        if (solicitud.getHistorialAcademico() == null) {
            throw new SolicitudInvalidaException("Debe agregar el historial académico primero.");
        }
        if (informacionSocioeconomica == null) {
            throw new SolicitudInvalidaException("Información socioeconómica nula.");
        }
        solicitud.setInformacionSocioeconomica(informacionSocioeconomica);
    }

    @Override
    public void validarSolicitudCompleta(Solicitud solicitud) throws SolicitudInvalidaException {
        if (solicitud.getEstudiante() == null || solicitud.getBeca() == null || solicitud.getDocumentos() == null ||
                solicitud.getHistorialAcademico() == null || solicitud.getInformacionSocioeconomica() == null) {
            throw new SolicitudInvalidaException("Solicitud incompleta.");
        }
        solicitud.setEstado(EstadoSolicitud.ACTIVA);
    }

    @Override
    public void guardarSolicitud(Solicitud solicitud) throws SolicitudInvalidaException {
        try {
            SolicitudDTO solicitudDTO = SolicitudAdaptador.toDTO(solicitud);
            fachadaGobierno.enviarSolicitud(solicitudDTO);
            solicitudDAO.create(solicitud);
        } catch (Exception ex) {
            throw new SolicitudInvalidaException(ex.getMessage());
        }
    }
}
