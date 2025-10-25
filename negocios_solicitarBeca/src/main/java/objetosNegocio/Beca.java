/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package objetosNegocio;
import java.time.LocalDate;
import java.time.Period;
import objetosNegocio.enums.TipoBeca;

/**
 *
 * @author Cortez, Manuel;
 */
public class Beca {
    private int codigo;
    private TipoBeca tipo;
    private String nombre;
    private Period periodo;
    private int becasDisponibles;
    private Requisitos requisitos;
    private LocalDate fechaResultados;

    public Beca() {}

    public Beca(int codigo, TipoBeca tipo, String nombre, Period periodo, int becasDisponibles, Requisitos requisitos, LocalDate fechaResultados) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.periodo = periodo;
        this.becasDisponibles = becasDisponibles;
        this.requisitos = requisitos;
        this.fechaResultados = fechaResultados;
    }

    public int getBecasDisponibles() {
        return becasDisponibles;
    }

    public void setBecasDisponibles(int becasDisponibles) {
        this.becasDisponibles = becasDisponibles;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public Period getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Period periodo) {
        this.periodo = periodo;
    }

    public Requisitos getRequisitos() {
        return requisitos;
    }


    public TipoBeca getTipo() {
        return tipo;
    }

    public void setTipo(TipoBeca tipo) {
        this.tipo = tipo;
    }

    public void setRequisitos(Requisitos requisitos) {
        this.requisitos = requisitos;
    }
}
