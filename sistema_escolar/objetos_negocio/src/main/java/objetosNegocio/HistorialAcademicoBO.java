package objetosNegocio;
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

    public HistorialAcademicoResponseDTO crearHistorial(String matricula) {
        return fachadaITSON.verificarHistorialAcademcio(matricula);
    }
}