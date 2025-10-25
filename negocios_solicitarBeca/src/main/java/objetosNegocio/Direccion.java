/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class Direccion {
    String calle;
    String colonia;
    String ciudad;

    public Direccion() {
    }

    public Direccion(String calle, String colonia, String ciudad) {
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCiudad() {
        return ciudad;
    }
    
    
}
