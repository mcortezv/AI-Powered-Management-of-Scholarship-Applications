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
public interface IFachadaSolicitarBeca {

    BecasFiltradasDTO obtenerBecasDisponibles(RequisitosDTO requisitosDTO);

    boolean validarRequisitos(RequisitosDTO requisitos);

    boolean validarSolicitudNoExistente(Long idEstudiante, Long idSolicitud);

    Beca recuperarBeca(Long idBeca);

    Estudiante solicitarDatosEstudiante(Long  idEstudiante);

    Solicitud crearSolicitud();

    boolean guardarSolicitud();

    boolean enviarSolicitudGobierno();
}
