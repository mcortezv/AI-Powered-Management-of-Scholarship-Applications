/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.actividades;

import itson.ActividadDTOItson;
import itson.actividades.GruposResponseDTOItson;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IGrupoBO {
    
     GruposResponseDTOItson obtenerGrupos(ActividadDTOItson actividadDTOItson);
    
}
