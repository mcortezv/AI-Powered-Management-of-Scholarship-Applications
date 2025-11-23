package controles;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;
import objetosNegocio.mock.EstudianteBOMock;


public class ControlInicioSesion {
    private final EstudianteBOMock estudianteMock= EstudianteBOMock.getInstance();

    public EstudianteResponseDTO solicitarLogin(LoginDTO solicitudLoginDTO){
        return estudianteMock.getEstudianteResponseDTO(solicitudLoginDTO);
    }

    public void cerrarSesion(){
        System.out.println("Cerrrando sesion...");
    }
}
