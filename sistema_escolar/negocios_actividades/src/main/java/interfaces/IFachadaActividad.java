
package interfaces;


import dto.actividades.ActividadDTO;
import dto.actividades.ActividadesDTO;
import dto.actividades.GrupoDTO;
import dto.actividades.GruposResponseDTO;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IFachadaActividad {

     ActividadesDTO obtenerActividades();
     GruposResponseDTO obtenerGrupos(ActividadDTO actividadDTO);

}