/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.repositoryItson.daoItson.actividades.impl;

import com.mongodb.client.MongoCollection;
import datos.dominioItson.actividades.Inscripcion;
import datos.repositoryItson.daoItson.actividades.IInscripcionDAO;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class InscripcionDAO implements IInscripcionDAO{
    
    private final MongoCollection<Inscripcion> col;

    public InscripcionDAO(MongoCollection<Inscripcion> col) {
        this.col = col;
    }
    
    
    

}
