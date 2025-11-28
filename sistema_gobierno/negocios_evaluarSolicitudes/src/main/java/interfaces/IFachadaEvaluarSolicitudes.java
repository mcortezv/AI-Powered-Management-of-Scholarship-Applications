package interfaces;
import dto_gobierno.ResolucionDTO;
import dto_gobierno.SolicitudDTO;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IFachadaEvaluarSolicitudes {

    List<SolicitudDTO> obtenerListadoSolicitudes(int idConvocatoria);

    ResolucionDTO evaluacionAutomatica(SolicitudDTO solicitud);

    boolean resolverSolicitudManual(ResolucionDTO resolucionDTO);

    boolean resolver(ResolucionDTO resolucionDTO);
}
