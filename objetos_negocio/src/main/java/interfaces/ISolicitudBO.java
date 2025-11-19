package interfaces;
import dominio.*;
import excepciones.*;
import java.util.List;

public interface ISolicitudBO {
    Solicitud crearSolicitudVacia() throws SolicitudInvalidaException;

    void asignarEstudiante(Solicitud solicitud, Estudiante estudiante) throws SolicitudInvalidaException;
    void asignarBeca(Solicitud solicitud, Beca beca) throws SolicitudInvalidaException;
    void asignarDocumentos(Solicitud solicitud, List<Documento> documentos) throws SolicitudInvalidaException;
    void asignarHistorial(Solicitud solicitud, HistorialAcademico historialAcademico) throws SolicitudInvalidaException;
    void asignarSocioeconomico(Solicitud solicitud, InformacionSocioeconomica info) throws SolicitudInvalidaException;
    void validarSolicitudCompleta(Solicitud solicitud) throws SolicitudInvalidaException;
}
