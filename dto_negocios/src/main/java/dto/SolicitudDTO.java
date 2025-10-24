package dto;

import java.time.LocalDate;

public class SolicitudDTO {
    private long id;
    private String estado;
    private LocalDate fechaSolicitud;
    private EstudianteDTO estudianteDTO;
    private BecaDTO becaDTO;

}
