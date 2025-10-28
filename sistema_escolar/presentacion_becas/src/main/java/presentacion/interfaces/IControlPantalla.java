package presentacion.interfaces;

import dto.DatosSolicitanteDTO;

import java.util.List;

public interface IControlPantalla {
    void iniciarSesion(String usuario, String contrasenia);
    void confirmarDatos(DatosSolicitanteDTO datosSolicitanteDTO);
    void seleccionarBeca(int idBeca);
    void subirDocumentos(List<Byte[]> documentos);
    void confirmarSolicitud();

    void mostrarPantallaLogin();
    void mostrarPantallaInfoGeneral();
    void mostrarPantallaBecasDisponibles();
    void mostrarPantallaDetallesBeca();
    void motrarPantallaDatosSolicitante();
    void mostrarPantallaHistorialAcademico();
    void mostrarPantallaDatosTutor();
    void mostrarPantallaInformacionSocioeconomica();
    void mostrtarPantallaSubirDocumentos();
    void mostrarPantallaResumenFinal();
    void mostrarPantallaConfirmacion();
}
