package datosGobierno.repositoryGobierno.daoGobierno.interfacesGobierno;
import datosGobierno.dominioGobierno.Solicitud;
import datosGobierno.dominioGobierno.enums.EstadoSolicitud;
import gobierno.SolicitudDTOGobierno;

import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ISolicitudDAO {

    boolean guardarSolicitud(SolicitudDTOGobierno solicitud);

    List<Solicitud> obtenerPorConvocatoria(int idConvocatoria);

    Solicitud obtenerPorId(int idSolicitud);

    Solicitud obtenerPorFiltro(String tipoFiltro, String filtro);

    boolean actualizar(Solicitud solicitud);

    boolean cambiarEstado(int id, EstadoSolicitud estado);
}
