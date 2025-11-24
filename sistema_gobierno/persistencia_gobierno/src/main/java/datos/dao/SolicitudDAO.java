package datos.dao;
import datos.dao.interfaces.ISolicitudDAO;
import datos.dominio.Solicitud;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudDAO implements ISolicitudDAO {

    @Override
    public List<Solicitud> obtenerPorConvocatoria(int idConvocatoria){
        return null;
    }

    @Override
    public Solicitud obtenerPorId(int idSolicitud){
        return null;
    }

    @Override
    public Solicitud obtenerPorFiltro(String tipoFiltro, String filtro){
        return null;
    }

    @Override
    public boolean actualizar(Solicitud solicitud){
        return true;
    }
}
