package interfaces;
import dto.gobierno.BecasDisponiblesDTOGobierno;
import dto.gobierno.RequisitosDTOGobierno;
import dto.gobierno.SolicitudDTOGobierno;
import dto_gobierno.SolicitudDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IFachadaGobierno {

    BecasDisponiblesDTOGobierno obtenerBecas(RequisitosDTOGobierno requisitosDTO);

    boolean enviarSolicitud(SolicitudDTOGobierno solicitudDTO);
}
