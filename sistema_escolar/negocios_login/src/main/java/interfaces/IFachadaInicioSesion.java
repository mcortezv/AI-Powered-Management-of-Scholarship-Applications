package interfaces;
import dto.itson.LoginDTOItson;

public interface IFachadaInicioSesion {

    boolean solicitarLogin(LoginDTOItson solicitudLoginDTO);

    void solicitarLogOut();
    
}
