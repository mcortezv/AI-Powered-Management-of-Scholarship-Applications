/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.tutorias;

import java.time.LocalDate;

/**
 *
 * @author katia
 */
public class FiltroHistorialDTO {
    private Long matriculaAlumno;
    
    // Pueden estar nulos
    private LocalDate fecha;   
    private Long idMateria;    

    public FiltroHistorialDTO() {
    }

    public FiltroHistorialDTO(Long matriculaAlumno, LocalDate fecha, Long idMateria) {
        this.matriculaAlumno = matriculaAlumno;
        this.fecha = fecha;
        this.idMateria = idMateria;
    }

    public Long getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(Long matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }
}
