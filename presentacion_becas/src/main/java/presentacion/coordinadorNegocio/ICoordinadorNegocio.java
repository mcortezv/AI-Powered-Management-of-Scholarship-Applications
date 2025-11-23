package presentacion.coordinadorNegocio;
import dto.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ICoordinadorNegocio {

    boolean solicitarInicioSesion(LoginDTO solicitudLoginDTO);

    BecasDisponiblesResponseDTO obtenerBecasDisponibles(RequisitosDTO requisitosDTO);

    void solicitarCerrarSesion();

    boolean enviarSolicitudAGobierno();
}
