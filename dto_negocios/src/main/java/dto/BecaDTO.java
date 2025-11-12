package dto;

import java.time.LocalDate;
/**
 * @author Escalante, Sebastian.
 */
public class BecaDTO {
    private int codigo;
    private String tipo;
    private String nombre;
    private String descripcion;
    private String periodo;
    private int becasDisponibles;
    private RequisitosDTO requisitos;
    private LocalDate fechaResultados;

    public BecaDTO() {
    }

    public BecaDTO(int codigo, String tipo, String nombre, String descripcion, String periodo, int becasDisponibles, RequisitosDTO requisitos, LocalDate fechaResultados) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion= descripcion;
        this.periodo = periodo;
        this.becasDisponibles = becasDisponibles;
        this.requisitos = requisitos;
        this.fechaResultados = fechaResultados;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getBecasDisponibles() {
        return becasDisponibles;
    }

    public void setBecasDisponibles(int becasDisponibles) {
        this.becasDisponibles = becasDisponibles;
    }

    public RequisitosDTO getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(RequisitosDTO requisitos) {
        this.requisitos = requisitos;
    }

    public LocalDate getFechaResultados() {
        return fechaResultados;
    }

    public void setFechaResultados(LocalDate fechaResultados) {
        this.fechaResultados = fechaResultados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
