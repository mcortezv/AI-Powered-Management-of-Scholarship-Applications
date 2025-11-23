/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.mock;

import dto.BecasDisponiblesResponseDTO;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IBecaBOMock {
    
    public List<BecaDTO> obtenerBecas();
    public BecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO);
    
}
