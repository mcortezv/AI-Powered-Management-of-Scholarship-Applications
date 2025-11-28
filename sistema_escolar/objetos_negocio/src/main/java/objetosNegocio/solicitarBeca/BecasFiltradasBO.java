package objetosNegocio.solicitarBeca;
import dto.gobierno.RequisitosDTOGobierno;
import solicitarBeca.dominio.Beca;
import solicitarBeca.dominio.BecasFiltradas;
import dto.gobierno.BecasDisponiblesDTOGobierno;
import objetosNegocio.solicitarBeca.excepciones.BecaInvalidaException;
import interfaces.solicitarBeca.IBecasFiltradasBO;
import interfaces.IFachadaGobierno;
import java.util.Objects;

/**
 *
 * @author Cortez, Manuel;
 */
public class BecasFiltradasBO implements IBecasFiltradasBO {
    private final IFachadaGobierno fachadaGobierno;

    public BecasFiltradasBO(IFachadaGobierno fachadaGobierno) {
        this.fachadaGobierno = fachadaGobierno;
    }

    @Override
    public BecasDisponiblesDTOGobierno obtenerBecasFiltradas(RequisitosDTOGobierno requisitos) throws BecaInvalidaException {
        BecasDisponiblesDTOGobierno becasDisponiblesResponseDTO = fachadaGobierno.obtenerBecas(requisitos);
        if (becasDisponiblesResponseDTO == null || becasDisponiblesResponseDTO.getBecas() == null
                || becasDisponiblesResponseDTO.getBecas().isEmpty()) {
            throw new BecaInvalidaException("No existe ninguna beca para estos requisitos");
        }
        return becasDisponiblesResponseDTO;
    }

    @Override
    public Beca obtenerBecaPorCodigo(Long codigo, BecasFiltradas becasFiltradas) throws BecaInvalidaException {
        for (Beca beca : becasFiltradas.getBecas()) {
            if (Objects.equals(beca.getCodigo(), codigo)) {
                return beca;
            }
        }
        throw new BecaInvalidaException("No existe ninguna beca para estos requisitos");
    }
}