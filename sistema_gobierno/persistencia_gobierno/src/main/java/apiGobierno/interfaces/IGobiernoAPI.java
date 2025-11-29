package apiGobierno.interfaces;
import gobierno.BecasDisponiblesDTOGobierno;
import gobierno.RequisitosDTOGobierno;
import gobierno.SolicitudDTOGobierno;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IGobiernoAPI {

    boolean guardarSolicitud(SolicitudDTOGobierno solicitudDTO);

    BecasDisponiblesDTOGobierno obtenerBecas(RequisitosDTOGobierno requisitosDTO);
}
