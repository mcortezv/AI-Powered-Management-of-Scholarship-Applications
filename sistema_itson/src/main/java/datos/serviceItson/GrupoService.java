/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.serviceItson;

import datos.dominioItson.Actividad;
import datos.dominioItson.Grupo;
import datos.repositoryItson.daoItson.actividades.impl.GrupoDAO;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class GrupoService {
    
    private final GrupoDAO grupoDAO;

    public GrupoService() {
        this.grupoDAO = new GrupoDAO();
    }
    
    public List<Grupo> obtenerGrupos(Actividad actividad){
        return grupoDAO.obtenerGrupos(actividad);
        
    }
    
    
    
    
    
}
