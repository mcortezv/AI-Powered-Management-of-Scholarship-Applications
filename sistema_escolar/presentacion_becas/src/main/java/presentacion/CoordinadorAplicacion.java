package presentacion;
import itson.LoginDTOItson;
import interfaces.*;
import presentacion.interfaces.ICoordinadorAplicacion;
import presentacion.login.MainFrame;
import presentacion.login.exceptions.ContraseniaInvalidaException;
import presentacion.login.exceptions.IDInvalidoException;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.exceptions.*;
import presentacion.solicitarBeca.panels.DatosDelSolicitantePanel;
import presentacion.solicitarBeca.panels.DetallesBecaPanel;
import presentacion.solicitarBeca.panels.ListadoBecasDisponiblesPanel;
import presentacion.solicitarBeca.panels.ResumenFinalPanel;
import solicitarBeca.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author janethcristinagalvanquinonez
 */

public class CoordinadorAplicacion implements ICoordinadorAplicacion {
    private MainFrame mainFrame;
    private final CoordinadorNegocio coordinadorNegocio;
    private SolicitarBeca solicitarBeca;
    private BecaDTO becaSeleccionadaDTO;
    private RequisitosDTO requisitosDTO;
    private HistorialAcademicoDTO historialAcademicoDTO;
    private TutorDTO tutorDTO;
    private InformacionSocioeconomicaDTO infoSocioeconomicaDTO;
    private CoordinadorAplicacionPagarAdeudo coordinadorAplicacionPagarAdeudo;

    public CoordinadorAplicacion(IFachadaInicioSesion fachadaInicioSesion, IFachadaSolicitarBeca fachadaSolicitarBeca) {
        this.coordinadorNegocio = new CoordinadorNegocio(fachadaInicioSesion, fachadaSolicitarBeca);
        mainFrame = null;
    }

    public void iniciarGUI() {
        if (mainFrame == null) {
            mainFrame = new MainFrame(this);
        }
        mainFrame.setVisible(true);
    }

    public boolean intentarIniciarSesion(LoginDTOItson loginDTO) throws IDInvalidoException, ContraseniaInvalidaException {
        presentacion.login.validadores.Validadores.validarID(loginDTO.getUsuario());
        presentacion.login.validadores.Validadores.validarContrasenia(loginDTO.getContrasenia());
        return coordinadorNegocio.solicitarInicioSesion(loginDTO);
    }

    public void cerrarSesion(){
        coordinadorNegocio.solicitarCerrarSesion();
    }

    public void procesarInformacionGeneral(RequisitosDTO requisitosDTO) throws PromedioInvalidoException, IngresoInvalidoException {
        BecasFiltradasDTO becasFiltradas = coordinadorNegocio.obtenerBecasDisponibles(requisitosDTO);
        mostrarBecasDisponibles(becasFiltradas);
    }

    public void procesarDatosSolicitante() throws NombresInvalidosException, DireccionInvalidaException, TelefonoInvalidoException, IDInvalidoException {
        DatosDelSolicitantePanel datosDelSolicitantePanel= (DatosDelSolicitantePanel) solicitarBeca.getPanel("datosDelSolicitantePanel");
        EstudianteDTO estudianteDTO = getEstudianteLogueado();
        datosDelSolicitantePanel.setEstudiante(estudianteDTO);
        coordinadorNegocio.procesarEstudiante(estudianteDTO);
        solicitarBeca.showPanel("datosDelSolicitantePanel");
    }

    public void mostrarPanelHitorialAcademico(){
        solicitarBeca.showPanel("historialAcademicoPanel");
    }

    public void solicitarBeca() {
        mainFrame.setVisible(false);
        solicitarBeca = new SolicitarBeca(this, becaSeleccionadaDTO);
        solicitarBeca.setVisible(true);
    }

