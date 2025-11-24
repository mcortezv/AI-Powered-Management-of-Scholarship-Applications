package interfaces;
import dto.ResolucionInfraestructuraDTO;
import dto.SolicitudInfraestructuraDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IFachadaModeloML {

    ResolucionInfraestructuraDTO generarPrediccion(SolicitudInfraestructuraDTO solicitud);
}
