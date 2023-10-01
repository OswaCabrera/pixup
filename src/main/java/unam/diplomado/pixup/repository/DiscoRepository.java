package unam.diplomado.pixup.repository;

import unam.diplomado.pixup.domain.Disco;

import java.util.Optional;

public interface DiscoRepository {
    Disco save(Disco disco);
    Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista);
}
