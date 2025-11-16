
package controlNavegacion;
import fachada.FachadaInicioSesion;
import implementacion.ControlInicioSesion;
import interfaz.IFachadaInicioSesion;
import dto.*;
import implementacion.ControlSolicitud;
import fachada.FachadaSolicitud;
import interfaz.IFachadaSolicitud;
import presentacion.login.MainFrame;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.panels.DetallesBecaPanel;
import presentacion.solicitarBeca.panels.ListadoBecasDisponiblesPanel;
import presentacion.solicitarBeca.panels.ResumenFinalPanel;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlNavegacion implements IControlNavegacion{
    private final MainFrame mainFrame;
    private SolicitarBeca solicitarBeca;
    private final IFachadaSolicitud iFachadaSolicitud;
    private final IFachadaInicioSesion iFachadaInicioSesion;
    private BecaDTO becaDTO;
    private BecaDTO becaSeleccionadaDTO;
    private DatosSolicitanteDTO datosSolicitanteDTO;
    private HistAcademicoDTO historialAcademicoDTO;
    private TutorDTO tutorDTO;
    private InformacionSocioeconomicaDTO infoSocioeconomicaDTO;
    private SolicitudDTO solicitudDTO;
  


    public ControlNavegacion(){
        this.iFachadaSolicitud = new FachadaSolicitud(new ControlSolicitud());
        this.iFachadaInicioSesion = new FachadaInicioSesion(new ControlInicioSesion());

        mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);

    }

    @Override
    public EstudianteResponseDTO solicitarInicioSesion(SolicitudLoginDTO solicitudLoginDTO){
        return iFachadaInicioSesion.solicitarLogin(solicitudLoginDTO);
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

    @Override
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO){
        return iFachadaSolicitud.obtenerBecasDisponibles(solicitudDTO);
    }

    @Override
    public void SolicitarCerrarSesion() {

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
    public void mostrarResumen(){
        SolicitudDTO solicitudDTO= obtenerSolicitud();
        
        TutorDTO tutorDTO= obtenerTutor();
        DatosSolicitanteDTO solicitanteDTO= obtenerDatosSolicitanteDTO();
        ResumenFinalPanel resumenFinal= (ResumenFinalPanel) solicitarBeca.getPanel("resumenFinalPanel");
        resumenFinal.cargarResumen(solicitudDTO, tutorDTO, solicitanteDTO);
        solicitarBeca.showPanel("resumenFinalPanel");
        
    }
   

    public BecaDTO obtenerBecaSeleccionadaDTO() {
        return becaSeleccionadaDTO;
    }
    
    public DatosSolicitanteDTO obtenerDatosSolicitanteDTO(){
        return datosSolicitanteDTO;
    }
    
    public void setDatosSolicitanteDTO(DatosSolicitanteDTO datosSolicitante){
        this.datosSolicitanteDTO= datosSolicitante;
    }

    public void setBecaSeleccionadaDTO(BecaDTO becaSeleccionadaDTO) {
        this.becaSeleccionadaDTO = becaSeleccionadaDTO;
    }
    public void setHistorialAcademicoDTO(HistAcademicoDTO historialAcademicoDTO){
       this.historialAcademicoDTO= historialAcademicoDTO;
    }
    
    public void setTutor(TutorDTO tutor){
        this.tutorDTO= tutor;
    }
    public TutorDTO obtenerTutor(){
        return tutorDTO;
    }
    
    public InformacionSocioeconomicaDTO obtenerInfoSocioeconomicaDTO(){
        return infoSocioeconomicaDTO;
    }    
    
    public void setInfoSocioeconomica(InformacionSocioeconomicaDTO infoSocioeconomicaDTO){
        this.infoSocioeconomicaDTO= infoSocioeconomicaDTO;
    }
    
    public HistAcademicoDTO obtenerHistAcademico(){
        return historialAcademicoDTO;
    }
    
    public void setSolicitud(SolicitudDTO solicitudDTO){
       this.solicitudDTO= solicitudDTO;
    }
    
    public SolicitudDTO obtenerSolicitud(){
        return solicitudDTO;
    }


}
