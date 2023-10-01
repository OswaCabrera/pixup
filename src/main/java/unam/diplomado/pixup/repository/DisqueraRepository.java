package unam.diplomado.pixup.repository;

import unam.diplomado.pixup.domain.Disquera;

import java.util.Optional;

public interface DisqueraRepository {
    Optional<Disquera> findById(Integer id);
}
