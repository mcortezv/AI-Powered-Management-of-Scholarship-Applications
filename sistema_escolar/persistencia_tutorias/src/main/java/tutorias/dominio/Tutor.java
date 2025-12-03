/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorias.dominio;

/**
 *
 * @author katia
 */
public class Tutor {
    private Long id;
    private String nombre;
    private String carrera;
    private String cubiculo;
    private String enlace;

    public Tutor() {
    }

    public Tutor(Long id, String nombre, String carrera, String cubiculo, String enlace) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.cubiculo = cubiculo;
        this.enlace = enlace;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
