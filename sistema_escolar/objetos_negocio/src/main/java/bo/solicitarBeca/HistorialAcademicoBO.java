package bo.solicitarBeca;
import itson.HistorialAcademicoDTOItson;
import bo.solicitarBeca.excepciones.HistorialInvalidoException;
import interfaces.IFachadaITSON;
import interfaces.solicitarBeca.IHistorialAcademicoBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoBO implements IHistorialAcademicoBO {
    private IFachadaITSON fachadaITSON;

    public HistorialAcademicoBO(IFachadaITSON fachadaITSON) {
        this.fachadaITSON = fachadaITSON;
    }

    public HistorialAcademicoDTOItson crearHistorial(Long matricula) throws HistorialInvalidoException {
        try {
            return fachadaITSON.verificarHistorialAcademcio(matricula);
        } catch (Exception e) {
            throw new HistorialInvalidoException("Ningun historial academico asociado la matricula");
        }
    }
}