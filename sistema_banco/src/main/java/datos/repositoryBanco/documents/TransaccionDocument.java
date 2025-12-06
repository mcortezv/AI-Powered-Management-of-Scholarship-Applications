package datos.repositoryBanco.documents;

import org.bson.types.ObjectId;

import java.util.Date;

public class TransaccionDocument {
    private ObjectId id;
    private String folio;
    private String numeroTarjetaOrigen;
    private Double monto;
    private String entidadDestino;
    private String concepto;
    private Date fecha;
    private String estado;

    public TransaccionDocument() {}

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public String getFolio() { return folio; }
    public void setFolio(String folio) { this.folio = folio; }

    public String getNumeroTarjetaOrigen() { return numeroTarjetaOrigen; }
    public void setNumeroTarjetaOrigen(String numeroTarjetaOrigen) { this.numeroTarjetaOrigen = numeroTarjetaOrigen; }

    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }

    public String getEntidadDestino() { return entidadDestino; }
    public void setEntidadDestino(String entidadDestino) { this.entidadDestino = entidadDestino; }

    public String getConcepto() { return concepto; }
    public void setConcepto(String concepto) { this.concepto = concepto; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

