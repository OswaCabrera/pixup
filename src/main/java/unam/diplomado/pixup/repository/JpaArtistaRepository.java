package unam.diplomado.pixup.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import unam.diplomado.pixup.domain.Artista;
import unam.diplomado.pixup.domain.TipoDomicilio;
import unam.diplomado.pixup.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaArtistaRepository implements ArtistaRepository {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Artista> findById(Integer id) {
        Artista artista = entityManager.find(Artista.class, id);
        return artista != null ? Optional.of(artista) : Optional.empty();
    }
}
