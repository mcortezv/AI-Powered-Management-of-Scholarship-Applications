package interfaces;
import dto.ResolucionDTO;
import dto.SolicitudDTO;
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
