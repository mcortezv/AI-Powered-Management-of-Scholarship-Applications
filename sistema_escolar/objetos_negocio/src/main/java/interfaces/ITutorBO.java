package interfaces;
import dominio.*;
import excepciones.*;

public interface ITutorBO {
    Tutor crearTutor(String nombre, String correo, String telefono,
                     Direccion direccion)
            throws TutorInvalidoException;
}
