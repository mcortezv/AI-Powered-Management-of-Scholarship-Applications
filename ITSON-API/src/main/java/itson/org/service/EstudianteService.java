package itson.org.service;
import dto.itson.LoginDTOItson;
import itson.org.domain.Estudiante;
import itson.org.repository.impl.EstudianteDAO;

public class EstudianteService {

    private final EstudianteDAO estudianteDAO;

    public EstudianteService(EstudianteDAO estudianteDAO){
        this.estudianteDAO = estudianteDAO;
    }

    public EstudianteService() {
        this.estudianteDAO = new EstudianteDAO();
    }

    public boolean verificarLogin(LoginDTOItson dto){
        Estudiante estudiante = estudianteDAO.findByMatricula(dto.getUsuario()).orElse(null);
        if (estudiante == null || estudiante.getContrasenia() == null) {
            return false;
        }
        System.out.println("antes de regresar boolean: " + estudiante.getContrasenia());
        return estudiante.getContrasenia().equals(dto.getContrasenia());
    }
    
    public Estudiante solicitarDatosEstudiante(Long matricula){
        return estudianteDAO.findByMatricula(matricula).orElse(null);
             
    }
    
}
