/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;
import dto.EstudianteResponseDTO;
import dto.HistorialAcademicoResponseDTO;
import dto.LoginDTO;
import controles.ControlItson;
import dto.pagarAdeudo.ClaseDTOI;
import dto.pagarAdeudo.PrestamoDTOI;
import dto.pagarAdeudo.SolicitudPagoDTOI;
import interfaces.IFachadaITSON;

import java.util.List;

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


    /**
     *  TODO ESTO ES DEL CASO PAGAR ADEUDO
     * @param matriculaEstudiante
     * // SEBASTIAN ESCALANTE RAMIREZ
     * @return
     */
    @Override
    public double solicitarAdeudoBiblioteca(String matriculaEstudiante) {
        return controlItson.solicitarAdeudoBiblioteca(matriculaEstudiante);
    }

    @Override
    public double solicitarAdeudoColegiatura(String matriculaEstudiante) {
        return controlItson.solicitarAdeudoColegiatura(matriculaEstudiante);
    }

    @Override
    public List<PrestamoDTOI> solicitarListaPrestamso(String matriculaEstudiante) {
        return List.of();
    }

    @Override
    public List<ClaseDTOI> solicitarListaClases(String matriculaEstudiante) {
        return List.of();
    }

    @Override
    public boolean notificarLiquidacion(SolicitudPagoDTOI solicitudPagoDTOI) {
        return false;
    }

    /**
     * AQUI TERMINA CASO DE USO PAGAR ADEUDO
     */
}
