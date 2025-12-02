/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.repository.impl;

import com.mongodb.client.MongoCollection;
import itson.org.config.MongoClienteProvider;
import itson.org.domain.Actividad;
import itson.org.domain.Grupo;
import itson.org.repository.IActividadDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ActividadDAO implements IActividadDAO{
    
    private final MongoCollection<Actividad> coleccion;

    public ActividadDAO() {
        this.coleccion = MongoClienteProvider.INSTANCE.getCollection("actividades", Actividad.class);
    }
    
      public List<Actividad> obtenerActividades() {
          List<Actividad> actividades= coleccion.find().into(new ArrayList<>());
          System.out.println(actividades);
          return actividades;
          
      }
    
    
    
    
    
}
