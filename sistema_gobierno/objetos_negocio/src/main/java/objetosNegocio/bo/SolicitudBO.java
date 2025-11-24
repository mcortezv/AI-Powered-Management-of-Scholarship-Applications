package objetosNegocio.bo;
import datos.dao.interfaces.ISolicitudDAO;
import dto.SolicitudDTO;
import objetosNegocio.bo.interfaces.ISolicitudBO;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudBO implements ISolicitudBO {
    private final ISolicitudDAO solicitudDAO;

    public SolicitudBO(ISolicitudDAO solicitudDAO) {
        this.solicitudDAO = solicitudDAO;
    }

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
