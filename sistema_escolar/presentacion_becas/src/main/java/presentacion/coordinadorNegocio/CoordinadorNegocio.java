package presentacion.coordinadorNegocio;

import dto.EstudianteResponseDTO;
import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import dto.SolicitudLoginDTO;
import fachadas.FachadaInicioSesion;
import fachadas.FachadaSolicitud;
import controles.ControlInicioSesion;
import controles.ControlSolicitud;
import interfaces.*;
import objetosNegocio.*;

public class CoordinadorNegocio implements ICoordinadorNegocio{
    private final IFachadaInicioSesion iFachadaInicioSesion;
    private final IFachadaSolicitud iFachadaSolicitud;
    private final IBecaBO becaBO = new BecaBO();
    private final IBecasFiltradasBO becasFiltradasBO = new BecasFiltradasBO();
    private final IEstudianteBO estudianteBO = new EstudianteBO();
    private final ITutorBO tutorBO =  new TutorBO();
    private final IDocumentoBO documentoBO = new DocumentoBO();
    private final IInformacionSocioeconomicaBO informacionSocioeconomicaBO = new InformacionSocioeconomicaBO();
    private final IHistorialAcademicoBO historialAcademicoBO = new HistorialAcademicoBO();
    private final ISolicitudBO  solicitudBO =  new SolicitudBO();

    public CoordinadorNegocio() {
        ControlInicioSesion controlInicioSesion = new ControlInicioSesion();
        this.iFachadaInicioSesion = new FachadaInicioSesion(controlInicioSesion);
        ControlSolicitud controlSolicitud = new ControlSolicitud(solicitudBO, estudianteBO, tutorBO, becaBO, documentoBO, historialAcademicoBO, informacionSocioeconomicaBO);
        this.iFachadaSolicitud = new FachadaSolicitud(controlSolicitud);
    }


    @Override
    public EstudianteResponseDTO solicitarInicioSesion(SolicitudLoginDTO solicitudLoginDTO) {
        return iFachadaInicioSesion.solicitarLogin(solicitudLoginDTO);
    }

    @Override
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
        return iFachadaSolicitud.obtenerBecasDisponibles(solicitudDTO);
    }

    @Override
    public void SolicitarCerrarSesion() {
        iFachadaInicioSesion.solicitarLogOut();
    }
}
