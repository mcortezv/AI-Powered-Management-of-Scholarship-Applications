package datos.repositoryBanco.dao.interfaces;

import datos.dominioBanco.Cuenta;
import datos.repositoryBanco.documents.CuentaDocument;

public interface ICuentaDAO {
    Cuenta buscarPorNumeroTarjeta(String numeroTarjeta);
    boolean actualizarSaldo(String numeroTarjeta, double nuevoSaldo);
}