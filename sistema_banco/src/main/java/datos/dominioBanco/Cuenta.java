package datos.dominioBanco;

import org.bson.types.ObjectId;

public class Cuenta {
    private ObjectId id;
    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaVencimiento;
    private String cvv;
    private Double saldo;
    private String tipo;

    public Cuenta() {}

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public String getNumeroTarjeta() { return numeroTarjeta; }
    public void setNumeroTarjeta(String numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }

    public String getNombreTitular() { return nombreTitular; }
    public void setNombreTitular(String nombreTitular) { this.nombreTitular = nombreTitular; }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
