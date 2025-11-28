/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import datos.config.MongoClienteProvider;
import datos.dao.excepciones.BecaDAOException;
import datos.dao.interfaces.IBecaDAO;
import datos.dominio.Beca;
import datos.dto.RequisitosDTOI;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;


/**
 *
 * @author janethcristinagalvanquinonez
 */
public class BecaDAO implements IBecaDAO{
    private final MongoCollection<Beca> col;
    
    public BecaDAO(){
        this.col = MongoClienteProvider.INSTANCE.getCollection("becas", Beca.class);
    }
    
    @Override
    public List<Beca> findByRequisitos(RequisitosDTOI r){
        try{
            List<Beca> resultado = new ArrayList<>();
            
            Bson filtro = Filters.and(
                    Filters.lte("requisitos.promedio_minimo", r.getPromedioMinimo()),
                    Filters.gte("requisitos.ingreso_familiar_max", r.getIngresoFamiliarMaximo()),
                    Filters.eq("requisitos.trabajo_requerido", r.isTrabajo())
            );
            col.find(filtro).into(resultado);
            return resultado;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new BecaDAOException("Error al buscar becas con los requisitos proporcionado.s");
        }
    }
}
