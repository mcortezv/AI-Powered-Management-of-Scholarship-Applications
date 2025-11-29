package interfaces;
import gobierno.ResolucionDTOGobierno;
import gobierno.SolicitudDTOGobierno;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IFachadaModeloML {

    ResolucionDTOGobierno generarPrediccion(SolicitudDTOGobierno solicitud);
}
