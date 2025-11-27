package interfaces;
import dto.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IFachadaGobierno {

    BecasFiltradasDTO obtenerBecas(RequisitosDTO requisitosDTO);

    boolean enviarSolicitud(SolicitudDTO solicitudDTO);
}
