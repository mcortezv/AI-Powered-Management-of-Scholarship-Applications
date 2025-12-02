package presentacion.coordinadorAplicacion;
import dto.*;
import dto.itson.LoginDTOItson;
import interfaces.*;
import presentacion.coordinadorNegocio.CoordinadorNegocio;
import presentacion.coordinadorNegocio.ICoordinadorNegocio;
import presentacion.login.MainFrame;
import presentacion.login.exceptions.ContraseniaInvalidaException;
import presentacion.login.exceptions.IDInvalidoException;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.exceptions.*;
import presentacion.solicitarBeca.panels.DetallesBecaPanel;
import presentacion.solicitarBeca.panels.ListadoBecasDisponiblesPanel;
import presentacion.solicitarBeca.panels.ResumenFinalPanel;
import java.io.File;
import java.util.Map;
import presentacion.actividadesExtracurriculares.coordinador.CoordinadorAplicacionActividades;
import presentacion.actividadesExtracurriculares.panels.ActividadesExtracurriculares;

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

    //pagar adeudo
    private final CoordinadorAplicacionPagarAdeudo coordinadorAplicacionPagarAdeudo;
    private PagarAdeudo adeudo;
    
    //actividades extracurriculares 
    private final CoordinadorAplicacionActividades coordinadorAplicacionActividades;
    private ActividadesExtracurriculares actividades;

    // bajar a coordinador negocio
    private dto_gobierno.SolicitudDTO solicitudDTO;
    private dto_gobierno.EstudianteDTO estudianteDTO;

    public CoordinadorAplicacion(IFachadaInicioSesion fachadaInicioSesion, 
                                IFachadaSolicitarBeca fachadaSolicitarBeca, 
                                CoordinadorAplicacionPagarAdeudo coordinadorAplicacionPagarAdeudo, 
                                CoordinadorAplicacionActividades coordinadorAplicacionActividades) {
        this.coordinadorNegocio = new CoordinadorNegocio(fachadaInicioSesion, fachadaSolicitarBeca);
        this.coordinadorAplicacionPagarAdeudo = coordinadorAplicacionPagarAdeudo;
        this.coordinadorAplicacionActividades= coordinadorAplicacionActividades;
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
        System.out.println("llego al coordinadorAplicacion");
        return coordinadorNegocio.solicitarInicioSesion(loginDTO);
    }

    public void cerrarSesion(){
        coordinadorNegocio.solicitarCerrarSesion();
    }

    public void procesarInformacionGeneral(RequisitosDTO requisitosDTO) throws PromedioInvalidoException, IngresoInvalidoException {
        BecasFiltradasDTO becasFiltradas = coordinadorNegocio.obtenerBecasDisponibles(requisitosDTO);
        mostrarBecasDisponibles(becasFiltradas);
    }

    public void procesarDatosSolicitante(EstudianteDTO estudianteDTO) throws NombresInvalidosException, DireccionInvalidaException, TelefonoInvalidoException, IDInvalidoException {
        coordinadorNegocio.procesarEstudiante(estudianteDTO);
        solicitarBeca.showPanel("historialAcademicoPanel");
    }

    public void solicitarBeca() {
        mainFrame.setVisible(false);
        solicitarBeca = new SolicitarBeca(this, becaSeleccionadaDTO);
        solicitarBeca.setVisible(true);
    }

    public void pagarAdeudo(){
        mainFrame.setVisible(false);
        adeudo = new PagarAdeudo(coordinadorAplicacionPagarAdeudo);
        adeudo.setVisible(true);
    }
    
    public void actividades(){
        mainFrame.setVisible(false);
        coordinadorAplicacionActividades.iniciarGUI();
        
    }


    public void main() {
        solicitarBeca.setVisible(false);
        mainFrame.setVisible(true);
    }

    public void mostrarBecasDisponibles(BecasFiltradasDTO becasFiltradasDTO) {
        ListadoBecasDisponiblesPanel pnl = (ListadoBecasDisponiblesPanel) solicitarBeca.getPanel("listadoBecasDisponiblesPanel");
        pnl.setBecas(becasFiltradasDTO.getBecas());
        solicitarBeca.showPanel("listadoBecasDisponiblesPanel");
        solicitarBeca.getNorthPanel().setVisible(true);
    }
    
    public void mostrarBecaSeleccionada(){
        DetallesBecaPanel detallesBeca = (DetallesBecaPanel) solicitarBeca.getPanel("detalleBecaPanel");
        detallesBeca.cargarBeca(becaSeleccionadaDTO);
        solicitarBeca.showPanel("detalleBecaPanel");
    }
    

    public void mostrarResumen(){
        ResumenFinalPanel resumenFinal= (ResumenFinalPanel) solicitarBeca.getPanel("resumenFinalPanel");
        resumenFinal.cargarResumen(solicitudDTO);
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

//    public void procesarInformacionSocioeconomica(InformacionSocioeconomicaDTO infoSocioeconomicaDTO) throws NumberFormatException, IngresoInvalidoException {
//        Double ingreso;
//        try {
//            ingreso = Double.parseDouble(infoSocioeconomicaDTO.getIngresoFamiliarSt());
//        } catch (NumberFormatException e) {
//            throw new NumberFormatException("El ingreso debe ser un número.");
//        }
//        presentacion.solicitarBeca.validadores.Validadores.validarIngreso(ingreso);
//        
//        boolean dependenciaEconomica= "SI".equals(infoSocioeconomicaDTO.getDependenciaEconomica());
//        boolean generaIngreso = "SI".equals(infoSocioeconomicaDTO.getTrabajoSt());
//       
//        solicitarBeca.showPanel("subirDocumentosPanel");
//    }


    public void procesarDocumentosYSolicitud(Map<String, File> documentosCargados) {
        mostrarResumen();
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
}
