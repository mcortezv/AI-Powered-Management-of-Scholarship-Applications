package datos.repositoryItson.daoItson.pagarAdeudo.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import datos.configMongoItson.MongoClienteProvider;
import datos.excepciones.DaoException;
import datos.repositoryItson.daoItson.pagarAdeudo.IPrestamoDAO;
import datos.repositoryItson.documents.pagarAdeudo.PrestamoDocument;

import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO implements IPrestamoDAO {
    private final MongoCollection<PrestamoDocument> col;

    public PrestamoDAO() {
        this.col = MongoClienteProvider.INSTANCE.getCollection("prestamos", PrestamoDocument.class);
    }

    @Override
    public List<PrestamoDocument> obtenerListaPrestamosByMatricula(Long matricula){
        try{
            System.out.println(matricula);
            return col.find(Filters.eq("idEstudiante", matricula)).into(new ArrayList<>());
        }catch (DaoException ex){
            System.out.println("Error al obtener prestamos por matricula" +  ex.getMessage());
            throw new DaoException("Error al obtener prestamos por matricula" +  ex.getMessage());
        }
    }
}
