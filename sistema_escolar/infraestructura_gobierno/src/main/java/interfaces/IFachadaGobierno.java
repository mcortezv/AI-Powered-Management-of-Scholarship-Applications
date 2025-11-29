package interfaces;
import gobierno.BecasDisponiblesDTOGobierno;
import gobierno.RequisitosDTOGobierno;
import gobierno.SolicitudDTOGobierno;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IFachadaGobierno {

    BecasDisponiblesDTOGobierno obtenerBecas(RequisitosDTOGobierno requisitosDTO);

    boolean enviarSolicitud(SolicitudDTOGobierno solicitudDTO);
}
