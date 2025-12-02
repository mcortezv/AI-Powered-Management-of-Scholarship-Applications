/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.actividadesExtracurriculares.coordinador;

import dto.actividades.ActividadesDTO;
import interfaces.IFachadaActividad;
import java.util.ArrayList;
import java.util.List;
import presentacion.actividadesExtracurriculares.coordNegocio.CoordinadorNegocioActividades;
import presentacion.actividadesExtracurriculares.panels.ActividadesExtracurriculares;
//import presentacion.actividadesExtracurriculares.panels.MainFrameActividades;
import presentacion.actividadesExtracurriculares.panels.MenuOpciones;
import presentacion.coordinadorAplicacion.ICoordinadorAplicacion;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class CoordinadorAplicacionActividades implements ICoordinadorAplicacionActividades{
    
    
  //  private MainFrameActividades mainFrameActividades;
    private ActividadesExtracurriculares actividades;
    private final CoordinadorNegocioActividades coordinadorNegocioActividades;
    
     
    
    public CoordinadorAplicacionActividades(IFachadaActividad fachadaActividad){
        coordinadorNegocioActividades= new CoordinadorNegocioActividades(fachadaActividad);
    }
    
    public void iniciarGUI(){
        if(actividades==null){
            actividades= new ActividadesExtracurriculares(this);
        }
        actividades.setVisible(true);
    }
    
    
    
//    public void iniciarGUI(){
//        if(mainFrameActividades==null){
//            mainFrameActividades= new MainFrameActividades(this);
//        }
//        mainFrameActividades.setVisible(true);
//    }
    
    public void inscribirActividad(){
     //   ActividadesDTO actividadeDTOs= coordinadorNegocioActividades.obtenerActividades();
        actividades.showPanel("ListaActividades");
    }
    
    //quizas mover esto 
    public ActividadesDTO obtenerActividades(){
        return coordinadorNegocioActividades.obtenerActividades();
    }
    
    public List<String> cargarInscripciones(){
        
        List<String> inscripciones= new ArrayList<>();
        inscripciones.add("Tenis");
        inscripciones.add("Futbol");
        return inscripciones;
    }
    
   
    
    public void setActividades(ActividadesExtracurriculares actividades){
        this.actividades= actividades;
    }
    
}

