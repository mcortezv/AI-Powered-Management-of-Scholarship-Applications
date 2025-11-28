package datos.api_publica.interfaz;
import dto.gobierno.BecasDisponiblesDTOGobierno;
import dto.gobierno.RequisitosDTOGobierno;
import dto.gobierno.SolicitudDTOGobierno;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IGobiernoAPI {

    boolean guardarSolicitud(SolicitudDTOGobierno solicitudDTO);

    BecasDisponiblesDTOGobierno obtenerBecas(RequisitosDTOGobierno requisitosDTO);
}
