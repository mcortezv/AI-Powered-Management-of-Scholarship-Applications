package datos.excepciones;

public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }
}
