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
public class ListaMateriasDTO {
    private List<MateriaDTO> materias;
    
    public ListaMateriasDTO() {
    }

    public ListaMateriasDTO(List<MateriaDTO> materias) {
        this.materias = materias;
    }

    public List<MateriaDTO> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaDTO> materias) {
        this.materias = materias;
    }
}
