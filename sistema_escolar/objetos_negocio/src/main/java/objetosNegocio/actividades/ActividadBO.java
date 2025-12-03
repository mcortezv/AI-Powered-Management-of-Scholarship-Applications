/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio.actividades;


import datos.repositoryItson.daoItson.IActividadDAO;
import interfaces.IFachadaITSON;
import interfaces.actividades.IActividadBO;
import itson.ActividadesDTOItson;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ActividadBO implements IActividadBO {
    
    private IFachadaITSON fachadaITSON;

    public ActividadBO(IFachadaITSON fachadaITSON) {
        this.fachadaITSON= fachadaITSON;
    }
    
    @Override
    public ActividadesDTOItson obtenerActividades(){
        return fachadaITSON.obtenerActividades();
    }
    
    
    
    
}
