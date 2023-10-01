package unam.diplomado.pixup.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import unam.diplomado.pixup.domain.TipoDomicilio;
import unam.diplomado.pixup.repository.TipoDomicilioRepository;

import java.util.List;
import java.util.Optional;


@Singleton
public class JpaTipoDomicilioRepository implements TipoDomicilioRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<TipoDomicilio> findByDescripcion(String descripcion) {
        Query query = entityManager.createQuery(
                "SELECT td FROM TipoDomicilio td WHERE td.descripcion = :descripcion"
        );
        query.setParameter("descripcion", descripcion);
        List<TipoDomicilio> tiposDomicilio = (List<TipoDomicilio>)query.getResultList();
        return !tiposDomicilio.isEmpty() ? Optional.of(tiposDomicilio.get(0)) : Optional.empty();
    }

    @Override
    public Optional<TipoDomicilio> findById(Integer id) {
        TipoDomicilio tipoDomicilio = entityManager.find(TipoDomicilio.class, id);
        return tipoDomicilio != null ? Optional.of(tipoDomicilio) : Optional.empty();
    }

    @Override
    public List<TipoDomicilio> findAll() {
       Query query = entityManager.createQuery(
               "SELECT td FROM TipoDomicilio td"
       );
       return (List<TipoDomicilio>) query.getResultList();
    }
}
