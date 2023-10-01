package unam.diplomado.pixup.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import unam.diplomado.pixup.domain.Disco;
import unam.diplomado.pixup.domain.DiscoExistsException;
import unam.diplomado.pixup.domain.TipoDomicilio;
import unam.diplomado.pixup.repository.DiscoRepository;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaDiscoRepository implements DiscoRepository {
    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Disco save(Disco disco) {
        Optional<Disco> discos = findByTituloAndArtista(disco.getTitulo(), disco.getArtista().getId());
        if(discos.isPresent()) {
            throw new DiscoExistsException();
        } else {
            entityManager.persist(disco);
        }
        return disco;
    }

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista) {
        Query query = entityManager.createQuery(
                "SELECT d FROM Disco d WHERE d.titulo = :titulo and d.id_artista = :artista"
        );
        query.setParameter("titulo", titulo);
        query.setParameter("id_artista", idArtista);
        List<Disco> disco = (List<Disco>)query.getResultList();
        return !disco.isEmpty()  ? Optional.of(disco.get(0)) : Optional.empty();
    }
}
