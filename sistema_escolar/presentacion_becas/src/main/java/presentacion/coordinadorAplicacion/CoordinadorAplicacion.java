
package presentacion.coordinadorAplicacion;
import dto.*;
import enums.Parentesco;
import presentacion.coordinadorNegocio.CoordinadorNegocio;
import presentacion.login.MainFrame;
import presentacion.login.exceptions.ContraseniaInvalidaException;
import presentacion.login.exceptions.IDInvalidoException;
import presentacion.login.validadores.Validadores;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.exceptions.*;
import presentacion.solicitarBeca.panels.DetallesBecaPanel;
import presentacion.solicitarBeca.panels.ListadoBecasDisponiblesPanel;
import presentacion.solicitarBeca.panels.ResumenFinalPanel;

import java.io.File;
import java.util.Map;

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

    public EstudianteResponseDTO intentarIniciarSesion(String usuario, String contrasenia) throws IDInvalidoException, ContraseniaInvalidaException {
        presentacion.login.validadores.Validadores.validarID(usuario);
        presentacion.login.validadores.Validadores.validarContrasenia(contrasenia);
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

    public void procesarDatosSolicitante(String nombre, String apellidoMaterno, String apellidoPaterno, String direccion, String telefono, String email)
            throws NombresInvalidosException, DireccionInvalidaException, TelefonoInvalidoException, IDInvalidoException {

        presentacion.solicitarBeca.validadores.Validadores.validarNombres(nombre);
        presentacion.solicitarBeca.validadores.Validadores.validarApellido(apellidoPaterno);
        presentacion.solicitarBeca.validadores.Validadores.validarApellido(apellidoMaterno);
        presentacion.solicitarBeca.validadores.Validadores.validarDireccion(direccion);
        presentacion.solicitarBeca.validadores.Validadores.validarTelefono(telefono);
        presentacion.solicitarBeca.validadores.Validadores.validarCorreo(email);

        DatosSolicitanteDTO datosSolicitanteDTO = new DatosSolicitanteDTO(nombre, apellidoMaterno, apellidoPaterno, direccion, telefono, email);setDatosSolicitanteDTO(datosSolicitanteDTO);

        solicitarBeca.showPanel("historialAcademicoPanel");
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
        SolicitudDTO solicitudDTO = obtenerSolicitud();
        TutorDTO tutorDTO= obtenerTutor();
        DatosSolicitanteDTO solicitanteDTO= obtenerDatosSolicitanteDTO();
        ResumenFinalPanel resumenFinal= (ResumenFinalPanel) solicitarBeca.getPanel("resumenFinalPanel");
        resumenFinal.cargarResumen(solicitudDTO, tutorDTO, solicitanteDTO);
        solicitarBeca.showPanel("resumenFinalPanel");
        
    }

    public void procesarHistorialAcademico(String carrera, String cargaAcademica, int semestre) {
        HistAcademicoDTO historialAcademicoDTO = new HistAcademicoDTO(carrera, cargaAcademica, semestre);
        setHistorialAcademicoDTO(historialAcademicoDTO);
        solicitarBeca.showPanel("datosTutorPanel");
    }

    public void procesarDatosTutor(Parentesco parentesco, String nombre, String apPat, String apMat, String telefono, String correo) throws NombresInvalidosException, ApellidoInvalidoException, TelefonoInvalidoException, IDInvalidoException {
        presentacion.solicitarBeca.validadores.Validadores.validarNombres(nombre);
        presentacion.solicitarBeca.validadores.Validadores.validarApellido(apPat);
        presentacion.solicitarBeca.validadores.Validadores.validarApellido(apMat);
        presentacion.solicitarBeca.validadores.Validadores.validarTelefono(telefono);
        presentacion.solicitarBeca.validadores.Validadores.validarCorreo(correo);
        TutorDTO tutor = new TutorDTO(nombre, parentesco, apMat, apPat, telefono, correo);
        setTutor(tutor);
        solicitarBeca.showPanel("informacionSocioeconomicaPanel");
    }

    public void procesarInformacionSocioeconomica(String ingresoStr, String seleccionDependEconomica, String seleccionGeneraIngreso) throws NumberFormatException, IngresoInvalidoException {
        double ingreso;
        try {
            ingreso = Double.parseDouble(ingresoStr);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El ingreso debe ser un número válido.");
        }
        presentacion.solicitarBeca.validadores.Validadores.validarIngreso(ingreso);
        boolean dependenciaEconomica = "SI".equals(seleccionDependEconomica);
        boolean generaIngreso = "SI".equals(seleccionGeneraIngreso);
        InformacionSocioeconomicaDTO informacionSocioeconomicaDTO = new InformacionSocioeconomicaDTO(ingreso, dependenciaEconomica, generaIngreso);
        setInfoSocioeconomica(informacionSocioeconomicaDTO);
        solicitarBeca.showPanel("subirDocumentosPanel");
    }

    public void procesarDocumentosYSolicitud(Map<String, File> documentosCargados) {
        BecaDTO becaDTO = obtenerBecaSeleccionadaDTO();
        InformacionSocioeconomicaDTO infoSocioeconomicaDTO = obtenerInfoSocioeconomicaDTO();
        HistAcademicoDTO historialAcademicoDTO = obtenerHistAcademico();

        SolicitudDTO solicitudDTO = new SolicitudDTO(becaDTO, infoSocioeconomicaDTO, historialAcademicoDTO);
        setSolicitud(solicitudDTO);
        mostrarResumen();
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
