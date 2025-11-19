package presentacion.validadores;

public class ValidarTelefono implements IValidador {
    @Override
    public boolean validarDato(String dato) {
        return dato.matches("^\\\\d{10}$");
    }
}
