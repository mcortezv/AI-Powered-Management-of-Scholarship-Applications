/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;

import dto.*;

import objetosNegocio.mock.BecaBOMock;
import objetosNegocio.mock.EstudianteMock;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlSolicitud {
    public EstudianteMock estudianteMock = new EstudianteMock();
    public BecaBOMock becaBO;

    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
        return becaBO.getInstance().obtenerBecas();
    }

    public EstudianteResponseDTO obtenerEstudiante(SolicitudLoginDTO solicitudLoginDTO){
        return estudianteMock.getEstudianteResponseDTO(solicitudLoginDTO);
    }


}
