package interfaces;
import itson.LoginDTOItson;

public interface IFachadaInicioSesion {

    boolean solicitarLogin(LoginDTOItson solicitudLoginDTO);

    void solicitarLogOut();
    
}
