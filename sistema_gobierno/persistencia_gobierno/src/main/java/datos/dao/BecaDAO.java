/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.dao;
import datos.dao.excepciones.BecaDAOException;
import datos.dao.interfaces.IBecaDAO;
import dto.gobierno.BecasDisponiblesDTOGobierno;
import dto.gobierno.RequisitosDTOGobierno;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class BecaDAO implements IBecaDAO{
    
    public BecasDisponiblesDTOGobierno obtenerBecas(RequisitosDTOGobierno requisistos){
        try {
            return null;
        } catch (Exception sinUso){
            throw new BecaDAOException("Error al obtener las becas filtradas");
        }
    }
}
