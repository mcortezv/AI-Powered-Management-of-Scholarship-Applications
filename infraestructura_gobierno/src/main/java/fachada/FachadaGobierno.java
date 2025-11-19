/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import control.ControlGobierno;
import dto.SolicitudBecasDisponiblesResponseDTO;
import dto.SolicitudDTO;
import dto.SolicitudLoginDTO;
import interfaces.IFachadaGobierno;
import java.util.Optional;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class FachadaGobierno implements IFachadaGobierno{
    private ControlGobierno controlGobierno;

    
    public FachadaGobierno(ControlGobierno controlGobierno) {
        this.controlGobierno= controlGobierno;
    }
    
    

  
    public Optional<SolicitudBecasDisponiblesResponseDTO> solicitarBecas(SolicitudDTO solicitudDTO) {
       return controlGobierno.solicitarBecas(solicitudDTO);
    }

    @Override
    public Optional<Boolean> enviarSolicitud(SolicitudDTO solicitudDTO) {
        return controlGobierno.enviarSolicitud(solicitudDTO);
    }
    
    
}
