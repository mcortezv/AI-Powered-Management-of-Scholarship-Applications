/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tutorias.dao.interfaces;

import java.util.List;
import org.bson.types.ObjectId;
import tutorias.dominio.Materia;
import tutorias.excepciones.MateriaDAOException;
import tutorias.repository.documents.MateriaDocument;

/**
 *
 * @author katia
 */
public interface IMateriaDAO {
    Materia crear(Materia materia) throws MateriaDAOException;
    List<Materia> obtenerMaterias() throws MateriaDAOException;
    Materia obtenerPorId(Long idMateria) throws MateriaDAOException;
}
