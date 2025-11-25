package presentacion.login.validadores;

import presentacion.login.exceptions.ContraseniaInvalidaException;
import presentacion.login.exceptions.IDInvalidoException;

/**
 *
 * @author Escalante, Sebastian.
 */
public class Validadores {

    public static void validarID(String id){
        if(id == null || id.trim().isEmpty()){
            throw new IDInvalidoException("Favor de ingresar el id de usuario");
        }
        if(!id.matches("^\\d{6}$")){
            throw new IDInvalidoException("Favor de ingresar un id correcto");
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
