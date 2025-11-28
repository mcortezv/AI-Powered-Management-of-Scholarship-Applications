package interfaces;
import dto_gobierno.ResolucionDTO;
import dto_gobierno.SolicitudDTO;

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
