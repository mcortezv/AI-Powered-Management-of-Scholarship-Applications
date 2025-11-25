package controles;
import java.util.List;

import adaptadores.pagarAdeudo.ClaseAdaptador;
import adaptadores.pagarAdeudo.PrestamoAdaptador;
import adaptadores.pagarAdeudo.SolicitudPagoAdaptador;
import dto.EstudianteDTO;
import dto.pagarAdeudo.*;
import interfaces.*;
import interfaces.pagarAdeudo.IAdeudoBO;

public class ControlPago {
   private final IAdeudoBO iAdeudoBO;
   private final IFachadaBanco iFachadaBanco;
    private final IFachadaPayPal iFachadaPayPal;

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
        List<PrestamoDTOI> prestamosI = iAdeudoBO.obtenerDetallePrestamo(matriculaString);
        return prestamosI.stream().map(PrestamoAdaptador::toDTO).toList();
    }

    public List<ClaseDTO> solicitarListaClases(EstudianteDTO estudianteDTO){
        String matriculaString = String.valueOf(estudianteDTO.getMatricula());
        List<ClaseDTOI> clasesI = iAdeudoBO.obtenerDetalleClase(matriculaString);
        return clasesI.stream().map(ClaseAdaptador::toDTO).toList();
    }

    public SolicitudPagoDTO solicitarRealizarPagoBanco(SolicitudPagoDTO solicitudPagoDTO){
        return iFachadaBanco.ejecutarPago(solicitudPagoDTO);
    }

    public SolicitudPagoDTO solicitarRealizarPagoPayPal(SolicitudPagoDTO solicitudPagoDTO){
        return iFachadaPayPal.ejecutarPago(solicitudPagoDTO);
    }

    public boolean notificarLiquidacion(SolicitudPagoDTO solicitudPagoDTO){
        SolicitudPagoDTOI solicitudPagoDTOI = SolicitudPagoAdaptador.toDTOI(solicitudPagoDTO);
        return iAdeudoBO.enviarSolicitudPago(solicitudPagoDTOI);
    }



}
