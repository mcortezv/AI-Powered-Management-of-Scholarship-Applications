package presentacion.coordinadorAplicacion;
import dto.*;
import interfaces.*;
import presentacion.coordinadorNegocio.CoordinadorNegocio;
import presentacion.login.MainFrame;
import presentacion.login.exceptions.ContraseniaInvalidaException;
import presentacion.login.exceptions.IDInvalidoException;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.exceptions.*;
import presentacion.solicitarBeca.panels.DetallesBecaPanel;
import presentacion.solicitarBeca.panels.ListadoBecasDisponiblesPanel;
import presentacion.solicitarBeca.panels.ResumenFinalPanel;
import java.io.File;
import java.math.BigDecimal;
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
    private RequisitosDTO requisitosDTO;
    private HistorialAcademicoDTO historialAcademicoDTO;
    private TutorDTO tutorDTO;
    private InformacionSocioeconomicaDTO infoSocioeconomicaDTO;

    // bajar a coordinador negocio
    private SolicitudDTO solicitudDTO;
    private EstudianteDTO estudianteDTO;

    public CoordinadorAplicacion(IFachadaInicioSesion fachadaInicioSesion, IFachadaSolicitarBeca fachadaSolicitarBeca) {
        this.coordinadorNegocio = new CoordinadorNegocio(fachadaInicioSesion, fachadaSolicitarBeca);
        mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);

    }

    public boolean intentarIniciarSesion(String usuario, String contrasenia) throws IDInvalidoException, ContraseniaInvalidaException {
        presentacion.login.validadores.Validadores.validarID(usuario);
        presentacion.login.validadores.Validadores.validarContrasenia(contrasenia);
        LoginDTO solicitudLoginDTO = new LoginDTO(usuario, contrasenia);
        return coordinadorNegocio.solicitarInicioSesion(solicitudLoginDTO);
    }

    public void procesarInformacionGeneral(RequisitosDTO requisitosDTO) throws PromedioInvalidoException, IngresoInvalidoException {
        BecasFiltradasDTO becasFiltradas = coordinadorNegocio.obtenerBecasDisponibles(requisitosDTO);
        mostrarBecasDisponibles(becasFiltradas);
    }

    public void procesarDatosSolicitante(String nombre, String apellidoMaterno, String apellidoPaterno, String direccion, String telefono, String email)
            throws NombresInvalidosException, DireccionInvalidaException, TelefonoInvalidoException, IDInvalidoException {

        presentacion.solicitarBeca.validadores.Validadores.validarNombres(nombre);
        presentacion.solicitarBeca.validadores.Validadores.validarApellido(apellidoPaterno);
        presentacion.solicitarBeca.validadores.Validadores.validarApellido(apellidoMaterno);
        presentacion.solicitarBeca.validadores.Validadores.validarDireccion(direccion);
        presentacion.solicitarBeca.validadores.Validadores.validarTelefono(telefono);
        presentacion.solicitarBeca.validadores.Validadores.validarCorreo(email);

        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setNombre(nombre + " " + apellidoPaterno + " " + apellidoMaterno);
        estudianteDTO.setDireccion(direccion);
        estudianteDTO.setTelefono(telefono);
        estudianteDTO.setCorreo(email);

        this.estudianteDTO = estudianteDTO;
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

    public void mostrarBecasDisponibles(BecasFiltradasDTO becasFiltradasDTO) {
        ListadoBecasDisponiblesPanel pnl = (ListadoBecasDisponiblesPanel) solicitarBeca.getPanel("listadoBecasDisponiblesPanel");
        pnl.setBecas(becasFiltradasDTO.getBecas());
        solicitarBeca.showPanel("listadoBecasDisponiblesPanel");
        solicitarBeca.getNorthPanel().setVisible(true);
    }
    
    public void mostrarBecaSeleccionada(){
        DetallesBecaPanel detallesBeca= (DetallesBecaPanel) solicitarBeca.getPanel("detalleBecaPanel");
        detallesBeca.cargarBeca(becaSeleccionadaDTO);
        solicitarBeca.showPanel("detalleBecaPanel");
    }

    public void mostrarResumen(){
        ResumenFinalPanel resumenFinal= (ResumenFinalPanel) solicitarBeca.getPanel("resumenFinalPanel");
        resumenFinal.cargarResumen(solicitudDTO);
        solicitarBeca.showPanel("resumenFinalPanel");
        
    }

    public void procesarHistorialAcademico(String carrera, double cargaAcademica, int semestre) {
        this.historialAcademicoDTO = new HistorialAcademicoDTO();;
        historialAcademicoDTO.setCarrera(carrera);
        historialAcademicoDTO.setSemestre(semestre);
        historialAcademicoDTO.setCargaAcademica(cargaAcademica);
        solicitarBeca.showPanel("datosTutorPanel");
    }

    public void procesarDatosTutor(String parentesco, String nombre, String apPat, String apMat, String direccion, String telefono, String correo) throws NombresInvalidosException, ApellidoInvalidoException, TelefonoInvalidoException, IDInvalidoException {
        presentacion.solicitarBeca.validadores.Validadores.validarNombres(nombre);
        presentacion.solicitarBeca.validadores.Validadores.validarApellido(apPat);
        presentacion.solicitarBeca.validadores.Validadores.validarApellido(apMat);
        presentacion.solicitarBeca.validadores.Validadores.validarTelefono(telefono);
        presentacion.solicitarBeca.validadores.Validadores.validarDireccion(direccion);
        presentacion.solicitarBeca.validadores.Validadores.validarCorreo(correo);
        tutorDTO = new TutorDTO(apMat, apPat, correo, direccion, nombre, parentesco, telefono);
        solicitarBeca.showPanel("informacionSocioeconomicaPanel");
    }

    public void procesarInformacionSocioeconomica(String ingresoStr, String deudas, String seleccionGeneraIngreso) throws NumberFormatException, IngresoInvalidoException {
        double ingreso;
        try {
            ingreso = Double.parseDouble(ingresoStr);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El ingreso debe ser un número válido.");
        }
        presentacion.solicitarBeca.validadores.Validadores.validarIngreso(ingreso);
        boolean deudasBool = "SI".equals(deudas);
        boolean generaIngreso = "SI".equals(seleccionGeneraIngreso);
        infoSocioeconomicaDTO = new InformacionSocioeconomicaDTO();
        infoSocioeconomicaDTO.setIngresoTotalFamilarMensual(BigDecimal.valueOf(ingreso));
        infoSocioeconomicaDTO.setDeudas(deudasBool);
        infoSocioeconomicaDTO.setTrabajo(generaIngreso);
        solicitarBeca.showPanel("subirDocumentosPanel");
    }

    public void procesarDocumentosYSolicitud(Map<String, File> documentosCargados) {
        mostrarResumen();
    }

    public void setBecaSeleccionadaDTO(BecaDTO becaDTO) {
        this.becaDTO = becaDTO;
    }


}
