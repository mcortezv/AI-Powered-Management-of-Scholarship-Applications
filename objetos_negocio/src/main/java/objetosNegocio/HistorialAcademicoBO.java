package objetosNegocio;
import dominio.HistorialAcademico;
import dominio.enums.Carrera;
import excepciones.HistorialInvalidoException;
import interfaces.IHistorialAcademicoBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoBO implements IHistorialAcademicoBO {

    public HistorialAcademico crearHistorial(double cargaAcademica, Carrera carrera, double indiceReprobacion, double porcentajeBajas, double promedio, int semestre) {
        if (carrera == null)
            throw new HistorialInvalidoException("Datos del historial incompletos");
        return new HistorialAcademico(cargaAcademica, carrera, indiceReprobacion,  porcentajeBajas, promedio, semestre);
    }
}