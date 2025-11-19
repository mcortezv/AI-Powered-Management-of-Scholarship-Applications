/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import implementacion.ControlItson;
import java.util.Optional;
import interfaz.IFachadaITSON;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class FachadaItson implements IFachadaITSON{
    private ControlItson controlItson;

    public FachadaItson(ControlItson controlItson) {
        this.controlItson = controlItson;
    }
    
    

    @Override
    public Optional<EstudianteResponseDTO> verificarLogin(SolicitudLoginDTO solicitudLoginDTO) {
        return controlItson.verificarLogin(solicitudLoginDTO);
    }
    
}
