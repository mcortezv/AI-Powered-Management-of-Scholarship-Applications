package presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo;

import dtoGobierno.EstudianteDTO;
import pagarAdeudo.ClaseDTO;
import pagarAdeudo.PrestamoDTO;
import pagarAdeudo.SolicitudPagoDTO;
import interfaces.IFachadaPago;
import presentacion.CoordinadorAplicacion;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo.CoordinadorNegocioPagarAdeudo;
import presentacion.pagarAdeudo.mainFraimePagarAdeudo.MainFramePagarAdeudo;
import presentacion.pagarAdeudo.panels.ListaClasesColegiatura;
import presentacion.pagarAdeudo.panels.ListaPrestamosBiblioteca;
import solicitarBeca.dominio.enums.pagarAdeudo.MetodoPago;

import java.util.List;

public class CoordinadorAplicacionPagarAdeudo implements ICoordinadorAplicacionPagarAdeudo {
    private final CoordinadorAplicacion coordinadorPadre;
    private MainFramePagarAdeudo mainFrame;
    private final CoordinadorNegocioPagarAdeudo coordinadorNegocioPagarAdeudo;
    private PagarAdeudo pagarAdeudo;

    public CoordinadorAplicacionPagarAdeudo(IFachadaPago fachadaPago, CoordinadorAplicacion coordinadorPadre) {
        this.coordinadorPadre = coordinadorPadre;
        coordinadorNegocioPagarAdeudo = new CoordinadorNegocioPagarAdeudo(fachadaPago);
        mainFrame = null;
    }

    public void pagarAdeudo() {
        if (mainFrame != null) {
            mainFrame.setVisible(false);
        }
        pagarAdeudo = new PagarAdeudo(coordinadorPadre,this);
        pagarAdeudo.setVisible(true);
    }

    public void regresarAlMenuPrincipal() {
        if (pagarAdeudo != null) {
            pagarAdeudo.dispose();
        }
        coordinadorPadre.mostrarMainFrame();
    }

    @Override
    public void seleccionarAdeudoBiblioteca(EstudianteDTO estudianteDTO) {
        double adeudo = coordinadorNegocioPagarAdeudo.obtenerAdeudoBiblioteca(estudianteDTO);
        List<PrestamoDTO> listaPrestamos = coordinadorNegocioPagarAdeudo.obtenerListaPrestamos(estudianteDTO);

        ListaPrestamosBiblioteca panel = (ListaPrestamosBiblioteca) pagarAdeudo.getPanel("listaPrestamosBiblioteca");

        panel.setAdeudo(adeudo);
        panel.setPrestamos(listaPrestamos);

        pagarAdeudo.showPanel("listaPrestamosBiblioteca");
    }

    @Override
    public void seleccionarAdeudoColegiatura(EstudianteDTO estudianteDTO) {
        double adeudo = coordinadorNegocioPagarAdeudo.obtenerAdeudoColegiatura(estudianteDTO);
        List<ClaseDTO> listaClases = coordinadorNegocioPagarAdeudo.obtenerListaClases(estudianteDTO);

        ListaClasesColegiatura panel =
                (ListaClasesColegiatura) pagarAdeudo.getPanel("listaClasesColegiatura");

        panel.setAdeudo(adeudo);
        panel.setClases(listaClases);

        pagarAdeudo.showPanel("listaClasesColegiatura");
    }

    @Override
    public void seleccionarRealizarPago() {
        pagarAdeudo.showPanel("metodosDePago");
    }

    @Override
    public void seleccionarMetodoPago(String metodoPago) throws Exception {

        SolicitudPagoDTO solicitudPagoDTO = new SolicitudPagoDTO();
        solicitudPagoDTO.setEstatusPago("Pendiente");
        solicitudPagoDTO.setIdEstudiante("87249L");

        if (metodoPago.equals("BANCO")) {
            coordinadorNegocioPagarAdeudo.realizarPago(solicitudPagoDTO, MetodoPago.BANCO);
        }
        if (metodoPago.equals("PAYPAL")) {
            coordinadorNegocioPagarAdeudo.realizarPago(solicitudPagoDTO, MetodoPago.PAYPAL);
        }
    }

    @Override
    public void verDetalle() { }

    public void setPagarAdeudo(PagarAdeudo pagarAdeudo) {
        this.pagarAdeudo = pagarAdeudo;
    }

}
