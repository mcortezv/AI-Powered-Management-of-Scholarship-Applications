package presentacion.validadores;

public class ValidarContexto {
    public IValidador estrategia;

    public ValidarContexto(){}

    public void setEstrategia(IValidador iValidador){
        this.estrategia = iValidador;
    }

    public boolean validarDato(String dato) {
        if(this.estrategia == null){
            throw new IllegalStateException("La estrategia de validacion no se ha establecido");
        }
        return this.estrategia.validarDato(dato);
    }
}