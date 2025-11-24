/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Cortez, Manuel;
 */
public class DocumentoInfraestructuraDTO {
    private Long identificador;
    private String tipo;
    private byte[] contenido;
    private EstudianteInfraestructuraDTO estudiante;

    public DocumentoInfraestructuraDTO() {}

    public DocumentoInfraestructuraDTO(byte[] contenido, EstudianteInfraestructuraDTO estudiante, Long identificador, String tipo) {
        this.contenido = contenido;
        this.estudiante = estudiante;
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public EstudianteInfraestructuraDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteInfraestructuraDTO estudiante) {
        this.estudiante = estudiante;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
