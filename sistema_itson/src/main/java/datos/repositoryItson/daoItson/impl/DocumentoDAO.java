package datos.repositoryItson.daoItson.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import datos.configMongoItson.MongoClienteProvider;
import datos.dominioItson.Documento;
import datos.excepciones.DaoException;
import datos.repositoryItson.daoItson.IDocumentoDAO;
import org.bson.types.ObjectId;

import java.util.Optional;

public class DocumentoDAO implements IDocumentoDAO {
    private final MongoCollection<Documento> col;

    public DocumentoDAO() {
        this.col = MongoClienteProvider.INSTANCE.getCollection("documentos",Documento.class);
    }

    @Override
    public Optional<Documento> findById(ObjectId _id) throws DaoException {
        try{
            return Optional.ofNullable(col.find(Filters.eq("_id",_id)).first());
        }catch (DaoException ex){
            throw new DaoException("Error al encontrar documento con el id: " + _id);
        }
    }
}
