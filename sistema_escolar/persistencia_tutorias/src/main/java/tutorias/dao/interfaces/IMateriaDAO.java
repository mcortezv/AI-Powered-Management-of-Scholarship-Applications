/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tutorias.dao.interfaces;

import java.util.List;
import org.bson.types.ObjectId;
import tutorias.excepciones.MateriaDAOException;
import tutorias.repository.documents.MateriaDocument;

/**
 *
 * @author katia
 */
public interface IMateriaDAO {
    ObjectId create(MateriaDocument entity) throws MateriaDAOException;

    List<MateriaDocument> obtenerMaterias() throws MateriaDAOException;
}
