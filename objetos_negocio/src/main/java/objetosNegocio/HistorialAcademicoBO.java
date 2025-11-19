package objetosNegocio;
import dominio.HistorialAcademico;
import excepciones.HistorialInvalidoException;

public class HistorialAcademicoBO {
    public HistorialAcademico crearHistorial(String carrera, Double promedio) {
        if (carrera == null || promedio == null)
            throw new HistorialInvalidoException("Datos del historial incompletos");
        return new HistorialAcademico(carrera, promedio);
    }
}