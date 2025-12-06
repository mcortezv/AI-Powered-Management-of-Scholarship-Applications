package datos.repositoryBanco.dao.interfaces;

import datos.dominioBanco.Transaccion;
import datos.repositoryBanco.documents.TransaccionDocument;

public interface ITransaccionDAO {
    void guardarTransaccion(Transaccion transaccion);
}