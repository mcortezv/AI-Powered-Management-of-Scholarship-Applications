/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.services;

import datos.dao.BecaDAO;
import datos.dao.interfaces.IBecaDAO;
import datos.dominio.Beca;
import datos.dto.BecasResponseDTOI;
import datos.dto.RequisitosDTOI;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class BecasService {
    private final IBecaDAO becaDAO;
    
    public BecasService(IBecaDAO becaDAO){
        this.becaDAO = becaDAO;
    }
    public BecasService(){
        this.becaDAO = new BecaDAO();
    }
    
    public BecasResponseDTOI obtenerBecas(RequisitosDTOI requisitosDTOI){
        
        List<Beca> becas = becaDAO.findByRequisitos(requisitosDTOI);
        
        return new BecasResponseDTOI(becas);
    }
}
