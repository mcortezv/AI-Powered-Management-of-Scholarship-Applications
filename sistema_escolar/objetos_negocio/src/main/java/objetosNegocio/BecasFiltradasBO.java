package objetosNegocio;
import adaptadores.BecasFiltradasAdaptador;
import dominio.Beca;
import dominio.BecasFiltradas;
import dto.BecasDisponiblesResponseDTO;
import dto.RequisitosDTO;
import excepciones.BecaInvalidaException;
import interfaces.IBecasFiltradasBO;
import interfaces.IFachadaGobierno;

/**
 *
 * @author Cortez, Manuel;
 */
public class BecasFiltradasBO implements IBecasFiltradasBO {
    private IFachadaGobierno fachadaGobierno;

    public BecasFiltradasBO(IFachadaGobierno fachadaGobierno) {
        this.fachadaGobierno = fachadaGobierno;
    }

    public BecasFiltradas obtenerBecasFiltradas(RequisitosDTO requisitosDTO) throws BecaInvalidaException {
        if (requisitosDTO.getPromedioMinimo() <= 0 || requisitosDTO.getIngresoFamiliarMaximo() <= 0 || requisitosDTO.getCargaAcademica() <= 0) {
            throw new BecaInvalidaException("Requisitos minimos invalidos");
        }
        BecasDisponiblesResponseDTO becasDisponiblesResponseDTO = fachadaGobierno.obtenerBecas(requisitosDTO);
        if (becasDisponiblesResponseDTO == null || becasDisponiblesResponseDTO.getBecas() == null
                || becasDisponiblesResponseDTO.getBecas().isEmpty()) {
            throw new BecaInvalidaException("No existe ninguna beca para estos requisitos");
        }
        return BecasFiltradasAdaptador.toEntity(becasDisponiblesResponseDTO);
    }

    public Beca obtenerBecaPorCodigo(int codigo, BecasFiltradas becasFiltradas) throws BecaInvalidaException {
        for (Beca beca : becasFiltradas.getBecas()) {
            if (beca.getCodigo() == codigo) {
                return beca;
            }
        }
        return null;
    }
}