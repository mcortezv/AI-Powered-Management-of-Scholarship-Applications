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
public class ListaCitasDTO {
    private List<CitaDTO> citas;

    public ListaCitasDTO() {
    }

    public ListaCitasDTO(List<CitaDTO> citas) {
        this.citas = citas;
    }

    public List<CitaDTO> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaDTO> citas) {
        this.citas = citas;
    }
}
