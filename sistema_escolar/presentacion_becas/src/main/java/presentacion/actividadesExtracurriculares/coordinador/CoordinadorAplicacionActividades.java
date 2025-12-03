/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.actividadesExtracurriculares.coordinador;

import dto.actividades.ActividadDTO;
import dto.actividades.ActividadesDTO;
import dto.actividades.GrupoDTO;
import interfaces.IFachadaActividad;
import java.util.ArrayList;
import java.util.List;

import presentacion.CoordinadorAplicacion;
import presentacion.actividadesExtracurriculares.coordNegocio.CoordinadorNegocioActividades;
import presentacion.actividadesExtracurriculares.panels.ActividadesExtracurriculares;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class CoordinadorAplicacionActividades implements ICoordinadorAplicacionActividades{
    
    
  //  private MainFrameActividades mainFrameActividades;
    private ActividadesExtracurriculares actividades;
    private final CoordinadorNegocioActividades coordinadorNegocioActividades;
    private final CoordinadorAplicacion coordinadorPadre;
    
    public CoordinadorAplicacionActividades(IFachadaActividad fachadaActividad, CoordinadorAplicacion coordinadorAplicacion){
        this.coordinadorPadre = coordinadorAplicacion;
        coordinadorNegocioActividades= new CoordinadorNegocioActividades(fachadaActividad);

    }
    
    public void iniciarGUI(){
        if(actividades==null){
            actividades= new ActividadesExtracurriculares(this);
        }
        actividades.setVisible(true);
    }
    public void regresarAlMenuPrincipal() {
        if (actividades != null) {
            actividades.setVisible(false);
        }
        coordinadorPadre.mostrarMainFrame();
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
    
    public GrupoDTO obtenerGrupos(ActividadDTO actividadDTO){
       // return coordinadorNegocioActividades
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

