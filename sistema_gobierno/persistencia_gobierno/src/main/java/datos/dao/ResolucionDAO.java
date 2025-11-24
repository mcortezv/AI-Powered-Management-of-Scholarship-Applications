package datos.dao;
import datos.dao.interfaces.IResolucionDAO;
import datos.dominio.Resolucion;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class ResolucionDAO implements IResolucionDAO {

    @Override
    public boolean guardar(Resolucion resolucion){
        return true;
    }

    @Override
    public boolean actualizar(Resolucion resolucion){
        return true;
    }

    @Override
    public Resolucion obtenerPorId(int id){
        return null;
    }

    @Override
    public Resolucion obtenerPorFiltro(String tipoFiltro, String filtro){
        return null;
    }

    @Override
    public List<Resolucion> obtenerTodas(){
        return null;
    }
}
