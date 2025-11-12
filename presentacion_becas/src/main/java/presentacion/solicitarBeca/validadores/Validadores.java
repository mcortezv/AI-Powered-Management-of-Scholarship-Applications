package presentacion.solicitarBeca.validadores;

import presentacion.login.exceptions.CorreoInvalidoException;
import presentacion.solicitarBeca.exceptions.*;

public class Validadores {
    private static double ingreso;

    public static void validarNombres(String nombres){
        if(nombres == null || nombres.trim().isEmpty()){
            throw new NombresInvalidosException("Favor de ingresar los nombres");
        }
        if(!nombres.matches("^(?!.*([A-Za-zÁÉÍÓÚáéíóúÑñ])\\1\\1)[A-Za-zÁÉÍÓÚáéíóúÑñ]{1,20}( [A-Za-zÁÉÍÓÚáéíóúÑñ]{1,20})?$")){
            throw new NombresInvalidosException("Favor de ingresar nombres validos, verifique que sean sus verdaderos nombres");
        }
    }
    public static void validarApellido(String apellido){
        if(apellido == null || apellido.trim().isEmpty()){
            throw new NombresInvalidosException("Favor de ingresar un apellido");
        }
        if(!apellido.matches("^(?!.*([A-Za-zÁÉÍÓÚáéíóúÑñ])\\1\\1)([A-Za-zÁÉÍÓÚáéíóúÑñ]{1,15})( [A-Za-zÁÉÍÓÚáéíóúÑñ]{1,15}){0,2}$")){
            throw new NombresInvalidosException("Favor de ingresar un apellido válido, verifique que sean su apellido verdadero");
        }
    }

    public static void validarPromedio(double promedio){
        if (promedio < 0 || promedio > 10.0) {
            throw new PromedioInvalidoException("Favor de ingresar un promedio válido de 0.0 a 10.0");
        }
    }

    public static void validarIngreso(double ingreso){
        if(ingreso < 0 || ingreso > 10000000){
            throw new IngresoInvalidoException("Favor de ingresar un ingreso válido.");
        }
    }

    public static void validarCorreo(String correo){
        if(correo == null || correo.trim().isEmpty()){
            throw new CorreoInvalidoException("Favor de ingresar un correo válido");
        }
        if(!correo.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            throw new CorreoInvalidoException("Favor de ingresar un correo con el formato correcto");
        }
    }
    public static void validarDireccion(String direccion){
        if(direccion == null || direccion.trim().isEmpty()){
            throw new DireccionInvalidaException("Favor de ingresar una dirección válida");
        }
        if(!direccion.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9#.,°\\- ]{5,100}$")){
            throw new DireccionInvalidaException("Favor de ingresar una dirección con el formato correcto");
        }
    }
    public static void validarTelefono(String telefono){
        if(telefono == null || telefono.trim().isEmpty()){
            throw new TelefonoInvalidoException("Favor de ingresar un número de teléfono válido");
        }
        if(!telefono.matches("^\\d{10}$\n")){
            throw new TelefonoInvalidoException("El número de teléfono ");
        }
    }
}
