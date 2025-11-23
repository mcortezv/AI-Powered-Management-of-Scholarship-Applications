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

    public CoordinadorNegocio(IFachadaInicioSesion fachadaInicioSesion, IFachadaSolicitarBeca fachadaSolicitarBeca) {
        this.fachadaInicioSesion = fachadaInicioSesion;
        this.fachadaSolicitarBeca = fachadaSolicitarBeca;
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
        return true;//fachadaSolicitarBeca.enviarSolicitudGobierno();
    }
}
