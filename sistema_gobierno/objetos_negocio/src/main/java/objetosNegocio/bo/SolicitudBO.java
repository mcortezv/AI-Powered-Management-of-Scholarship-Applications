package objetosNegocio.bo;
import dto.SolicitudDTO;
import objetosNegocio.bo.interfaces.ISolicitudBO;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudBO implements ISolicitudBO {

    @Override
    public boolean cambiarEstado(int id, String nuevoEstado){
        System.out.println("Llama a la DAO");
        return false;
    }

    @Override
    public SolicitudDTO obtenerSolicitud(int id){
        System.out.println("Llama a la DAO");
        return null;
    }

    @Override
    public List<SolicitudDTO> obtenerListadoSolicitudes(int idConvocatoria){
        System.out.println("Llama a la DAO");
        return null;
    }
}
