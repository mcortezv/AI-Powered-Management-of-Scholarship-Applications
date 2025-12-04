/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorias.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import tutorias.dominio.enums.EstadoDisponibilidad;

/**
 *
 * @author katia
 */
public class Horario {
    private Long id;
    private Long idTutor;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoDisponibilidad estadoDisponibilidad;

    public Horario() {
    }

    public Horario(Long id, Long idTutor, LocalDate fecha, LocalTime hora, EstadoDisponibilidad estadoDisponibilidad) {
        this.id = id;
        this.idTutor = idTutor;
        this.fecha = fecha;
        this.hora = hora;
        this.estadoDisponibilidad = estadoDisponibilidad;
    }

    public Long getId() {
        return id;
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public EstadoDisponibilidad getEstadoDisponibilidad() {
        return estadoDisponibilidad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setEstadoDisponibilidad(EstadoDisponibilidad estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
    }
}

