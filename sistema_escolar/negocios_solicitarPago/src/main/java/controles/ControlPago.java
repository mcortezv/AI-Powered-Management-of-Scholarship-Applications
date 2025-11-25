package controles;
import java.util.List;
import java.util.Objects;

import dto.EstudianteDTO;
import dto.pagarAdeudo.ClaseDTO;
import dto.pagarAdeudo.PrestamoDTO;
import dto.pagarAdeudo.SolicitudPagoDTO;
import interfaces.*;
import interfaces.pagarAdeudo.IAdeudoBO;

public class ControlPago {
   private IAdeudoBO iAdeudoBO;
   private IFachadaBanco iFachadaBanco;
    private IFachadaPayPal iFachadaPayPal;

    public ControlPago(IAdeudoBO adeudoBO, IFachadaBanco iFachadaBanco, IFachadaPayPal fachadaPayPal){
        this.iAdeudoBO = adeudoBO;
        this.iFachadaPayPal = fachadaPayPal;
        this.iFachadaBanco = iFachadaBanco;
    }

    public double solicitarAdeudoTotalBiblioteca(EstudianteDTO estudianteDTO) {
        String matriculaString = String.valueOf(estudianteDTO.getMatricula());
        return iAdeudoBO.obtenerAdeudoBiblioteca(matriculaString);
    }

    public double solicitarAdeudoTotalColegiatura(EstudianteDTO estudianteDTO){
        String matriculaString = String.valueOf(estudianteDTO.getMatricula());
        return iAdeudoBO.obtenerAdeudoColegiatura(matriculaString);
    }

    public List<PrestamoDTO>solicitarListaPrestamos(EstudianteDTO estudianteDTO){
        String matriculaString = String.valueOf(estudianteDTO.getMatricula());
        return iAdeudoBO.obtenerDetallePrestamo(matriculaString);
    }

    public List<ClaseDTO> solicitarListaClases(EstudianteDTO estudianteDTO){
        String matriculaString = String.valueOf(estudianteDTO.getMatricula());
        return iAdeudoBO.obtenerDetalleClase(matriculaString);
    }

    public SolicitudPagoDTO solicitarRealizarPagoBanco(SolicitudPagoDTO solicitudPagoDTO){
        return iFachadaBanco.ejecutarPago(solicitudPagoDTO);
    }

    public SolicitudPagoDTO solicitarRealizarPagoPayPal(SolicitudPagoDTO solicitudPagoDTO){
        return iFachadaPayPal.ejecutarPago(solicitudPagoDTO);
    }

    public boolean notificarLiquidacion(SolicitudPagoDTO solicitudPagoDTO){
        return iAdeudoBO.enviarSolicitudPago(solicitudPagoDTO);
    }



}
