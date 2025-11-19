package interfaces;
import dominio.*;
import dominio.enums.Carrera;
import excepciones.*;

public interface IHistorialAcademicoBO {
    HistorialAcademico crearHistorial(double carga, double indiceReprob,
                                      double bajas, double promedio,
                                      int semestre, Carrera carrera)
            throws HistorialInvalidoException;
}
