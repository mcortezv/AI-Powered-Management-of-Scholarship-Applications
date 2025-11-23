/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import dominio.enums.TipoDocumento;

/**
 *
 * @author Cortez, Manuel;
 */
public class Documento {
    private int identificador;
    private TipoDocumento tipo;
    private Estudiante estudiante;

    public Documento() {}

    public Documento(TipoDocumento tipo, Estudiante estudiante) {
        this.estudiante = estudiante;
        this.tipo = tipo;
    }

    public Documento(int identificador, TipoDocumento tipo, Estudiante estudiante) {
        this.estudiante = estudiante;
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }
}
