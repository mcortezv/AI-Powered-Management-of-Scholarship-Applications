/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;
import control.ControlGobierno;
//import dto.BecasDisponiblesResponseDTO;
import dto.BecasFiltradasDTO;
import dto.RequisitosDTO;
import dto.SolicitudDTO;
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
    public BecasFiltradasDTO obtenerBecas(RequisitosDTO requisitosDTO) {
        return controlGobierno.solicitarBecas(requisitosDTO);
    }

    @Override
    public boolean enviarSolicitud(SolicitudDTO solicitudDTO) {
        return controlGobierno.enviarSolicitud(solicitudDTO);
    }
}
