package objetosNegocio.bo;
import datos.dao.interfaces.IResolucionDAO;
import datos.dominio.Resolucion;
import datos.dominio.Solicitud;
import datos.dominio.enums.Decision;
import dto.ResolucionInfraestructuraDTO;
import dto.SolicitudInfraestructuraDTO;
import interfaces.IFachadaModeloML;
import objetosNegocio.bo.excepciones.ResolucionBOException;
import objetosNegocio.bo.interfaces.IResolucionBO;
import java.time.LocalDate;

/**
 *
 * @author Cortez, Manuel;
 */
public class ResolucionBO implements IResolucionBO {
    private final IResolucionDAO resolucionDAO;
    private final IFachadaModeloML fachadaModeloML;

    public ResolucionBO(IResolucionDAO resolucionDAO, IFachadaModeloML fachadaModeloML) {
        this.resolucionDAO = resolucionDAO;
        this.fachadaModeloML = fachadaModeloML;
    }

    @Override
    public Resolucion crearResolucion(Solicitud solicitud, Decision decision, String motivo, LocalDate fechaEvaluacion){
        try {
            Resolucion resolucion = new Resolucion();
            resolucion.setSolicitud(solicitud);
            resolucion.setDecision(decision);
            resolucion.setMotivo(motivo);
            resolucion.setFechaEvaluacion(fechaEvaluacion);
            return  resolucion;
        } catch (Exception sinUso) {
            throw new ResolucionBOException("Error al crear resolucion");
        }
    }

    @Override
    public boolean resolver(Resolucion resolucion){
        try {
            return resolucionDAO.guardar(resolucion);
        } catch (Exception ex) {
            throw new ResolucionBOException(ex.getMessage());
        }
    }

    @Override
    public ResolucionInfraestructuraDTO crearResolucionAutomatica(SolicitudInfraestructuraDTO solicitud) {
        try {
            return fachadaModeloML.generarPrediccion(solicitud);
        } catch (Exception ex) {
            throw new ResolucionBOException(ex.getMessage());
        }
    }

    @Override
    public Resolucion obtenerResolucion(int id){
        try {
            return resolucionDAO.obtenerPorId(id);
        } catch (Exception ex) {
            throw new ResolucionBOException(ex.getMessage());
        }
    }

    @Override
    public Resolucion obtenerResolucionPorFiltro(String tipoFiltro, String filtro) {
        try {
            return resolucionDAO.obtenerPorFiltro(tipoFiltro, filtro);
        } catch (Exception ex) {
            throw new ResolucionBOException(ex.getMessage());
        }
    }

    @Override
    public boolean actualizarResolucion(Resolucion resolucion){
        try {
            return resolucionDAO.actualizar(resolucion);
        } catch (Exception ex) {
            throw new ResolucionBOException(ex.getMessage());
        }
    }
}
