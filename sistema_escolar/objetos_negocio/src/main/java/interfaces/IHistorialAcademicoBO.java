package interfaces;
import dominio.*;
import dominio.enums.Carrera;
import excepciones.*;

public interface IHistorialAcademicoBO {
    HistorialAcademico crearHistorial(double cargaAcademica, Carrera carrera, double indiceReprobacion, double porcentajeBajas, double promedio, int semestre)
            throws HistorialInvalidoException;
}
