package dto;
import java.time.LocalDate;

/**
 *
 * @author Cortez, Manuel;
 */
public class ResolucionInfraestructuraDTO {
    private SolicitudInfraestructuraDTO solicitud;
    private String decision;
    private String motivo;
    private LocalDate fechaEvaluacion;

    public ResolucionInfraestructuraDTO(String decision, LocalDate fechaEvaluacion, String motivo, SolicitudInfraestructuraDTO solicitud) {
        this.decision = decision;
        this.fechaEvaluacion = fechaEvaluacion;
        this.motivo = motivo;
        this.solicitud = solicitud;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public SolicitudInfraestructuraDTO getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudInfraestructuraDTO solicitud) {
        this.solicitud = solicitud;
    }
}
