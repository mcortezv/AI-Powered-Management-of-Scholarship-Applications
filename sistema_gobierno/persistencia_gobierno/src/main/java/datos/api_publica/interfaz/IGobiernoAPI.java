package datos.api_publica.interfaz;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IGobiernoAPI {
    boolean verificarLogin(LoginDTOI dto);
    Estudiante obtenerDatosEstudiante(LoginDTOI dto);
}
