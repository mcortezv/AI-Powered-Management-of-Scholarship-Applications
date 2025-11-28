package interfaces;
import dto.gobierno.ResolucionDTOGobierno;
import dto.gobierno.SolicitudDTOGobierno;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IFachadaModeloML {

    ResolucionDTOGobierno generarPrediccion(SolicitudDTOGobierno solicitud);
}
