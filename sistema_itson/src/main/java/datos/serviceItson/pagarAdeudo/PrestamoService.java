package datos.serviceItson.pagarAdeudo;

import datos.repositoryItson.daoItson.pagarAdeudo.impl.PrestamoDAO;

public class PrestamoService {
    private final PrestamoDAO prestamoDAO;

    public PrestamoService(){
        this.prestamoDAO = new PrestamoDAO();
    }


}
