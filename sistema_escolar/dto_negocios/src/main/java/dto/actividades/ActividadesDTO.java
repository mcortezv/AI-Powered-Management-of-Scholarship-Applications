/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.actividades;

import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ActividadesDTO {
    
    private List<ActividadDTO> actividades;

    public ActividadesDTO() {
    }
    
    

    public ActividadesDTO(List<ActividadDTO> actividades) {
        this.actividades = actividades;
    }

    public List<ActividadDTO> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadDTO> actividades) {
        this.actividades = actividades;
    }
    
    
    
    
}
