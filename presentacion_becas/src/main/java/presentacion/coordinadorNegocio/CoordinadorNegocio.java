package presentacion.coordinadorNegocio;
import dto.BecasFiltradasDTO;
import dto.LoginDTO;
import dto.RequisitosDTO;
import interfaces.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class CoordinadorNegocio implements ICoordinadorNegocio{
    private final IFachadaInicioSesion fachadaInicioSesion;
    private final IFachadaSolicitarBeca fachadaSolicitarBeca;
    private final IBecasFiltradasBO becasFiltradasBO;
    private final IDocumentoBO documentoBO;
    private final IEstudianteBO estudianteBO;
    private final IHistorialAcademicoBO historialAcademicoBO;
    private final IInformacionSocioeconomicaBO informacionSocioeconomicaBO;
    private final ISolicitudBO solicitudBO;
    private final ITutorBO tutorBO;

    public CoordinadorNegocio(IBecasFiltradasBO becasFiltradasBO, IFachadaInicioSesion fachadaInicioSesion, IFachadaSolicitarBeca fachadaSolicitarBeca, IDocumentoBO documentoBO, IEstudianteBO estudianteBO, IHistorialAcademicoBO historialAcademicoBO, IInformacionSocioeconomicaBO informacionSocioeconomicaBO, ISolicitudBO solicitudBO, ITutorBO tutorBO) {
        this.becasFiltradasBO = becasFiltradasBO;
        this.fachadaInicioSesion = fachadaInicioSesion;
        this.fachadaSolicitarBeca = fachadaSolicitarBeca;
        this.documentoBO = documentoBO;
        this.estudianteBO = estudianteBO;
        this.historialAcademicoBO = historialAcademicoBO;
        this.informacionSocioeconomicaBO = informacionSocioeconomicaBO;
        this.solicitudBO = solicitudBO;
        this.tutorBO = tutorBO;
    }

    @Override
    public boolean solicitarInicioSesion(LoginDTO solicitudLoginDTO) {
        return fachadaInicioSesion.solicitarLogin(solicitudLoginDTO);
    }

    @Override
    public BecasFiltradasDTO obtenerBecasDisponibles(RequisitosDTO requisitosDTO) {
        return fachadaSolicitarBeca.obtenerBecasDisponibles(requisitosDTO);
    }

    @Override
    public void solicitarCerrarSesion() {
        fachadaInicioSesion.solicitarLogOut();
    }


    @Override
    public boolean enviarSolicitudAGobierno(){
        return fachadaSolicitarBeca.enviarSolicitudGobierno();
    }
}
