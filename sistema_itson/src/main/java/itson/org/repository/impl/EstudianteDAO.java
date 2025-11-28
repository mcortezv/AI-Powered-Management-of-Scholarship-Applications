package itson.org.repository.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import itson.org.config.MongoClienteProvider;
import itson.org.domain.Estudiante;
import itson.org.exception.DaoException;
import itson.org.repository.IEstudianteDAO;

import java.util.Optional;

public class EstudianteDAO implements IEstudianteDAO {

    private final MongoCollection<Estudiante> col;

    public EstudianteDAO() {
        this.col = MongoClienteProvider.INSTANCE.getCollection("estudiantes", Estudiante.class);
    }

    @Override
    public Optional<Estudiante> findByMatricula(Long matricula) {
        try {
            System.out.println(matricula);
            Estudiante est = col.find(Filters.eq("matricula", matricula)).first();
            return Optional.ofNullable(est);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Error al buscar estudiante con matrícula: " + matricula);
        }
    }
}
