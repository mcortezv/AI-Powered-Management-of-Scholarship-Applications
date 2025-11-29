package apiGobierno;
import apiGobierno.controles.GobiernoControl;
import apiGobierno.interfaces.IGobiernoAPI;
import gobierno.BecasDisponiblesDTOGobierno;
import gobierno.RequisitosDTOGobierno;
import gobierno.SolicitudDTOGobierno;

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
