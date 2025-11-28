package presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo;

import dto_gobierno.EstudianteDTO;

public interface ICoordinadorAplicacionPagarAdeudo {
    void seleccionarAdeudoBiblioteca(EstudianteDTO estudianteDTO);
    void seleccionarAdeudoColegiatura(EstudianteDTO estudianteDTO);
    void verDetalle();
    void seleccionarRealizarPago();
    void seleccionarMetodoPago(String metodoPago) throws Exception;

}
