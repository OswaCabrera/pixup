package unam.diplomado.pixup.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.domain.Domicilio;
import unam.diplomado.pixup.repository.DomicilioRepository;

@Singleton
public class JPADomicilioRepository implements DomicilioRepository {

    @PersistenceContext(unitName = "pixup")
    EntityManager entityManager;

    @Override
    public Domicilio save(Domicilio domicilio) {
        entityManager.persist(domicilio);
        return domicilio;
    }
}
