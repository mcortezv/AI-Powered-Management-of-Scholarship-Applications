/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio.mock;
import java.util.HashMap;
import java.util.Map;

import dominio.Direccion;
import dominio.Estudiante;
import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class EstudianteMock {
    
    private final Map<Long, Estudiante> estudiantes= new HashMap<>();
    private static EstudianteMock instancia;
    TutorMock tutor= new TutorMock();

    public EstudianteMock(){
        cargarEstudiantes();
    }

    public static EstudianteMock getInstance(){
        if(instancia==null){
            instancia= new EstudianteMock();
        }
        return instancia;
    }
    
    private void cargarEstudiantes(){
        Estudiante estudiante1 = new Estudiante(258329L, "Luisa Perez", tutor.getTutores().get(0L), "hola", "687378444", new Direccion("Luar", "Villas del Rey", "Ciudad Obregon"), "luisa@gmail.com");
        Estudiante estudiante2= new Estudiante(12345678901L, "Cristina Perez", tutor.getTutores().get(1L), "Password123", "6871678844", new Direccion("Luar", "Villa Itson", "Ciudad Obregon"), "cristina@gmail.com");
        estudiantes.put(estudiante1.getMatricula(), estudiante1);   
        estudiantes.put(estudiante2.getMatricula(), estudiante2);
    }

    public Map<Long, Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public EstudianteResponseDTO getEstudianteResponseDTO(SolicitudLoginDTO solicitudLoginDTO){
        return new EstudianteResponseDTO("inscrito",9.8,"sebastian.potros@gmail","galeana 1477","6681118936", "ISW","sebastian escalante", 252321);
    }

    public boolean iniciarSesionPorMatricula(String matricula, String password) {
        try {
            Long mat = Long.valueOf(matricula.trim());
            Estudiante est = estudiantes.get(mat);
            return est != null && password.equals(est.getPassword());
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public boolean iniciarSesionPorCorreo(String correo, String password) {
        return estudiantes.values().stream()
                .anyMatch(est -> est.getCorreo().equalsIgnoreCase(correo)
                             && password.equals(est.getPassword()));
    }
    
    public Estudiante buscarPorMatriculaYPassword(String matriculaTexto, String password) {
        try {
            Long mat = Long.valueOf(matriculaTexto.trim());
            Estudiante est = estudiantes.get(mat);
            return (est != null && password.equals(est.getPassword())) ? est : null;
        } catch (NumberFormatException ex) {
            return null;
        }
    }
    
    public Estudiante buscarPorCorreoYPassword(String correo, String password) {
        return estudiantes.values().stream()
            .filter(est -> est.getCorreo().equalsIgnoreCase(correo)
                      && password.equals(est.getPassword()))
            .findFirst()
            .orElse(null);
    }
    
}
