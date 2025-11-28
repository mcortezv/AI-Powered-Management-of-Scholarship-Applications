/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos.dao.interfaces;
import dto.gobierno.BecasDisponiblesDTOGobierno;
import dto.gobierno.RequisitosDTOGobierno;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IBecaDAO {

    BecasDisponiblesDTOGobierno obtenerBecas(RequisitosDTOGobierno requisistos);
}
