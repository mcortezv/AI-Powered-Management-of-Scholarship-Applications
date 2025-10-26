package presentacion.control;

import dto.DatosSolicitanteDTO;
import presentacion.MainFrame;
import objetosNegocio.interfaces.IControlBeca;
import presentacion.interfaces.IControlPantalla;

import java.util.List;

public class ControlPantalla implements IControlPantalla {
    private IControlBeca controlBeca;
    private MainFrame mainFrame;

    public ControlPantalla(IControlBeca controlBeca, MainFrame mainFrame){
        this.controlBeca = controlBeca;
        this.mainFrame = mainFrame;
    }

    @Override
    public void iniciarSesion(String usuario, String contrasenia) {
        try{
            boolean exito = controlBeca.iniciarSesion(usuario,contrasenia);
            if(exito){
                mostrarPantallaInfoGeneral();
            }else{
                System.out.println("Usuario incorrecto");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void confirmarDatos(DatosSolicitanteDTO datosSolicitanteDTO){
        try{
            controlBeca.guardarDatosSolicitante(datosSolicitanteDTO);
            mostrarPantallaInformacionSocioeconomica();
        }catch (Exception ex){
            return;
        }
    }

    @Override
    public void seleccionarBeca(int idBeca) {

    }


    @Override
    public void subirDocumentos(List<Byte[]> documentos) {

    }

    @Override
    public void confirmarSolicitud() {

    }

    @Override
    public void mostrarPantallaLogin() {

    }

    @Override
    public void mostrarPantallaInfoGeneral() {

    }

    @Override
    public void mostrarPantallaBecasDisponibles() {

    }

    @Override
    public void mostrarPantallaDetallesBeca() {

    }

    @Override
    public void motrarPantallaDatosSolicitante() {

    }

    @Override
    public void mostrarPantallaHistorialAcademico() {

    }

    @Override
    public void mostrarPantallaDatosTutor() {

    }

    @Override
    public void mostrarPantallaInformacionSocioeconomica() {

    }

    @Override
    public void mostrtarPantallaSubirDocumentos() {

    }

    @Override
    public void mostrarPantallaResumenFinal() {

    }

    @Override
    public void mostrarPantallaConfirmacion() {

    }
}
