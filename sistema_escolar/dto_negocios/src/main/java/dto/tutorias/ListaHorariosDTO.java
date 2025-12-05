/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.tutorias;

import java.util.List;

/**
 *
 * @author katia
 */
public class ListaHorariosDTO {

    private List<HorarioDTO> horarios;

    public ListaHorariosDTO() {
    }

    public ListaHorariosDTO(List<HorarioDTO> horarios) {
        this.horarios = horarios;
    }

    public List<HorarioDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioDTO> horarios) {
        this.horarios = horarios;
    }
}
