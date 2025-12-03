/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorias.repository.documents;

import java.time.Instant;
import org.bson.types.ObjectId;

/**
 *
 * @author katia
 */
public class MateriaDocument {
    private ObjectId _id;
    private Long idMateria;
    private String nombre;
    private Instant creadoEn;

    public MateriaDocument() {
    }

    public MateriaDocument(ObjectId _id, Long idMateria, String nombre, Instant creadoEn) {
        this._id = _id;
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.creadoEn = creadoEn;
    }

    public ObjectId get_id() {
        return _id;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreadoEn(Instant creadoEn) {
        this.creadoEn = creadoEn;
    }
    
    
    
}
