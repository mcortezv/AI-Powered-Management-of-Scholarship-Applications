package controles;
import java.util.List;
import adaptadores.pagarAdeudo.ClaseAdaptador;
import adaptadores.pagarAdeudo.PrestamoAdaptador;
import adaptadores.pagarAdeudo.SolicitudPagoAdaptador;
import banco.ClaseDTOI;
import banco.PrestamoDTOI;
import banco.SolicitudPagoDTOI;
import dtoGobierno.EstudianteDTO;
import interfaces.*;
import interfaces.pagarAdeudo.IAdeudoBO;
import pagarAdeudo.ClaseDTO;
import pagarAdeudo.PrestamoDTO;
import pagarAdeudo.SolicitudPagoDTO;

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
        Long matricula = estudianteDTO.getMatricula();
        return iAdeudoBO.obtenerAdeudoBiblioteca(matricula);
    }

    public double solicitarAdeudoTotalColegiatura(EstudianteDTO estudianteDTO){
        Long matricula = estudianteDTO.getMatricula();
        return iAdeudoBO.obtenerAdeudoColegiatura(matricula);
    }

    public List<PrestamoDTO>solicitarListaPrestamos(EstudianteDTO estudianteDTO){

        Long matricula = estudianteDTO.getMatricula();
        List<PrestamoDTOI> prestamosI = iAdeudoBO.obtenerDetallePrestamo(matricula);
        return prestamosI.stream().map(PrestamoAdaptador::toDTO).toList();
    }

    public List<ClaseDTO> solicitarListaClases(EstudianteDTO estudianteDTO){
        Long matricula = estudianteDTO.getMatricula();
        List<ClaseDTOI> clasesI = iAdeudoBO.obtenerDetalleClase(matricula);
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
