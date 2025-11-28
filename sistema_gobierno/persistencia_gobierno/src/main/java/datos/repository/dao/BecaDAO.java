/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.repository.dao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import datos.config.MongoClienteProvider;
import datos.repository.dao.excepciones.BecaDAOException;
import datos.repository.dao.interfaces.IBecaDAO;
import java.util.ArrayList;
import java.util.List;
import gobierno.RequisitosDTOGobierno;
import org.bson.conversions.Bson;
import solicitarBeca.dominio.Beca;
import solicitarBeca.dominio.BecasFiltradas;


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
    public BecasFiltradas findByRequisitos(RequisitosDTOGobierno r){
        try{
            BecasFiltradas bf = new BecasFiltradas();
            List<Beca> resultado = new ArrayList<>();
            Bson filtro = Filters.and(
                    Filters.lte("requisitos.promedio_minimo", r.getPromedioMinimo()),
                    Filters.gte("requisitos.ingreso_familiar_max", r.getIngresoFamiliarMaximo()),
                    Filters.eq("requisitos.trabajo_requerido", r.isTrabajo())
            );
            col.find(filtro).into(resultado);
            bf.setBecas(resultado);
            return bf;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new BecaDAOException("Error al buscar becas con los requisitos proporcionado.s");
        }
    }
}
