package unam.diplomado.notificacion.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import unam.diplomado.notificacion.domain.TipoNotificacion;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaTipoNotificacionRepository implements TipoNotificacionRepository {

    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override
    public Optional<TipoNotificacion> findByDescripcion(String descripcion) {
        Query query = entityManager.createQuery(
                "SELECT tn FROM TipoNotificacion tn WHERE tn.descripcion = :descripcion");
        query.setParameter("descripcion", descripcion);
        List<TipoNotificacion> tiposNotificacion = (List<TipoNotificacion>)query.getResultList();
        return !tiposNotificacion.isEmpty() ? Optional.of(tiposNotificacion.get(0)) : Optional.empty();
    }

}
