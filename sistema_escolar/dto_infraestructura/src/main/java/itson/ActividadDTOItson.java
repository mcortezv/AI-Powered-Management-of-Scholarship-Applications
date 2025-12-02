/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.itson;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ActividadDTOItson {
    String nombre;
    double costo;

    public ActividadDTOItson(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public ActividadDTOItson() {
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
