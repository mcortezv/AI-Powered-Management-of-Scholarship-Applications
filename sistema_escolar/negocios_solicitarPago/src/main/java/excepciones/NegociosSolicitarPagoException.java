package excepciones;

/**
 *
 * @author Cortez, Manuel;
 */
public class NegociosSolicitarPagoException extends RuntimeException {
    public NegociosSolicitarPagoException(String msg) { super(msg); }
}