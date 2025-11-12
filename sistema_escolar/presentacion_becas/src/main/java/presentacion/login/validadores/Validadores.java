package presentacion.login.validadores;

import presentacion.login.exceptions.ContraseniaInvalidaException;
import presentacion.login.exceptions.CorreoInvalidoException;

/**
 *
 * @author Escalante, Sebastian.
 */
public class Validadores {

    public static void validarCorreo(String correo){
        if(correo == null || correo.trim().isEmpty()){
            throw new CorreoInvalidoException("Favor de ingresar un correo");
        }
        if(!correo.matches("^[A-Za-z0-9._%+-]+@potros\\.itson\\.edu\\.mx$")){
            throw new CorreoInvalidoException("Favor de ingresar un correo institucional @potros.itson.edu.mx");
        }
    }

    public static void validarContrasenia(String contrasenia){
        if(contrasenia == null || contrasenia.trim().isEmpty()){
            throw new ContraseniaInvalidaException("Favor de ingresar una contrasenia");
        }
        if(!contrasenia.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$")){
            throw new ContraseniaInvalidaException("Favor de ingresar una contraseña válida.");
        }
    }



}
