package interfaces;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;

public interface IFachadaInicioSesion {
    EstudianteResponseDTO solicitarLogin(LoginDTO solicitudLoginDTO);
    void solicitarLogOut();
    
}
