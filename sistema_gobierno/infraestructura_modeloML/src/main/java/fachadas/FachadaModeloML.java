package fachadas;
import controles.ControlModeloML;
import dto.gobierno.ResolucionDTOGobierno;
import dto.gobierno.SolicitudDTOGobierno;
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
    public ResolucionDTOGobierno generarPrediccion(SolicitudDTOGobierno solicitud) {
        return controlModeloML.predecir(solicitud);
    }
}
