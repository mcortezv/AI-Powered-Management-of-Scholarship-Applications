/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import dto.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import objetosNegocio.Estudiante;
import objetosNegocio.Solicitud;
import objetosNegocio.mock.BecaBOMock;
import objetosNegocio.mock.EstudianteMock;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class GestorSolicitud {
    
    BecaBOMock becaBO;
    private EstudianteMock estudianteMock = EstudianteMock.getInstance();

    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
        return becaBO.getInstance().obtenerBecas();
    }


    public EstudianteResponseDTO validarInicioSesion(SolicitudLoginDTO solicitudLoginDTO) {
        String usuario = solicitudLoginDTO.getUsuario();       
        String password = solicitudLoginDTO.getContrasenia();

        Estudiante estudiante = null;
        if (usuario != null && usuario.matches("\\d+")) {
            estudiante = EstudianteMock.getInstance().buscarPorMatriculaYPassword(usuario, password);
        } 
        if (estudiante == null) {
            estudiante = EstudianteMock.getInstance().buscarPorCorreoYPassword(usuario, password);
        }
        if (estudiante == null) return null;

        return new EstudianteResponseDTO(
            "inscrito",
            9.8,
            estudiante.getCorreo(),
            estudiante.getDireccion() != null ? estudiante.getDireccion().getCalle() : "",
            estudiante.getTelefono(),
            "ISW",
            estudiante.getNombre(),
            estudiante.getMatricula() != null ? estudiante.getMatricula().intValue() : 0
        );
    }

}
