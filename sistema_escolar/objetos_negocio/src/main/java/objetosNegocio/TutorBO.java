package objetosNegocio;
import dominio.*;
import excepciones.*;
import interfaces.ITutorBO;

public class TutorBO implements ITutorBO {

    @Override
    public Tutor crearTutor(String nombre, String correo, String telefono,
                            Direccion direccion)
            throws TutorInvalidoException {

        if (nombre == null || correo == null || telefono == null || direccion == null)
            throw new TutorInvalidoException("Datos de tutor incompletos.");

        return new Tutor(nombre, null, telefono, direccion, correo);
    }
}
