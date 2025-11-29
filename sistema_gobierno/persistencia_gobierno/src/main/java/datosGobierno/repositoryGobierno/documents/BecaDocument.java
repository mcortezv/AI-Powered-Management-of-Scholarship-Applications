/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosGobierno.repositoryGobierno.documents;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Cortez, Manuel;
 */
public class BecaDocument {
    private Long codigo;
    private String tipo;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int becasDisponibles;
    private RequisitosDocument requisitos;
    private LocalDate fechaResultados;

    public BecaDocument() {}

    public BecaDocument(int becasDisponibles, Long codigo, String descripcion, LocalDate fechaFin, LocalDate fechaInicio, LocalDate fechaResultados, String nombre, RequisitosDocument requisitos, String tipo) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public RequisitosDocument getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(RequisitosDocument requisitos) {
        this.requisitos = requisitos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
