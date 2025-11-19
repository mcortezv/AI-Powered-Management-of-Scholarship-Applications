
package presentacion.coordinadorAplicacion;
import dto.*;
import presentacion.coordinadorNegocio.CoordinadorNegocio;
import presentacion.login.MainFrame;
import presentacion.login.exceptions.ContraseniaInvalidaException;
import presentacion.login.exceptions.IDInvalidoException;
import presentacion.login.validadores.Validadores;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.exceptions.IngresoInvalidoException;
import presentacion.solicitarBeca.exceptions.PromedioInvalidoException;
import presentacion.solicitarBeca.panels.DetallesBecaPanel;
import presentacion.solicitarBeca.panels.ListadoBecasDisponiblesPanel;
import presentacion.solicitarBeca.panels.ResumenFinalPanel;

/**
 *
 * @author janethcristinagalvanquinonez
 */

public class CoordinadorAplicacion implements ICoordinadorAplicacion {
    private final MainFrame mainFrame;
    private final CoordinadorNegocio coordinadorNegocio;
    private SolicitarBeca solicitarBeca;
    private BecaDTO becaDTO;
    private BecaDTO becaSeleccionadaDTO;
    private DatosSolicitanteDTO datosSolicitanteDTO;
    private HistAcademicoDTO historialAcademicoDTO;
    private TutorDTO tutorDTO;
    private InformacionSocioeconomicaDTO infoSocioeconomicaDTO;
    private SolicitudDTO solicitudDTO;


    public CoordinadorAplicacion(){
        this.coordinadorNegocio = new CoordinadorNegocio();
        mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);

    }

    public EstudianteResponseDTO intentarIniciarSesion(String usuario, String contrasenia)
            throws IDInvalidoException, ContraseniaInvalidaException {
        Validadores.validarID(usuario);
        Validadores.validarContrasenia(contrasenia);
        SolicitudLoginDTO solicitudLoginDTO = new SolicitudLoginDTO(usuario, contrasenia);
        return coordinadorNegocio.solicitarInicioSesion(solicitudLoginDTO);
    }

    public void procesarInformacionGeneral(double promedio, boolean carga, double ingreso) throws PromedioInvalidoException, IngresoInvalidoException {
        presentacion.solicitarBeca.validadores.Validadores.validarPromedio(promedio);
        presentacion.solicitarBeca.validadores.Validadores.validarIngreso(ingreso);
        SolicitudBecasDisponiblesDTO solictudBecasDisponiblesDTO  = new SolicitudBecasDisponiblesDTO(promedio, carga, ingreso);
        SolicitudBecasDisponiblesResponseDTO solicitudBecasDisponiblesResponseDTO = coordinadorNegocio.obtenerBecasDisponibles(solictudBecasDisponiblesDTO);
        mostrarBecasDisponibles(solicitudBecasDisponiblesResponseDTO);
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
