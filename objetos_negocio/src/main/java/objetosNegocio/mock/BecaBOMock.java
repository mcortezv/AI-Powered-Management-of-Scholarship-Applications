/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio.mock;

import dto.BecaDTO;
import dto.RequisitosBecaDTO;
import dto.RequisitosDTO;
import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import dto.SolicitudDTO;
import interfaces.IBecaBOMock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class BecaBOMock implements IBecaBOMock {
    private static BecaBOMock instancia;
    //private final BecaBOMock becaMock = BecaBOMock.getInstance();
    
    private BecaBOMock(){
        
    }
    
//    public BecaBOMock(){
//        obtenerBecas();
//    }
    
    public static BecaBOMock getInstance(){
        if(instancia==null){
            instancia= new BecaBOMock();
        } 
            return instancia; 
    }
    
    public List<BecaDTO> obtenerBecas(){
 
        java.time.LocalDate ahora = java.time.LocalDate.now();
        List<BecaDTO> listaBecas = new ArrayList<>();
        
        BecaDTO beca1 = new BecaDTO(1, "Apoyo Economico", "Moisés Vázquez Gudiño", "Dirigida a estudiantes con escasos recursos económicos, Dirigida a estudiantes con escasos recursos económicos, Dirigida a estudiantes con escasos recursos económicos, Dirigida a estudiantes con escasos recursos económicos, "
                + "Dirigida a estudiantes con escasos recursos económicos, Dirigida a estudiantes con escasos recursos económicos, Dirigida a estudiantes con escasos recursos económicos ", "2025-2", 50, new RequisitosBecaDTO(0, 1200, null), ahora.plusMonths(1));               
        BecaDTO beca2 = new BecaDTO(2, "Excelencia", "Beca Ara", "Dirigida a alumnos con excelencia academica y regulares con su plan de estudios", "2025-2", 20, new RequisitosBecaDTO(9, 1000000, true), ahora.plusMonths(1));       
        BecaDTO beca3 = new BecaDTO(3, "Promedio", "Fundación Espinoza Rodríguez", "Está dirigida a estudiantes con buen promedio", "2025-2", 40, new RequisitosBecaDTO(8, 1000000, null), ahora.plusMonths(1));
        BecaDTO beca4 = new BecaDTO(4, "Corporativa", "Constellation Brands", "Para impulsar las habilidades y capacidades de jóvenes universitarios.", "2025-2", 15, new RequisitosBecaDTO(7, 1000000, null), ahora.plusMonths(1));
        
        listaBecas.add(beca1);
        listaBecas.add(beca2);
        listaBecas.add(beca3);
        listaBecas.add(beca4);   
        
       // SolicitudBecasDisponiblesResponseDTO responseDTO= new SolicitudBecasDisponiblesResponseDTO(listaBecas);
        
        return listaBecas;
        
    }
    
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO){
        List<BecaDTO> becas= obtenerBecas();
        List<BecaDTO> listaBecasDisponibles= new ArrayList<>();
        
        for(BecaDTO beca: becas){
            RequisitosBecaDTO requisitos= beca.getRequisitos();
            boolean cumplePromedio= solicitudDTO.getPromedioActual()>= requisitos.getPromedioMinimo();
            boolean cumpleIngreso= solicitudDTO.getIngresoMensualFamilia()<=requisitos.getIngresoFamiliarMaximo();
            Boolean cumpleCarga;
            if(beca.getRequisitos().isCargaAcademica()!=null){
                 cumpleCarga= solicitudDTO.getCargaAcademica()== requisitos.getCargaAcademica();
            } else{
                cumpleCarga= true;
            }
            
            if(cumplePromedio && cumpleIngreso && cumpleCarga){
                listaBecasDisponibles.add(beca);
            }
      
        }
        SolicitudBecasDisponiblesResponseDTO solicitudBecasDispResponse= new SolicitudBecasDisponiblesResponseDTO(listaBecasDisponibles);
        return solicitudBecasDispResponse;
    }
    
//    public List<BecaDTO> obtenerBecasVigentes() {
//        return obtenerBecas().getBecas().stream()
//                .filter(b -> b.getFechaLimite().isAfter(LocalDate.now())).toList();
//    }

    
}
