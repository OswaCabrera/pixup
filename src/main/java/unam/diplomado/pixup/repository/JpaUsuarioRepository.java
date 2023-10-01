package unam.diplomado.pixup.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import unam.diplomado.pixup.domain.Usuario;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaUsuarioRepository implements UsuarioRepository {

    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Usuario> findByEmail(String email) {
        Query query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.email = :email");
        query.setParameter("email", email);
        List<Usuario> usuarios = (List<Usuario>)query.getResultList();
        return !usuarios.isEmpty() ? Optional.of(usuarios.get(0)) : Optional.empty();
    }

    @Override
    public Usuario save(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

}
