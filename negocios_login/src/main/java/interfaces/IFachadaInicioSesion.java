package interfaces;
import dto.LoginDTO;

public interface IFachadaInicioSesion {

    boolean solicitarLogin(LoginDTO solicitudLoginDTO);

    void solicitarLogOut();
    
}
