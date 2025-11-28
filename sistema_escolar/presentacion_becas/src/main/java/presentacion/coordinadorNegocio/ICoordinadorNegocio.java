package presentacion.coordinadorNegocio;
import dto.*;
import dto.itson.LoginDTOItson;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ICoordinadorNegocio {

    boolean solicitarInicioSesion(LoginDTOItson solicitudLoginDTO);

    BecasFiltradasDTO obtenerBecasDisponibles(RequisitosDTO requisitosDTO);

    void solicitarCerrarSesion();

    boolean enviarSolicitudAGobierno();
}
