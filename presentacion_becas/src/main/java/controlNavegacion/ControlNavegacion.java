/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlNavegacion;
import dto.BecaDTO;
import dto.DatosSolicitanteDTO;
import dto.HistAcademicoDTO;
import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import gestor.GestorSolicitud;
import implementacion.ManejadorSolicitud;
import interfaz.IManejadorSolicitud;
import presentacion.login.MainFrame;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.panels.DetallesBecaPanel;
import presentacion.solicitarBeca.panels.ListadoBecasDisponiblesPanel;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlNavegacion {
    private MainFrame mainFrame;
    private SolicitarBeca solicitarBeca;
    private IManejadorSolicitud manejador;
    private BecaDTO becaDTO;
    private BecaDTO becaSeleccionadaDTO;
    private BecaDTO becaSeleccionada;
    private DatosSolicitanteDTO datosSolicitanteDTO;
    private HistAcademicoDTO historialAcademicoDTO;


    public ControlNavegacion(){
        this.manejador = new ManejadorSolicitud(new GestorSolicitud());
        this.becaDTO= becaDTO;
        mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);
        
    }

    public void solicitarBeca() {
        mainFrame.setVisible(false);
        solicitarBeca = new SolicitarBeca(this, becaDTO);
        solicitarBeca.setVisible(true);
    }

    public void main() {
        solicitarBeca.setVisible(false);
        mainFrame.setVisible(true);
    }
    
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO){
        return manejador.obtenerBecasDisponibles(solicitudDTO);
    }
    
    public void mostrarBecasDisponibles(SolicitudBecasDisponiblesResponseDTO responseDTO) {
        ListadoBecasDisponiblesPanel pnl = (ListadoBecasDisponiblesPanel) solicitarBeca.getPanel("listadoBecasDisponiblesPanel");
        pnl.setBecas(responseDTO.getBecas());
        solicitarBeca.showPanel("listadoBecasDisponiblesPanel");
        solicitarBeca.getNorthPanel().setVisible(true);
    }
    
    public void mostrarBecaSeleccionada(){
        BecaDTO becaSeleccionada= obtenerBecaSeleccionadaDTO();
        DetallesBecaPanel detallesBeca= (DetallesBecaPanel) solicitarBeca.getPanel("detalleBecaPanel");
        detallesBeca.cargarBeca(becaSeleccionada);
        solicitarBeca.showPanel("detalleBecaPanel");
    }

    public BecaDTO obtenerBecaSeleccionadaDTO() {
        return becaSeleccionadaDTO;
    }
    
    public DatosSolicitanteDTO obtenerDatosSolicitanteDTO(){
        return datosSolicitanteDTO;
    }
    
    public void setDatosSolicitanteDTO(DatosSolicitanteDTO datosSolicitanteDTO){
        this.datosSolicitanteDTO= datosSolicitanteDTO;
    }
    
    

    public void setBecaSeleccionadaDTO(BecaDTO becaSeleccionadaDTO) {
        this.becaSeleccionadaDTO = becaSeleccionadaDTO;
    }
    public void setHistorialAcademicoDTO(HistAcademicoDTO historialAcademicoDTO){
       this.historialAcademicoDTO= historialAcademicoDTO;
    }
    
    
    
   
    
    
}
