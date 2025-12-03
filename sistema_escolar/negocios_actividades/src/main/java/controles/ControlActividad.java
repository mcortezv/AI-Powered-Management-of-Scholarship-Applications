
package controles;

import adaptadores.actividades.ActividadesAdaptador;
import dto.actividades.ActividadDTO;
import dto.actividades.ActividadesDTO;
import dto.actividades.GrupoDTO;
import dto.actividades.GruposResponseDTO;
import interfaces.actividades.IActividadBO;
import itson.ActividadesDTOItson;

import java.util.Objects;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlActividad {

    private final IActividadBO actividadBO;

    public ControlActividad(IActividadBO actividadBO) {
        this.actividadBO= Objects.requireNonNull(actividadBO);
    }

    public ActividadesDTO obtenerActividades(){

        //  return ActividadesAdaptador.toDTO(actividadBO.obtenerActividades());
        ActividadesDTOItson actividadesDTOItson= actividadBO.obtenerActividades();
        return ActividadesAdaptador.toDTO(actividadesDTOItson);

    }
    
    public GruposResponseDTO obtenerGrupos(ActividadDTO actividadDTO){
        return null;
        
    }





}