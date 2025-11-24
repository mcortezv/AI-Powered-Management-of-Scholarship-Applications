package presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo;

import dto.EstudianteDTO;
import dto.pagarAdeudo.ClaseDTO;
import dto.pagarAdeudo.PrestamoDTO;
import dto.pagarAdeudo.SolicitudPagoDTO;
import interfaces.IFachadaPago;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo.CoordinadorNegocioPagarAdeudo;
import presentacion.pagarAdeudo.mainFraimePagarAdeudo.MainFramePagarAdeudo;
import presentacion.pagarAdeudo.panels.ListaClasesColegiatura;
import presentacion.pagarAdeudo.panels.ListaPrestamosBiblioteca;
import solicitarBeca.dominio.enums.pagarAdeudo.MetodoPago;

import java.util.List;

public class CoordinadorAplicacionPagarAdeudo implements ICoordinadorAplicacionPagarAdeudo{
    private final MainFramePagarAdeudo mainFrame;
    private final CoordinadorNegocioPagarAdeudo coordinadorNegocioPagarAdeudo;
    private PagarAdeudo pagarAdeudo;

    public CoordinadorAplicacionPagarAdeudo(IFachadaPago fachadaPago) {
        coordinadorNegocioPagarAdeudo = new CoordinadorNegocioPagarAdeudo(fachadaPago);
        mainFrame = new MainFramePagarAdeudo(this);
        mainFrame.setVisible(true);
    }

    public void pagarAdeudo(){
        mainFrame.setVisible(false);
        pagarAdeudo = new PagarAdeudo(this);
        pagarAdeudo.setVisible(true);
    }

    @Override
    public void seleccionarAdeudoBiblioteca() {
        // cambiar a que el dto se haga en el panel y llegue por medio del parametro el dto
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setMatricula(87249L);

        double adeudo = coordinadorNegocioPagarAdeudo.obtenerAdeudoBiblioteca(estudianteDTO);
        List<PrestamoDTO> listaPrestamos = coordinadorNegocioPagarAdeudo.obtenerListaPrestamos(estudianteDTO);
        ListaPrestamosBiblioteca panel = (ListaPrestamosBiblioteca) pagarAdeudo.getPanel("listaPrestamos");
        panel.setAdeudo(adeudo);
        panel.setPrestamos(listaPrestamos);
        pagarAdeudo.showPanel("listaPrestamos");
    }

    @Override
    public void seleccionarAdeudoColegiatura() {
        // cambiar a que el dto se haga en el panel y llegue por medio del parametro el dto
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setMatricula(87249L);

        double adeudo = coordinadorNegocioPagarAdeudo.obtenerAdeudoColegiatura(estudianteDTO);
        List<ClaseDTO> listaPrestamos = coordinadorNegocioPagarAdeudo.obtenerListaClases(estudianteDTO);
        ListaClasesColegiatura panel = (ListaClasesColegiatura) pagarAdeudo.getPanel("listaPrestamos");
        panel.setAdeudo(adeudo);
        panel.setClases(listaPrestamos);
        pagarAdeudo.showPanel("listaClases");
    }

    @Override
    public void seleccionarRealizarPago() {
        pagarAdeudo.showPanel("metodosDePago");;
    }

    @Override
    public void seleccionarMetodoPago(String metodoPago) throws Exception {
        // cambiar a que el dto se haga en el panel y llegue por medio del parametro el dto
        SolicitudPagoDTO solicitudPagoDTO = new SolicitudPagoDTO();
        solicitudPagoDTO.setEstatusPago("Pendiente");
        solicitudPagoDTO.setIdEstudiante("87249L");

        if(metodoPago == "BANCO"){
            coordinadorNegocioPagarAdeudo.realizarPago(solicitudPagoDTO, MetodoPago.BANCO);
        }
        if(metodoPago == "PAYPAL"){
            coordinadorNegocioPagarAdeudo.realizarPago(solicitudPagoDTO, MetodoPago.PAYPAL);
        }
    }

    @Override
    public void verDetalle() {

    }


}
