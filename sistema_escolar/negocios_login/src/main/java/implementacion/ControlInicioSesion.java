package implementacion;

import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import objetosNegocio.mock.EstudianteMock;

import javax.swing.*;


public class ControlInicioSesion {
    private final EstudianteMock estudianteMock= EstudianteMock.getInstance();

    public EstudianteResponseDTO solicitarLogin(SolicitudLoginDTO solicitudLoginDTO){
        return estudianteMock.getEstudianteResponseDTO(solicitudLoginDTO);
    }

    public void cerrarSesion(){
        System.out.println("Cerrrando sesion...");
    }
}
