/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio.mock;

import dto.BecaDTO;
import dto.RequisitosDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class BecaBOMock {
    private static BecaBOMock instancia;
    
    public BecaBOMock(){
        obtenerBecas();
    }
    
    public static BecaBOMock getInstance(){
        if(instancia==null){
            instancia= new BecaBOMock();
        } 
            return instancia; 
    }
    
    public SolicitudBecasDisponiblesResponseDTO obtenerBecas(){
 
        java.time.LocalDate ahora = java.time.LocalDate.now();
        List<BecaDTO> listaBecas = new ArrayList<>();
        
        BecaDTO beca1 = new BecaDTO(1, "Apoyo Economico", "Moisés Vázquez Gudiño", "Dirigida a estudiantes con escasos recursos económicos ", "2025-2", 50, new RequisitosDTO(7.0, 12000.0, 30.0, 50.0, 30.0, false, true), ahora.plusMonths(1));               
        BecaDTO beca2 = new BecaDTO(2, "Excelencia", "Beca Ara", "Dirigida a alumnos con excelencia academica y regulares con su plan de estudios", "2025-2", 20, new RequisitosDTO(9.0, 999999.0, 10.0, 70.0, 10.0, false, false), ahora.plusMonths(1));       
        BecaDTO beca3 = new BecaDTO(3, "Promedio", "Fundación Espinoza Rodríguez", "Está dirigida a estudiantes con buen promedio", "2025-2", 40, new RequisitosDTO(8.0, 15000.0, 20.0, 60.0, 20.0, false, false), ahora.plusMonths(1));
        BecaDTO beca4 = new BecaDTO(4, "Corporativa", "Constellation Brands", "Para impulsar las habilidades y capacidades de jóvenes universitarios.", "2025-2", 15, new RequisitosDTO(8.5, 20000.0, 15.0, 70.0, 15.0, true, false), ahora.plusMonths(1));
        
        listaBecas.add(beca1);
        listaBecas.add(beca2);
        listaBecas.add(beca3);
        listaBecas.add(beca4);   
        
        SolicitudBecasDisponiblesResponseDTO reponseDTO= new SolicitudBecasDisponiblesResponseDTO(listaBecas);
        
        return reponseDTO;
        
    }
    
}
