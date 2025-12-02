package datos.repositoryItson.daoItson.pagarAdeudo.impl;

import com.mongodb.client.MongoCollection;
import datos.configMongoItson.MongoClienteProvider;
import datos.dominioItson.pagarAdeudo.Clase;
import datos.repositoryItson.daoItson.pagarAdeudo.IClaseDAO;

import java.util.List;
import java.util.Optional;

public class ClaseDAO implements IClaseDAO {
    private final MongoCollection<Clase> col;

    public ClaseDAO() {
        this.col = MongoClienteProvider.INSTANCE.getCollection("clases", Clase.class);
    }

    @Override
    public Optional<List<Clase>> obtenerListaClasesByMatricula(Long matricula){
        return Optional.empty();
    }
}
