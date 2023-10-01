package unam.diplomado.pixup.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import unam.diplomado.pixup.domain.Colonia;
import unam.diplomado.pixup.repository.ColoniaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

// metadato que contiene el contenedor para instanciar una clase
@Singleton
public class JPAColoniaRepository implements ColoniaRepository {
    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Collection<Colonia> findbyCp(String cp) {
        Query query = entityManager.createQuery(
                "SELECT c FROM Colonia c WHERE c.cp = :cp");
        query.setParameter("cp", cp);
        return (List<Colonia>)query.getResultList();
    }

    @Override
    public Optional<Colonia> findById(Integer id) {
        Colonia colonia = entityManager.find(Colonia.class, id);
        return colonia != null ? Optional.of(colonia) : Optional.empty();
    }

}
