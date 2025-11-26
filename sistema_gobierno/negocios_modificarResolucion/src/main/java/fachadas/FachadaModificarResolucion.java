package fachadas;
import controles.ControlModificarResolucion;
import dto.ResolucionDTO;
import dto.SolicitudDTO;
import interfaces.IFachadaModificarResolucion;

/**
 *
 * @author Cortez, Manuel;
 */
public class FachadaModificarResolucion implements IFachadaModificarResolucion {
    private final ControlModificarResolucion controlModificarResolucion;

    public FachadaModificarResolucion(ControlModificarResolucion controlModificarResolucion) {
        this.controlModificarResolucion = controlModificarResolucion;
    }

    @Override
    public ResolucionDTO buscarResolucion(String nombre, String filtro){
        return controlModificarResolucion.buscarResolucion(nombre, filtro);
    }

    @Override
    public ResolucionDTO resolverAtomatico(SolicitudDTO solicitud){
        return controlModificarResolucion.resolverAtomatico(solicitud);
    }

    @Override
    public boolean resolverManual(ResolucionDTO resolucionDTO){
        return controlModificarResolucion.resolverManual(resolucionDTO);
    }

    @Override
    public boolean modificarResolucion(ResolucionDTO resolucionDTO){
        return controlModificarResolucion.modificarResolucion(resolucionDTO);
    }
}