    public void pagarAdeudo() {
        mainFrame.setVisible(false);
        PagarAdeudo pagarAdeudoFrame = new PagarAdeudo(coordinadorAplicacionPagarAdeudo);
        pagarAdeudoFrame.setVisible(true);
    }

    public void setCoordinadorAplicacionPagarAdeudo(CoordinadorAplicacionPagarAdeudo c) {
        this.coordinadorAplicacionPagarAdeudo = c;
    }

    public void main() {
        solicitarBeca.setVisible(false);
        mainFrame.setVisible(true);
    }

    public void mostrarBecasDisponibles(BecasFiltradasDTO becasFiltradasDTO) {
        ListadoBecasDisponiblesPanel pnl = (ListadoBecasDisponiblesPanel) solicitarBeca.getPanel("listadoBecasDisponiblesPanel");
        pnl.setBecas(becasFiltradasDTO.getBecas());
        solicitarBeca.showPanel("listadoBecasDisponiblesPanel");
    }
    
    public void mostrarBecaSeleccionada(){
        DetallesBecaPanel detallesBeca = (DetallesBecaPanel) solicitarBeca.getPanel("detalleBecaPanel");
        detallesBeca.cargarBeca(becaSeleccionadaDTO);
        solicitarBeca.showPanel("detalleBecaPanel");
    }

    public void mostrarResumen(){
        ResumenFinalPanel resumenFinal = (ResumenFinalPanel) solicitarBeca.getPanel("resumenFinalPanel");
        resumenFinal.cargarResumen(coordinadorNegocio.getSolicitudActual());
        solicitarBeca.showPanel("resumenFinalPanel");
    }

    public void iniciarSolicitud(){
        coordinadorNegocio.iniciarSolicitud(becaSeleccionadaDTO);
    }

    public void procesarHistorialAcademico(HistorialAcademicoDTO historialAcademicoDTO) {
        coordinadorNegocio.procesarHistorialAcademico(historialAcademicoDTO);
        solicitarBeca.showPanel("datosTutorPanel");
    }

    public void procesarDatosTutor(TutorDTO tutorDTO) throws NombresInvalidosException, ApellidoInvalidoException, TelefonoInvalidoException, IDInvalidoException {
        presentacion.solicitarBeca.validadores.Validadores.validarNombres(tutorDTO.getNombre());
        presentacion.solicitarBeca.validadores.Validadores.validarApellido(tutorDTO.getApellidoMaterno());
        presentacion.solicitarBeca.validadores.Validadores.validarApellido(tutorDTO.getApellidoPaterno());
        presentacion.solicitarBeca.validadores.Validadores.validarTelefono(tutorDTO.getTelefono());
        presentacion.solicitarBeca.validadores.Validadores.validarDireccion(tutorDTO.getDireccion());
        presentacion.solicitarBeca.validadores.Validadores.validarCorreo(tutorDTO.getCorreo());
        coordinadorNegocio.procesarTutor(tutorDTO);
        solicitarBeca.showPanel("informacionSocioeconomicaPanel");
    }


    public void procesarDocumentos(Map<String, File> documentosCargados) throws IOException {
        try {
            coordinadorNegocio.procesarDocumentos(documentosCargados);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void setBecaSeleccionadaDTO(BecaDTO becaDTO) {
        this.becaSeleccionadaDTO = becaDTO;
    }

    public void enviarSolicitudAGobierno() {
        coordinadorNegocio.enviarSolicitudAGobierno();
    }

    public void procesarInformacionSocioeconomica(InformacionSocioeconomicaDTO infoSocioeconomica) {
        coordinadorNegocio.procesarInformacionSocioeconomica(infoSocioeconomica);
        solicitarBeca.showPanel("subirDocumentosPanel");
    }

    public EstudianteDTO getEstudianteLogueado() {
        return coordinadorNegocio.getEstudianteLogueado();
    }

    public void mostrarMainFrame() {
        if (mainFrame != null) {
            mainFrame.setVisible(true);
        }
    }
}
