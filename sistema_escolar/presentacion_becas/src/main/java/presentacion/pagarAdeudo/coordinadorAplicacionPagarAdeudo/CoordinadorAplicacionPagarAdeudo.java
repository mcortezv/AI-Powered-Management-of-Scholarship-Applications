package presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo;

import bo.sesion.SesionUsuario;
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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CoordinadorAplicacionPagarAdeudo implements ICoordinadorAplicacionPagarAdeudo {
    private final CoordinadorAplicacion coordinadorPadre;
    private final MainFramePagarAdeudo mainFrame;
    private final CoordinadorNegocioPagarAdeudo coordinadorNegocioPagarAdeudo;
    private PagarAdeudo pagarAdeudo;
    private String tipoAdeudo;

    private List<PrestamoDTO> prestamos;
    private List<ClaseDTO> clases;
    private Double adeudoBibliotecaCache;
    private Double adeudoColegiaturaCache;
    private final SolicitudPagoDTO solicitudPagoDTO;
    public CoordinadorAplicacionPagarAdeudo(IFachadaPago fachadaPago, CoordinadorAplicacion coordinadorPadre) {
        this.coordinadorPadre = coordinadorPadre;
        coordinadorNegocioPagarAdeudo = new CoordinadorNegocioPagarAdeudo(fachadaPago);
        mainFrame = null;
        solicitudPagoDTO = new SolicitudPagoDTO();
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
        limpiarCache();
        coordinadorPadre.mostrarMainFrame();
    }

    @Override
    public void seleccionarAdeudoBiblioteca(EstudianteDTO estudianteDTO) {
        this.setTipoAdeudo("Biblioteca");
        if (this.prestamos == null) {
            System.out.println("Consultando API (Biblioteca)...");
            this.prestamos = coordinadorNegocioPagarAdeudo.obtenerListaPrestamos(estudianteDTO);
            this.adeudoBibliotecaCache = coordinadorNegocioPagarAdeudo.calcularTotalPrestamos(this.prestamos);
        }
        ListaPrestamosBiblioteca panel = (ListaPrestamosBiblioteca) pagarAdeudo.getPanel("listaPrestamosBiblioteca");
        panel.setAdeudo(this.adeudoBibliotecaCache);
        panel.setPrestamos(this.prestamos);
        pagarAdeudo.showPanel("listaPrestamosBiblioteca");
    }

    @Override
    public void seleccionarAdeudoColegiatura(EstudianteDTO estudianteDTO) {
        this.setTipoAdeudo("Colegiatura");
        if (this.clases == null) {
            this.clases = coordinadorNegocioPagarAdeudo.obtenerListaClases(estudianteDTO);
            this.adeudoColegiaturaCache = coordinadorNegocioPagarAdeudo.calcularTotalClases(this.clases);
        }
        ListaClasesColegiatura panel = (ListaClasesColegiatura) pagarAdeudo.getPanel("listaClasesColegiatura");
        panel.setAdeudo(this.adeudoColegiaturaCache);
        panel.setClases(this.clases);
        pagarAdeudo.showPanel("listaClasesColegiatura");
    }

    @Override
    public void seleccionarRealizarPago() {
        pagarAdeudo.showPanel("metodosDePago");
    }

    @Override
    public void seleccionarMetodoPago(String metodoPago) {
        if ("BANCO".equals(metodoPago)) {
            abrirPasarelaBanco();
        }
        if ("PAYPAL".equals(metodoPago)){
            System.out.println("Próximamente PayPal...");
        }
    }

    private void abrirPasarelaBanco() {
        ActionListener listenerBotonPagarDelBanco = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarPagoBanco();
            }
        };
        coordinadorNegocioPagarAdeudo.mostrarVentanaPago(listenerBotonPagarDelBanco);
    }

    private void procesarPagoBanco() {
        try {
            solicitudPagoDTO.setEstatusPago("Pendiente");
            solicitudPagoDTO.setIdEstudiante(SesionUsuario.getInstance().getEstudianteLogeado().getMatricula());
            if ("Biblioteca".equals(tipoAdeudo)) solicitudPagoDTO.setMontoPagado(adeudoBibliotecaCache);
            else if ("Colegiatura".equals(tipoAdeudo)) solicitudPagoDTO.setMontoPagado(adeudoColegiaturaCache);

            SolicitudPagoDTO resultado = coordinadorNegocioPagarAdeudo.realizarPago(solicitudPagoDTO);
            if (resultado != null) {
                coordinadorNegocioPagarAdeudo.notificarLiquidacion(resultado);
                coordinadorNegocioPagarAdeudo.cerrarVentanaBanco();
                JOptionPane.showMessageDialog(null, "¡Pago realizado con éxito!");
                limpiarCache();
                regresarAlMenuPrincipal();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en el pago: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error procesando pago: " + ex.getMessage());
        }
    }

    private void limpiarCache() {
        this.prestamos = null;
        this.clases = null;
        this.adeudoBibliotecaCache = null;
        this.adeudoColegiaturaCache = null;
        System.out.println("Pago realizado. Caché limpiada.");
    }

    @Override
    public void verDetalle() { }

    public void setPagarAdeudo(PagarAdeudo pagarAdeudo) {
        this.pagarAdeudo = pagarAdeudo;
    }

    public void setTipoAdeudo(String tipo){
        this.tipoAdeudo = tipo;
    }
    public String getTipoAdeudo(){
        return tipoAdeudo;
    }




}
