/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio.mock;

import java.util.HashMap;
import java.util.Map;
import objetosNegocio.Direccion;
import objetosNegocio.Estudiante;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class EstudianteMock {
    
    private Map<Long, Estudiante> estudiantes= new HashMap<>();

    TutorMock tutor= new TutorMock();

    
    public EstudianteMock(){
        cargarEstudiantes();
        
    }
    
    private void cargarEstudiantes(){
        Estudiante estudiante1= new Estudiante(258329L, "Luisa Perez", tutor.getTutores().get(0L), "khGfs7", "687378444", new Direccion("Luar", "Villas del Rey", "Ciudad Obregon"), "luisa@gmail.com");
        estudiantes.put(estudiante1.getMatricula(), estudiante1);        
    }

    public Map<Long, Estudiante> getEstudiantes() {
        return estudiantes;
    }

    
    
    
    
}
