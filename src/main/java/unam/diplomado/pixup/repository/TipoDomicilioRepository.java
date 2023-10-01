package unam.diplomado.pixup.repository;

import unam.diplomado.pixup.domain.TipoDomicilio;

import java.util.List;
import java.util.Optional;

public interface TipoDomicilioRepository {

    // Optional es un valor que puede o no encontrar
    Optional<TipoDomicilio> findByDescripcion(String descripcion);
    Optional<TipoDomicilio> findById(Integer id);
    List<TipoDomicilio> findAll();
}
