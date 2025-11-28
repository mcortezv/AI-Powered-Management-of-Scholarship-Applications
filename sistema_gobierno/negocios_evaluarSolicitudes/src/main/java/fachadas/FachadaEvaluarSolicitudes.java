package fachadas;
import controles.ControlEvaluarSolicitudes;
import dto_gobierno.ResolucionDTO;
import dto_gobierno.SolicitudDTO;
import interfaces.IFachadaEvaluarSolicitudes;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class FachadaEvaluarSolicitudes implements IFachadaEvaluarSolicitudes {
    private final ControlEvaluarSolicitudes controlEvaluarSolicitudes;

    public FachadaEvaluarSolicitudes(ControlEvaluarSolicitudes controlEvaluarSolicitudes) {
        this.controlEvaluarSolicitudes = controlEvaluarSolicitudes;
    }

    @Override
    public List<SolicitudDTO> obtenerListadoSolicitudes(int idConvocatoria){
        return controlEvaluarSolicitudes.obtenerListadoSolicitudes(idConvocatoria);
    }

    @Override
    public ResolucionDTO evaluacionAutomatica(SolicitudDTO solicitud){
        return controlEvaluarSolicitudes.evaluacionAutomatica(solicitud);
    }

    @Override
    public boolean resolverSolicitudManual(ResolucionDTO resolucionDTO) {
        return controlEvaluarSolicitudes.resolverSolicitudManual(resolucionDTO);
    }

    @Override
    public boolean resolver(ResolucionDTO resolucionDTO){
        return controlEvaluarSolicitudes.resolver(resolucionDTO);
    }
}
