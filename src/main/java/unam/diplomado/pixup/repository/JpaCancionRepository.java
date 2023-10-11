package unam.diplomado.pixup.repository;

import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.domain.Cancion;
import jakarta.persistence.EntityManager;

public class JpaCancionRepository implements CancionRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Cancion save(Cancion cancion) {
        entityManager.persist(cancion);
        return cancion;
    }
}
