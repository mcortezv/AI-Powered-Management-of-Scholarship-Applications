package solicitarBeca.dao;
import solicitarBeca.dao.interfaces.ISolicitudDAO;
import solicitarBeca.dominio.Solicitud;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudDAO implements ISolicitudDAO {

    public void create(Solicitud solicitud){
        System.out.println("Mongo DB");
    }
}
