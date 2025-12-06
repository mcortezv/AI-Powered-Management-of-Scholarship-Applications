package datos.repositoryItson.daoItson.pagarAdeudo.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import datos.configMongoItson.MongoClienteProvider;
import datos.dominioItson.pagarAdeudo.Clase;
import datos.excepciones.DaoException;
import datos.repositoryItson.daoItson.pagarAdeudo.IClaseDAO;
import datos.repositoryItson.documents.pagarAdeudo.ClaseDocument;

import java.util.ArrayList;
import java.util.List;

public class ClaseDAO implements IClaseDAO {
    private final MongoCollection<ClaseDocument> col;

    public ClaseDAO() {
        this.col = MongoClienteProvider.INSTANCE.getCollection("clases", ClaseDocument.class);
    }

    @Override
    public List<ClaseDocument> obtenerListaClasesByMatricula(Long matricula){
        try{
            System.out.println(matricula);
          return col.find(Filters.eq("idEstudiante",matricula)).into(new ArrayList<>());
        }catch (DaoException ex){
            System.out.println("Error al obtener clases por matricula" +  ex.getMessage());
            throw new DaoException("Error al obtener clases por matricula" +  ex.getMessage());
        }
    }
}
