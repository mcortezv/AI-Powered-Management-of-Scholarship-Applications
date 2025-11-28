/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;
import control.ControlGobierno;
import dto.gobierno.BecasDisponiblesDTOGobierno;
import dto.gobierno.RequisitosDTOGobierno;
import dto.gobierno.SolicitudDTOGobierno;
import dto_gobierno.SolicitudDTO;
import interfaces.IFachadaGobierno;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class FachadaGobierno implements IFachadaGobierno{
    private final ControlGobierno controlGobierno;

    public FachadaGobierno(ControlGobierno controlGobierno) {
        this.controlGobierno = controlGobierno;
    }

    @Override
    public BecasDisponiblesDTOGobierno obtenerBecas(RequisitosDTOGobierno requisitosDTO) {
        return controlGobierno.solicitarBecas(requisitosDTO);
    }

    @Override
    public boolean enviarSolicitud(SolicitudDTOGobierno solicitudDTO) {
        return controlGobierno.enviarSolicitud(solicitudDTO);
    }
}
