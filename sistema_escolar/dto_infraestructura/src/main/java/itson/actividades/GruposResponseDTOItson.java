/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.actividades;

import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class GruposResponseDTOItson {
    
    private List<GrupoResponseDTOItson> gruposItson;

    public GruposResponseDTOItson(List<GrupoResponseDTOItson> gruposItson) {
        this.gruposItson = gruposItson;
    }

    public List<GrupoResponseDTOItson> getGruposItson() {
        return gruposItson;
    }

    public void setGruposItson(List<GrupoResponseDTOItson> gruposItson) {
        this.gruposItson = gruposItson;
    }
    
    
    
}
