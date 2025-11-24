package fachadas;
import controles.ControlModeloML;
import dto.ResolucionInfraestructuraDTO;
import dto.SolicitudInfraestructuraDTO;
import interfaces.IFachadaModeloML;

/**
 *
 * @author Cortez, Manuel;
 */
public class FachadaModeloML implements IFachadaModeloML {
    private final ControlModeloML controlModeloML;

    public FachadaModeloML(ControlModeloML controlModeloML) {
        this.controlModeloML = controlModeloML;
    }

    @Override
    public ResolucionInfraestructuraDTO generarPrediccion(SolicitudInfraestructuraDTO solicitud) {
        return controlModeloML.predecir(solicitud);
    }
}
