package presentacion.coordinadorNegocio;
import dto.BecasFiltradasDTO;
import dto.RequisitosDTO;
import dto.itson.LoginDTOItson;
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


    @Override
    public boolean enviarSolicitudAGobierno(){
        return true;//fachadaSolicitarBeca.enviarSolicitudGobierno();
    }
}
