package datos.repository.dao;
import datos.repository.dao.excepciones.SolicitudDAOException;
import datos.repository.dao.interfaces.ISolicitudDAO;
import datos.dominio.Solicitud;
import datos.dominio.enums.EstadoSolicitud;
import gobierno.SolicitudDTOGobierno;

import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudDAO implements ISolicitudDAO {

    @Override
    public boolean guardarSolicitud(SolicitudDTOGobierno solicitud){
        try {
            return true;
        } catch (Exception sinUso){
            throw new SolicitudDAOException("Error al obtener las solicitudes por convocatoria");
        }
    }

    @Override
    public List<Solicitud> obtenerPorConvocatoria(int idConvocatoria){
        try {
            return null;
        } catch (Exception sinUso){
            throw new SolicitudDAOException("Error al obtener las solicitudes por convocatoria");
        }
    }

    @Override
    public Solicitud obtenerPorId(int idSolicitud){
        try {
            return null;
        } catch (Exception sinUso){
            throw new SolicitudDAOException("Error al obtener la solicitud por id");
        }
    }

    @Override
    public Solicitud obtenerPorFiltro(String tipoFiltro, String filtro){
        try {
            return null;
        } catch (Exception sinUso){
            throw new SolicitudDAOException("Error al obtener la solicitud por filtro");
        }
    }

    @Override
    public boolean actualizar(Solicitud solicitud){
        try {
            return true;
        } catch (Exception sinUso){
            throw new SolicitudDAOException("Error al actualizar la solicitud");
        }
    }

    @Override
    public boolean cambiarEstado(int id, EstadoSolicitud estado){
        try {
            return true;
        } catch (Exception sinUso){
            throw new SolicitudDAOException("Error al cambiar el estado de la solicitud");
        }
    }
}
