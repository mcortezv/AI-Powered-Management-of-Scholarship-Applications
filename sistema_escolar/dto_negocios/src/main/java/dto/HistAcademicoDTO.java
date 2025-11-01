/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class HistAcademicoDTO {
    
    private String carrera;
    private String carga;
    private int semestre;
    
    public HistAcademicoDTO(){
        
    }

    public HistAcademicoDTO(String carrera, String carga, int semestre) {
        this.carrera = carrera;
        this.carga = carga;
        this.semestre = semestre;
    }
    
    

    public String getCarrera() {
        return carrera;
    }

    public String getCarga() {
        return carga;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    
    
    
}
