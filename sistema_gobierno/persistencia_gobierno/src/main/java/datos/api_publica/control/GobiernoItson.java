package datos.api_publica.control;
import datos.dto.BecasResponseDTOI;
import datos.dto.RequisitosDTOI;
import datos.services.BecasService;
import datos.services.SolicitudService;
import dto.SolicitudDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class GobiernoItson {
    private final SolicitudService solicitudService;
    private final BecasService becasService;

    public GobiernoItson() {
        this.solicitudService = new SolicitudService(new datos.dao.SolicitudDAO());
        this.becasService= new BecasService(new datos.dao.BecaDAO());
    }

    public boolean guardarSolicitud(SolicitudDTO dto){
        return solicitudService.guardarSolicitud(dto);
    }
    
    public BecasResponseDTOI obtenerBecas(RequisitosDTOI requisitosDTOI){
        return becasService.obtenerBecas(requisitosDTOI);
        
    }
            
}