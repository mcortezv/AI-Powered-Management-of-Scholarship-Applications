package presentacion.solicitarBeca.validadores;

import presentacion.login.exceptions.CorreoInvalidoException;
import presentacion.solicitarBeca.exceptions.IngresoInvalidoException;
import presentacion.solicitarBeca.exceptions.NombresInvalidosException;
import presentacion.solicitarBeca.exceptions.PromedioInvalidoException;

public class Validadores {
    private static double ingreso;

    public static boolean validarNombres(String nombres){
        if(nombres == null || nombres.trim().isEmpty()){
            throw new NombresInvalidosException("Favor de ingresar los nombres");
        }
        if(!nombres.matches("^(?!.*([A-Za-zÁÉÍÓÚáéíóúÑñ])\\1\\1)[A-Za-zÁÉÍÓÚáéíóúÑñ]{1,20}( [A-Za-zÁÉÍÓÚáéíóúÑñ]{1,20})?$\n")){
            throw new NombresInvalidosException("Favor de ingresar nombres validos, verifique que sean sus verdaderos nombres");
        }
        return true;
    }
    public static void validarApellido(String apellido){
        if(apellido == null || apellido.trim().isEmpty()){
            throw new NombresInvalidosException("Favor de ingresar un apellido");
        }
        if(!apellido.matches("^(?!.*([A-Za-zÁÉÍÓÚáéíóúÑñ])\\1\\1)([A-Za-zÁÉÍÓÚáéíóúÑñ]{1,15})( [A-Za-zÁÉÍÓÚáéíóúÑñ]{1,15}){0,2}$\n\n")){
            throw new NombresInvalidosException("Favor de ingresar un apellido válido, verifique que sean su apellido verdadero");
        }
    }

    public static boolean validarPromedio(double promedio){
        if (promedio < 0 || promedio > 10.0) {
            throw new PromedioInvalidoException("Favor de ingresar un promedio válido de 0.0 a 10.0");
        }
        return true;
    }

    public static boolean validarIngreso(double ingreso){
        if(ingreso < 0 || ingreso > 10000000){
            throw new IngresoInvalidoException("Favor de ingresar un ingreso válido.");
        }
        return true;
    }

    public static boolean validarCorreo(String correo){
        if(correo == null || correo.trim().isEmpty()){
            throw new CorreoInvalidoException("Favor de ingresar un correo válido");
        }
        if(!correo.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$\n")){
            throw new CorreoInvalidoException("Favor de ingresar un correo con el formato correcto");
        }
        return true;
    }
    public static boolean validarDireccion(String direccion){
        return true;
    }
    public static boolean validarTelefono(String telefono){
        return true;
    }
}
