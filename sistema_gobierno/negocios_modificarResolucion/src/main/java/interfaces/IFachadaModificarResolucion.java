package interfaces;
import dto.ResolucionDTO;
import dto.SolicitudDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IFachadaModificarResolucion {

    ResolucionDTO buscarResolucion(String nombre, String filtro);

    ResolucionDTO resolverAtomatico(SolicitudDTO solicitud);

    boolean resolverManual(ResolucionDTO resolucionDTO);

    boolean modificarResolucion(ResolucionDTO resolucionDTO);
}
