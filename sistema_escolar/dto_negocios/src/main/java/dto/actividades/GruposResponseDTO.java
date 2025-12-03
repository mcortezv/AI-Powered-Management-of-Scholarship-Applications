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
public class GruposResponseDTO {
    
    List<GrupoDTO> grupos;

    public GruposResponseDTO(List<GrupoDTO> grupos) {
        this.grupos = grupos;
    }

    public List<GrupoDTO> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<GrupoDTO> grupos) {
        this.grupos = grupos;
    }
    
    
    
    
    
}
