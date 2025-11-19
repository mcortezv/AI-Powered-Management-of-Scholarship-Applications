package interfaces;
import dominio.*;
import excepciones.*;

public interface IEstudianteBO {
    Estudiante crearEstudiante(String nombre, String correo, String telefono,
                               Direccion direccion, Tutor tutor)
            throws EstudianteInvalidoException;
}
