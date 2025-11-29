/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datosGobierno.repositoryGobierno.daoGobierno.interfacesGobierno;
import datosGobierno.repositoryGobierno.documents.BecaDocument;
import gobierno.RequisitosDTOGobierno;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IBecaDAO {
    List<BecaDocument> findByRequisitos(RequisitosDTOGobierno requisitos);
}
