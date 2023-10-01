package unam.diplomado.pixup.repository;

import unam.diplomado.pixup.domain.Artista;

import java.util.Optional;

public interface ArtistaRepository {
    Optional<Artista> findById(Integer id);
}
