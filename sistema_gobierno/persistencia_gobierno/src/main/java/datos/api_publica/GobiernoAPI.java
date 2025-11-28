package datos.api_publica;
import datos.api_publica.control.GobiernoControl;
import datos.api_publica.interfaz.IGobiernoAPI;
import dto.gobierno.BecasDisponiblesDTOGobierno;
import dto.gobierno.RequisitosDTOGobierno;
import dto.gobierno.SolicitudDTOGobierno;

/**
 *
 * @author Cortez, Manuel;
 */
public class GobiernoAPI implements IGobiernoAPI {
    private final GobiernoControl gobiernoControl;

    public GobiernoAPI(){
        this.gobiernoControl = new GobiernoControl();
    }

    @Override
    public boolean guardarSolicitud(SolicitudDTOGobierno solicitudDTO){
        return gobiernoControl.guardarSolicitud(solicitudDTO);
    }

    @Override
    public BecasDisponiblesDTOGobierno obtenerBecas(RequisitosDTOGobierno requisitosDTO) {
        return gobiernoControl.obtenerBecas(requisitosDTO);
    }
}
