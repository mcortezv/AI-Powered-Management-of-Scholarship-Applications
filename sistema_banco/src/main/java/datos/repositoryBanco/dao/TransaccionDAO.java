package datos.repositoryBanco.dao;

import com.mongodb.client.MongoCollection;
import datos.configMongoBanco.MongoClienteProvider;
import datos.dominioBanco.Transaccion;
import datos.repositoryBanco.dao.interfaces.ITransaccionDAO;

public class TransaccionDAO implements ITransaccionDAO {

    private final MongoCollection<Transaccion> col;

    public TransaccionDAO() {
        col = MongoClienteProvider.INSTANCE.getCollection("transacciones", Transaccion.class);
    }

    @Override
    public void guardarTransaccion(Transaccion transaccion) {
        try {
            col.insertOne(transaccion);
        } catch (Exception e) {
            System.err.println("Error al guardar transacción: " + e.getMessage());
        }
    }
}