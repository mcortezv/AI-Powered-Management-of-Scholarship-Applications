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
        String correo = solicitudLoginDTO.getUsuario();
        String password = solicitudLoginDTO.getContrasenia();
        
        return null;
    }

}
