/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;
import controles.ControlItson;
import java.util.Optional;
import interfaces.IFachadaITSON;

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
    public Optional<EstudianteResponseDTO> verificarLogin(LoginDTO solicitudLoginDTO) {
        return controlItson.verificarLogin(solicitudLoginDTO);
    }
    
}
