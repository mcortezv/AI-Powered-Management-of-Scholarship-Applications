/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio.actividades;

import dto.actividades.ActividadDTO;
import dto.actividades.GruposResponseDTO;
import interfaces.IFachadaITSON;
import interfaces.actividades.IGrupoBO;
import itson.ActividadDTOItson;
import itson.actividades.GruposResponseDTOItson;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class GrupoBO implements IGrupoBO{
    
    private IFachadaITSON fachadaITSON;

    public GrupoBO(IFachadaITSON fachadaITSON) {
        this.fachadaITSON = fachadaITSON;
    }
    
   public GruposResponseDTOItson obtenerGrupos(ActividadDTOItson actividadDTOItson){
      //return fachadaITSON.
   }
    
    
    
}
