package presentacion.login.validadores;

import presentacion.login.exceptions.ContraseniaInvalidaException;
import presentacion.login.exceptions.CorreoInvalidoException;

/**
 *
 * @author Escalante, Sebastian.
 */
public class Validadores {

    public static boolean validarCorreo(String correo){
        if(correo == null || correo.trim().isEmpty()){
            throw new CorreoInvalidoException("Favor de ingresar un correo");
        }
        if(!correo.matches("^[A-Za-z0-9._%+-]+@potros\\.itson\\.edu\\.mx$\n")){
            throw new CorreoInvalidoException("Favor de ingresar un correo institucional @potros.itson.edu.mx");
        }
        return true;
    }

    public static boolean validarContrasenia(String contrasenia){
        if(contrasenia == null || contrasenia.trim().isEmpty()){
            throw new ContraseniaInvalidaException("Favor de ingresar una contrasenia");
        }
        if(!contrasenia.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$\n")){
            throw new ContraseniaInvalidaException("Favor de ingresar una contraseña válida.");
        }
        return true;
    }

}
