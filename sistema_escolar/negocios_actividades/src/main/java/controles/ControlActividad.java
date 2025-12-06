
package controles;

import adaptadores.actividades.ActividadesAdaptador;
import adaptadores.actividades.GruposAdaptador;
import dto.actividades.ActividadDTO;
import dto.actividades.ActividadesDTO;
import dto.actividades.GrupoDTO;
import dto.actividades.GruposResponseDTO;
import dto.actividades.InscripcionDTO;
import interfaces.actividades.IActividadBO;
import interfaces.actividades.IGrupoBO;
import interfaces.actividades.IInscripcionBO;
//import interfaces.actividades.IInscripcionBO;
import itson.ActividadDTOItson;
import itson.ActividadesDTOItson;
import itson.actividades.GruposResponseDTOItson;

import java.util.Objects;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlActividad {

    private final IActividadBO actividadBO;
    private final IGrupoBO grupoBO;


    public ControlActividad(IActividadBO actividadBO, IGrupoBO grupoBO) {
        this.actividadBO= Objects.requireNonNull(actividadBO);
        this.grupoBO= Objects.requireNonNull(grupoBO);
        
    }

    public ActividadesDTO obtenerActividades(){
        return actividadBO.obtenerActividades();
       // return ActividadesAdaptador.toDTO(actividadesDTOItson);
    }
    
    public GruposResponseDTO obtenerGrupos(ActividadDTO actividadDTO){
        
        return grupoBO.obtenerGrupos(actividadDTO);

//        ActividadDTOItson actividadDTOItson= ActividadesAdaptador.toDTOItson(actividadDTO);
//        GruposResponseDTOItson gruposResponseDTOItson= grupoBO.obtenerGrupos(actividadDTOItson);
//        GruposResponseDTO gruposResponseDTO= GruposAdaptador.DTOItsonToDTOActividadesLista(gruposResponseDTOItson);
//        return gruposResponseDTO;
        
    }
    
//     public InscripcionDTO inscribirActividad(InscripcionDTO inscripcionDTO){
//         return inscripcionBO.inscribirActividad(inscripcionDTO);
//         
//     }
     
//     public EstudianteDTO buscarEstudiante(EstudianteDTO estudiante){
//         
//     }





}