package objetosNegocio;
import dominio.*;
import dominio.enums.EstadoSolicitud;
import excepciones.*;
import interfaces.ISolicitudBO;
import java.util.List;

public class SolicitudBO implements ISolicitudBO {

    @Override
    public Solicitud crearSolicitudVacia() {
        Solicitud s = new Solicitud();
        s.setEstado(EstadoSolicitud.ACTIVA);
        return s;
    }

    @Override
    public void asignarEstudiante(Solicitud s, Estudiante e) throws SolicitudInvalidaException {
        if (s == null) throw new SolicitudInvalidaException("Solicitud nula.");
        if (e == null) throw new SolicitudInvalidaException("Estudiante nulo.");

        s.setEstudiante(e);
    }

    @Override
    public void asignarBeca(Solicitud s, Beca b) throws SolicitudInvalidaException {
        if (s.getEstudiante() == null)
            throw new SolicitudInvalidaException("Debe agregar primero al estudiante.");

        if (b == null)
            throw new SolicitudInvalidaException("Beca nula.");

        s.setBeca(b);
    }

    @Override
    public void asignarDocumentos(Solicitud s, List<Documento> docs)
            throws SolicitudInvalidaException {

        if (s.getBeca() == null)
            throw new SolicitudInvalidaException("Debe asignar la beca antes de documentos.");

        if (docs == null || docs.isEmpty())
            throw new SolicitudInvalidaException("Debe adjuntar documentos.");

        s.setDocumentos(docs);
    }

    @Override
    public void asignarHistorial(Solicitud s, HistorialAcademico h)
            throws SolicitudInvalidaException {

        if (s.getDocumentos() == null)
            throw new SolicitudInvalidaException("Debe agregar documentos primero.");

        if (h == null)
            throw new SolicitudInvalidaException("Historial nulo.");

        s.setHistorialAcademico(h);
    }

    @Override
    public void asignarSocioeconomico(Solicitud s, InformacionSocioeconomica info)
            throws SolicitudInvalidaException {

        if (s.getHistorialAcademico() == null)
            throw new SolicitudInvalidaException("Debe agregar el historial académico primero.");

        if (info == null)
            throw new SolicitudInvalidaException("Información socioeconómica nula.");

        s.setInformacionSocioeconomica(info);
    }

    @Override
    public void validarSolicitudCompleta(Solicitud s)
            throws SolicitudInvalidaException {

        if (s.getEstudiante() == null ||
                s.getBeca() == null ||
                s.getDocumentos() == null ||
                s.getHistorialAcademico() == null ||
                s.getInformacionSocioeconomica() == null)
            throw new SolicitudInvalidaException("Solicitud incompleta.");

        s.setEstado(EstadoSolicitud.ACTIVA);
    }
}
