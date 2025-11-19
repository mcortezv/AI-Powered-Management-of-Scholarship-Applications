package adaptadores;
import dominio.*;
import dto.*;

public class EstudianteAdaptador {

    public static Estudiante fromDTO(EstudianteResponseDTO dto, Tutor tutor) {
        return new Estudiante(
                dto.getNombre(),
                tutor,
                "Contrasenia",
                dto.getTelefono(),
                new Direccion(dto.getDireccion()), // La direccion esta distinta
                dto.getCorreo()
        );
    }
}
