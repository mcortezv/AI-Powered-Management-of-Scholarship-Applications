package objetosNegocio.pagarAdeudo;

import dto.pagarAdeudo.ClaseDTO;
import dto.pagarAdeudo.PrestamoDTO;
import dto.pagarAdeudo.SolicitudPagoDTO;
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
    public List<PrestamoDTO> obtenerDetallePrestamo(String matriculaEstudiante) {
        return List.of();
    }

    @Override
    public List<ClaseDTO> obtenerDetalleClase(String matriculaEstudiante) {
        return List.of();
    }

    @Override
    public boolean enviarSolicitudPago(SolicitudPagoDTO solicitudPagoDTO) {
        return false;
    }
}
