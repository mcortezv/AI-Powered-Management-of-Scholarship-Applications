/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.serviceItson;

import datos.dominioItson.Actividad;
import datos.repositoryItson.daoItson.impl.ActividadDAO;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ActividadService {
    
    private final ActividadDAO actividadDAO;

    public ActividadService(ActividadDAO actividadDAO) {
        this.actividadDAO = actividadDAO;
    }
    
    public ActividadService(){
        this.actividadDAO= new ActividadDAO();
    }
    
    public List<Actividad> obtenerActividades(){
        return actividadDAO.obtenerActividades();
    }
    
    
    
    
}
