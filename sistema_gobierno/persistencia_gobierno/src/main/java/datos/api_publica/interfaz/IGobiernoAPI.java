package datos.api_publica.interfaz;

import datos.dominio.Beca;
import datos.dto.BecasResponseDTOI;
import datos.dto.RequisitosDTOI;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IGobiernoAPI {
    boolean verificarLogin(LoginDTOI dto);
 //   Estudiante obtenerDatosEstudiante(LoginDTOI dto);
    BecasResponseDTOI solicitarBecas(RequisitosDTOI dto);
}
