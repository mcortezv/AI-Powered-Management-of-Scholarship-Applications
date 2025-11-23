/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;
import dto.EstudianteResponseDTO;
import dto.HistorialAcademicoResponseDTO;
import dto.LoginDTO;
import controles.ControlItson;
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
    public boolean verificarLogin(LoginDTO solicitudLoginDTO) {
        return controlItson.verificarLogin(solicitudLoginDTO);
    }

    @Override
    public EstudianteResponseDTO verificarEstudiante(Long matricula) {
        return controlItson.verificarEstudiante(matricula);
    }

    @Override
    public HistorialAcademicoResponseDTO verificarHistorialAcademcio(Long matricula) {
        return controlItson.verificarHistorialAcademcio(matricula);
    }
}
