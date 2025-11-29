package presentacion.interfaces;
import itson.LoginDTOItson;
import solicitarBeca.BecasFiltradasDTO;
import solicitarBeca.EstudianteDTO;
import solicitarBeca.RequisitosDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ICoordinadorNegocio {

    boolean solicitarInicioSesion(LoginDTOItson solicitudLoginDTO);

    BecasFiltradasDTO obtenerBecasDisponibles(RequisitosDTO requisitosDTO);

    void solicitarCerrarSesion();

    boolean enviarSolicitudAGobierno();

    EstudianteDTO getEstudianteLogueado();
}
