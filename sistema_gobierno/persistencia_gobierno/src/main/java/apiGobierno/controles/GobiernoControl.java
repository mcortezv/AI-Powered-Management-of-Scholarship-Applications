package apiGobierno.controles;
import datos.adaptadores.BecasFiltradasAdaptador;
import datos.services.BecasService;
import datos.services.SolicitudService;
import gobierno.BecasDisponiblesDTOGobierno;
import gobierno.RequisitosDTOGobierno;
import gobierno.SolicitudDTOGobierno;

/**
 *
 * @author Cortez, Manuel;
 */
public class GobiernoControl {
    private final SolicitudService solicitudService;
    private final BecasService becasService;

    public GobiernoControl() {
        this.solicitudService = new SolicitudService();
        this.becasService= new BecasService();
    }

    public boolean guardarSolicitud(SolicitudDTOGobierno dto){
        return solicitudService.guardarSolicitud(dto);
    }

    public BecasDisponiblesDTOGobierno obtenerBecas(RequisitosDTOGobierno requisitosDTO) {
        return BecasFiltradasAdaptador.toDTOGobierno(becasService.obtenerBecas(requisitosDTO));
    }
            
}