package objetosNegocio;
import dominio.*;
import excepciones.*;
import interfaces.IEstudianteBO;

public class EstudianteBO implements IEstudianteBO {

    @Override
    public Estudiante crearEstudiante(String nombre, String correo, String telefono,
                                      Direccion direccion, Tutor tutor)
            throws EstudianteInvalidoException {

        if (nombre == null || correo == null || telefono == null || direccion == null)
            throw new EstudianteInvalidoException("Faltan datos obligatorios del estudiante.");

        if (tutor == null)
            throw new EstudianteInvalidoException("El estudiante debe tener un tutor.");

        return new Estudiante(null, nombre, tutor, null, telefono, direccion, correo);
    }
}
