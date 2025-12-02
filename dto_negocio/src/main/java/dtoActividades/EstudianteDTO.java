/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoActividades;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class EstudianteDTO {
    String matricula;
    String nombre;

    public EstudianteDTO(String matricula, String nombre) {
        this.matricula = matricula;
        this.nombre = nombre;
    }
    
    

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
