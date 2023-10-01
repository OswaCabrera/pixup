package unam.diplomado.pixup.api;

import jakarta.inject.Inject;
import unam.diplomado.pixup.domain.TipoDomicilio;
import unam.diplomado.pixup.repository.TipoDomicilioRepository;

import java.util.Collection;

public class TipoDomicilioResource implements TipoDomicilioApi {

    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;

    @Override
    public Collection<TipoDomicilio> getAll() {
        return tipoDomicilioRepository.findAll();
    }
}
