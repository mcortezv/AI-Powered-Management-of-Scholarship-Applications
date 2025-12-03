
package tutorias.dominio;

/**
 *
 * @author katia
 */
public class Materia {
    private Long id;
    private String nombre;

    public Materia() {
    }

    public Materia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
