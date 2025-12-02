/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.adaptadores;

import datos.dominioItson.Actividad;
import itson.ActividadDTOItson;
import itson.ActividadesDTOItson;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ActividadAdaptador {
    
    public static ActividadDTOItson toResponseDTOAct(Actividad actividad){
        ActividadDTOItson actividadDTOItson= new ActividadDTOItson();
       
            actividadDTOItson.setNombre(actividad.getNombre());
            actividadDTOItson.setCosto(actividad.getCosto());
            return actividadDTOItson;
            
        }
    
    public static ActividadesDTOItson toResponseDTOListaAct(List<Actividad> actividades){
        ActividadesDTOItson actividadesDTOItson= new ActividadesDTOItson();
        List<ActividadDTOItson> listaActividadesDTOItson= new ArrayList<>();
        for(Actividad actividad: actividades){
            listaActividadesDTOItson.add(toResponseDTOAct(actividad));       
        }
        actividadesDTOItson.setActividades(listaActividadesDTOItson);
        return actividadesDTOItson;
    }
    
}
