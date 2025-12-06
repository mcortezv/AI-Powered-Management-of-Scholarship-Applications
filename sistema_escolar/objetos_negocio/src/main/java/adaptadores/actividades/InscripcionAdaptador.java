/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores.actividades;

import dto.actividades.InscripcionDTO;
import itson.actividades.InscripcionDTOItson;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class InscripcionAdaptador {
    
    public static InscripcionDTOItson toDTOItson(InscripcionDTO inscripcionDTO){
        InscripcionDTOItson inscripcionDTOItson= new InscripcionDTOItson();
        inscripcionDTOItson.setFechaInscripcion(inscripcionDTO.getFechaInscripcion());
        inscripcionDTOItson.setMatriculaEstudiante(inscripcionDTO.getMatriculaEstudiante());
        inscripcionDTOItson.setNombreGrupo(inscripcionDTO.getNombreGrupo());
        inscripcionDTOItson.setCosto(inscripcionDTO.getCosto());
        inscripcionDTOItson.setDias(inscripcionDTO.getDias());
        inscripcionDTOItson.setHoraInicio(inscripcionDTO.getHoraInicio());
        inscripcionDTOItson.setHoraFin(inscripcionDTO.getHoraFin());
        return inscripcionDTOItson;
    }
    
    public static InscripcionDTO toDTONegocio(InscripcionDTOItson inscripcionDTOItson){
        InscripcionDTO inscripcionDTO= new InscripcionDTO();
        inscripcionDTO.setFechaInscripcion(inscripcionDTOItson.getFechaInscripcion());
        inscripcionDTO.setMatriculaEstudiante(inscripcionDTOItson.getMatriculaEstudiante());
        inscripcionDTO.setNombreGrupo(inscripcionDTOItson.getNombreGrupo());
        inscripcionDTO.setCosto(inscripcionDTOItson.getCosto());
        inscripcionDTO.setDias(inscripcionDTOItson.getDias());
        inscripcionDTO.setHoraInicio(inscripcionDTOItson.getHoraInicio());
        inscripcionDTO.setHoraFin(inscripcionDTOItson.getHoraFin());
        return inscripcionDTO;
    }
    
}
