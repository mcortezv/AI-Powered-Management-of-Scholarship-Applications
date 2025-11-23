package objetosNegocio;
import adaptadores.HistorialAcademicoAdaptador;
import solicitarBeca.dominio.HistorialAcademico;
import dto.HistorialAcademicoResponseDTO;
import interfaces.IFachadaITSON;
import interfaces.IHistorialAcademicoBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoBO implements IHistorialAcademicoBO {
    private IFachadaITSON fachadaITSON;

    public HistorialAcademicoBO(IFachadaITSON fachadaITSON) {
        this.fachadaITSON = fachadaITSON;
    }

    public HistorialAcademico crearHistorial(Long matricula) {
        HistorialAcademicoResponseDTO dto = fachadaITSON.verificarHistorialAcademcio(matricula);
        return HistorialAcademicoAdaptador.toEntity(dto);
    }
}