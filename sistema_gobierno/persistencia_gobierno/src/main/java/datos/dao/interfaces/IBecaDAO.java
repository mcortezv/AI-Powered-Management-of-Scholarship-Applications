/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos.dao.interfaces;

import datos.dominio.Beca;
import datos.dto.RequisitosDTOI;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IBecaDAO {
    List<Beca> findByRequisitos(RequisitosDTOI requisitos);
}
