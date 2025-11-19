package presentacion.validadores;

public class ValidarNombre implements IValidador{
    @Override
    public boolean validarDato(String dato) {
        if(dato == null || dato.trim().isEmpty()){
            return false;
        }
        return dato.matches("^(?!.*([A-Za-zÁÉÍÓÚáéíóúÑñ])\\\\1\\\\1)[A-Za-zÁÉÍÓÚáéíóúÑñ]{1,20}( [A-Za-zÁÉÍÓÚáéíóúÑñ]{1,20})?$");
    }
}