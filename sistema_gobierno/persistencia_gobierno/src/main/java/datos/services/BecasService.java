/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.services;

import datos.dao.interfaces.IBecaDAO;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class BecasService {
    private final IBecaDAO becaDAO;
    public BecasService(IBecaDAO becaDAO){
        this.becaDAO = becaDAO;
    }
}
