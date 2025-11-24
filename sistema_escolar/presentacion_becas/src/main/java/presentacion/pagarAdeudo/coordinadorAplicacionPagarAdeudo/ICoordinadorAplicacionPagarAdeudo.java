package presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo;

public interface ICoordinadorAplicacionPagarAdeudo {
    void seleccionarAdeudoBiblioteca();
    void seleccionarAdeudoColegiatura();
    void verDetalle();
    void seleccionarRealizarPago();
    void seleccionarMetodoPago(String metodoPago) throws Exception;

}
