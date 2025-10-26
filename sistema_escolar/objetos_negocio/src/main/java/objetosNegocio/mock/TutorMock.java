/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio.mock;

import java.util.HashMap;
import java.util.Map;
import objetosNegocio.Direccion;
import objetosNegocio.Tutor;
import objetosNegocio.enums.Parentesco;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class TutorMock {

    Map<Long, Tutor> tutores= new HashMap<>();
    
    public TutorMock(){
        cargarTutores();
    }
    
    private void cargarTutores(){
        Tutor tutor1= new Tutor(0L, "Juan Fernandez", Parentesco.PADRE, "6871616433", new Direccion("Antonio Caso", "Villa Itson", "Ciudad Obregon"), "juanfernandez@gmail.com");
        tutores.put(tutor1.getId(), tutor1);        
    }

    public Map<Long, Tutor> getTutores() {
        return tutores;
    }

    
    

    
    
}
