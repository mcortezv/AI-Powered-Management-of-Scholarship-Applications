/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.gobierno;
import java.time.LocalDate;

/**
 *
 * @author Cortez, Manuel;
 */
public class BecaDTOGobierno {
    private Long codigo;
    private String tipo;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int becasDisponibles;
    private RequisitosDTOGobierno requisitos;
    private LocalDate fechaResultados;

    public BecaDTOGobierno() {}

    public BecaDTOGobierno(int becasDisponibles, Long codigo, String descripcion, LocalDate fechaFin, LocalDate fechaInicio, LocalDate fechaResultados, String nombre, RequisitosDTOGobierno requisitos, String tipo) {
        this.becasDisponibles = becasDisponibles;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.fechaResultados = fechaResultados;
        this.nombre = nombre;
        this.requisitos = requisitos;
        this.tipo = tipo;
    }

    public int getBecasDisponibles() {
        return becasDisponibles;
    }

    public void setBecasDisponibles(int becasDisponibles) {
        this.becasDisponibles = becasDisponibles;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaResultados() {
        return fechaResultados;
    }

    public void setFechaResultados(LocalDate fechaResultados) {
        this.fechaResultados = fechaResultados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public RequisitosDTOGobierno getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(RequisitosDTOGobierno requisitos) {
        this.requisitos = requisitos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
