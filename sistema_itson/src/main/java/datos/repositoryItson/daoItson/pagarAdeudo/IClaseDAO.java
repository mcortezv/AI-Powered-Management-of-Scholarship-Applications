package datos.repositoryItson.daoItson.pagarAdeudo;

import datos.dominioItson.pagarAdeudo.Clase;
import datos.repositoryItson.documents.pagarAdeudo.ClaseDocument;

import java.util.List;

public interface IClaseDAO {
    List<ClaseDocument> obtenerListaClasesByMatricula(Long matricula);
}
