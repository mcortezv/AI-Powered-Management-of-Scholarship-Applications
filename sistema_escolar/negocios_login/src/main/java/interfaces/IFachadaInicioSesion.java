package interfaces;
import itson.LoginDTOItson;
import solicitarBeca.EstudianteDTO;

public interface IFachadaInicioSesion {

    boolean solicitarLogin(LoginDTOItson solicitudLoginDTO);

    void solicitarLogOut();

    EstudianteDTO getEstudianteLogueado();
}
