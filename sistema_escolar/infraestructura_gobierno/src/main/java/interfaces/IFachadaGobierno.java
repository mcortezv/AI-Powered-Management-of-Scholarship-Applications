package interfaces;
import dto.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IFachadaGobierno {

    BecasDisponiblesResponseDTO obtenerBecas(RequisitosDTO requisitosDTO);

    boolean enviarSolicitud(SolicitudDTO solicitudDTO);
}
