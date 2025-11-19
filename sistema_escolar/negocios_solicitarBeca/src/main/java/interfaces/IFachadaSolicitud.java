/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import dominio.*;
import dto.*;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IFachadaSolicitud {

    BecasFiltradas obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO);

    boolean validarRequisitos(Requisitos requisitos);

    boolean validarSolicitudNoExistente(int idEstudiante, int idSolicitud);

    Beca recuperarBeca(int idBeca);

    Estudiante solicitarDatosEstudiante(int  idEstudiante);

    Solicitud crearSolicitud();

    boolean guardarSolicitud(Solicitud solicitud);

    boolean enviarSolicitudGobierno(SolicitudDTO solicitudDTO);
}
