package adaptadores;
import dominio.*;
import dto.*;

public class TutorAdaptador {

    public static Tutor fromDTO(TutorDTO dto) {
        return new Tutor(
                dto.getNombre(),
                dto.getParentesco(),
                dto.getTelefono(),
                new Direccion(dto.getCalle(), dto.getColonia(), dto.getCiudad()), // La direccion esta distinta
                dto.getCorreo()
        );
    }
}
