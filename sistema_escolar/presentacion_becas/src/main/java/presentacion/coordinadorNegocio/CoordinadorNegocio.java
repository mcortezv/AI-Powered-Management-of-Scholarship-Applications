package presentacion.coordinadorNegocio;
import dto.*;
import dto.itson.LoginDTOItson;
import interfaces.*;
import objetosNegocio.solicitarBeca.excepciones.SolicitudInvalidaException;

/**
 *
 * @author Cortez, Manuel;
 */
public class CoordinadorNegocio implements ICoordinadorNegocio{
    private final IFachadaInicioSesion fachadaInicioSesion;
    private final IFachadaSolicitarBeca fachadaSolicitarBeca;

    public CoordinadorNegocio(IFachadaInicioSesion fachadaInicioSesion, IFachadaSolicitarBeca fachadaSolicitarBeca) {
        this.fachadaInicioSesion = fachadaInicioSesion;
        this.fachadaSolicitarBeca = fachadaSolicitarBeca;
    }

    @Override
    public boolean solicitarInicioSesion(LoginDTOItson solicitudLoginDTO) {
        System.out.println("llego al coordinadorNegocio");
        return fachadaInicioSesion.solicitarLogin(solicitudLoginDTO);
    }

    @Override
    public BecasFiltradasDTO obtenerBecasDisponibles(RequisitosDTO requisitosDTO) {
        return fachadaSolicitarBeca.obtenerBecasFiltradas(requisitosDTO);
    }

    @Override
    public void solicitarCerrarSesion() {
        fachadaInicioSesion.solicitarLogOut();
    }

    public void iniciarSolicitud(BecaDTO becaDTO) throws SolicitudInvalidaException {
        fachadaSolicitarBeca.setBeca(becaDTO);
        fachadaSolicitarBeca.iniciarNuevaSolicitud();
    }

    public void procesarHistorialAcademico(HistorialAcademicoDTO historialAcademicDTO) {
        fachadaSolicitarBeca.setHistorialAcademico(historialAcademicDTO);
    }

    public void procesarEstudiante(EstudianteDTO estudianteDTO) {
        fachadaSolicitarBeca.obtenerEstudiante(estudianteDTO.getMatricula());
    }

    public void procesarTutor(TutorDTO tutorDTO) {
        fachadaSolicitarBeca.setDatosTutor(tutorDTO);
    }

    public void procesarInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomicaDTO) {
        fachadaSolicitarBeca.setInformacionSocioeconomica(informacionSocioeconomicaDTO);
    }

    @Override
    public boolean enviarSolicitudAGobierno(){
        return fachadaSolicitarBeca.guardarSolicitud();
    }
}
