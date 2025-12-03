/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorias.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import tutorias.dominio.enums.EstadoCita;
import tutorias.dominio.enums.Modalidad;

/**
 *
 * @author katia
 */
public class Cita {
    private Long id;
    private Long matriculaAlumno;
    private Long idTutor;
    private Materia materia;
    private String tema;
    private Modalidad modalidad;
    private LocalDate fecha;
    private LocalTime hora;
    private String ubicacion;
    private EstadoCita estado;

    public Cita() {
    }

    public Cita(Long id, Long matriculaAlumno, Long idTutor, Materia materia, String tema, Modalidad modalidad, LocalDate fecha, LocalTime hora, String ubicacion, EstadoCita estado) {
        this.id = id;
        this.matriculaAlumno = matriculaAlumno;
        this.idTutor = idTutor;
        this.materia = materia;
        this.tema = tema;
        this.modalidad = modalidad;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Long getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public Materia getMateria() {
        return materia;
    }

    public String getTema() {
        return tema;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMatriculaAlumno(Long matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }
    
    
    
}
