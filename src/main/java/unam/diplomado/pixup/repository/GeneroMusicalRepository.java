package unam.diplomado.pixup.repository;

import unam.diplomado.pixup.domain.GeneroMusical;

import java.util.Optional;

public interface GeneroMusicalRepository {
    Optional<GeneroMusical> findById(Integer id);
}
