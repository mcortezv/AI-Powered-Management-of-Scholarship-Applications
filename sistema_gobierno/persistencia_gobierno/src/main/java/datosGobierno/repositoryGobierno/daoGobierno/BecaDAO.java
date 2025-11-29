/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosGobierno.repositoryGobierno.daoGobierno;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import datosGobierno.configMongoGobierno.MongoClienteProvider;
import datosGobierno.repositoryGobierno.daoGobierno.excepcionesGobierno.BecaDAOException;
import datosGobierno.repositoryGobierno.daoGobierno.interfacesGobierno.IBecaDAO;
import java.util.ArrayList;
import java.util.List;
import datosGobierno.repositoryGobierno.documents.BecaDocument;
import gobierno.RequisitosDTOGobierno;
import org.bson.conversions.Bson;
import solicitarBeca.dominio.BecasFiltradas;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class BecaDAO implements IBecaDAO{
    private final MongoCollection<BecaDocument> col;
    
    public BecaDAO(){
        this.col = MongoClienteProvider.INSTANCE.getCollection("becas", BecaDocument.class);
    }

    @Override
    public List<BecaDocument> findByRequisitos(RequisitosDTOGobierno r){
        try{
            BecasFiltradas bf = new BecasFiltradas();
            List<BecaDocument> resultado = new ArrayList<>();
            Bson filtro = Filters.and(
                    Filters.lte("requisitos.promedioMinimo", r.getPromedioMinimo()),
                    Filters.gte("requisitos.ingresoFamiliarMaximo", r.getIngresoFamiliarMaximo()),
                    Filters.lte("requisitos.cargaAcademica", r.getCargaAcademica()),
                    Filters.eq("requisitos.trabajo", r.isTrabajo()),
                    Filters.eq("requisitos.deudas", r.isDeudas())
            );
            col.find(filtro).into(resultado);
            return resultado;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new BecaDAOException("Error al buscar becas con los requisitos proporcionados.");
        }
    }
}
