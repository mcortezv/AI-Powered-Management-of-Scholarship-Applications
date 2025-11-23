/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import control.ControlGobierno;
import dto.BecasDisponiblesResponseDTO;
import dto.SolicitudDTO;
import interfaces.IFachadaGobierno;
import java.util.Optional;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class FachadaGobierno implements IFachadaGobierno{
    private final ControlGobierno controlGobierno;

    
    public FachadaGobierno(ControlGobierno controlGobierno) {
        this.controlGobierno= controlGobierno;
    }

    @Override
    public Optional<BecasDisponiblesResponseDTO> obtenerBecas(SolicitudDTO solicitudDTO) {
       return controlGobierno.solicitarBecas(solicitudDTO);
    }

    @Override
    public Optional<Boolean> validarDocumento(DocumentoDTO documentoDTO){
        return controlGobierno.validarDocumento(documentoDTO);
    }

    @Override
    public Optional<Boolean> enviarSolicitud(SolicitudDTO solicitudDTO) {
        return controlGobierno.enviarSolicitud(solicitudDTO);
    }
    
    
}
