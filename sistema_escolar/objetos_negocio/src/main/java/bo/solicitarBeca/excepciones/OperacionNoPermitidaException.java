package bo.solicitarBeca.excepciones;

/**
 *
 * @author Cortez, Manuel;
 */
public class OperacionNoPermitidaException extends RuntimeException {
    public OperacionNoPermitidaException(String msg) { super(msg); }
}