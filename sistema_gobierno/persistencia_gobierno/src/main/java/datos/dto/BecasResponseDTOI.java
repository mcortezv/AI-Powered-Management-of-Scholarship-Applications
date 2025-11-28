/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.dto;

import datos.dominio.Beca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class BecasResponseDTOI {
    private List<Beca> becas = new ArrayList<>();
    
    public BecasResponseDTOI(){
        
    }
    
    public BecasResponseDTOI(List<Beca> becas){
        this.becas = becas;
    }
    
    public List<Beca> getBecas(){
        return becas;
    }
    
    public void setBecas(List<Beca> becas){
        this.becas = becas;
    }
}
