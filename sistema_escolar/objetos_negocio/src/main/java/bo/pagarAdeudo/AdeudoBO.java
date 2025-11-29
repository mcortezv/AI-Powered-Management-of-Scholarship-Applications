package bo.pagarAdeudo;

import banco.ClaseDTOI;
import banco.PrestamoDTOI;
import banco.SolicitudPagoDTOI;
import interfaces.IFachadaITSON;
import interfaces.pagarAdeudo.IAdeudoBO;

import java.util.List;

public class AdeudoBO implements IAdeudoBO {
    private IFachadaITSON iFachadaITSON;

    @Override
    public double obtenerAdeudoBiblioteca(String matriculaEstudiante) {
        return iFachadaITSON.solicitarAdeudoBiblioteca(matriculaEstudiante);
    }

    @Override
    public double obtenerAdeudoColegiatura(String matriculaEstudiante) {
        return iFachadaITSON.solicitarAdeudoColegiatura(matriculaEstudiante);
    }

    @Override
    public List<PrestamoDTOI> obtenerDetallePrestamo(String matriculaEstudiante) {
        return iFachadaITSON.solicitarListaPrestamso(matriculaEstudiante);
    }

    @Override
    public List<ClaseDTOI> obtenerDetalleClase(String matriculaEstudiante) {
        return iFachadaITSON.solicitarListaClases(matriculaEstudiante);
    }

    @Override
    public boolean enviarSolicitudPago(SolicitudPagoDTOI solicitudPagoDTO) {
        return iFachadaITSON.notificarLiquidacion(solicitudPagoDTO);
    }
}
