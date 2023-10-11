package unam.diplomado.pixup.service;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.pixup.domain.*;
import unam.diplomado.pixup.repository.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class DiscoServiceImpl implements DiscoService {

    @Inject
    private DisqueraRepository disqueraRepository;

    @Inject
    private ArtistaRepository artistaRepository;

    @Inject
    private GeneroMusicalRepository generoMusicalRepository;

    @Inject
    private DiscoRepository discoRepository;

    @Inject
    private CancionRepository cancionRepository;

    @Override
    @Transactional(value=Transactional.TxType.REQUIRED)
    public Disco registrarDisco(Disco disco) {

        // validacion artista
        if (disco.getArtista() == null || disco.getArtista().getId() == null) {
            throw new ArtistaRequiredException();
        }else {
            Optional<Artista> artista = artistaRepository.findById(disco.getArtista().getId());
            if (artista.isEmpty()) {
                throw new ArtistaNotFoundException(artista.get().getId());
            }
            disco.setArtista(artista.get());
        }

        // validacion disco duplicado
        Optional<Disco> discoExistente =
                discoRepository.findByTituloAndArtista(disco.getTitulo(), disco.getArtista().getId());
        if (discoExistente.isPresent()) {
            throw new DiscoExistsException(disco.getTitulo(), disco.getArtista().getNombre());
        }

        // validacion generoMusical
        if (disco.getGeneroMusical() == null ||
                disco.getGeneroMusical().getId() == null) {
            throw new GeneroMusicalRequiredException();
        }else {
            Optional<GeneroMusical> generoMusical = generoMusicalRepository.findById(disco.getGeneroMusical().getId());
            if (generoMusical.isEmpty()) {
                throw new GeneroMusicalNotFoundException(generoMusical.get().getId());
            }
            disco.setGeneroMusical(generoMusical.get());
        }

        // validacion disquera
        if (disco.getDisquera() == null ||
                disco.getDisquera().getId() == null) {
            throw new DisqueraRequiredException();
        }else {
            Optional<Disquera> disquera = disqueraRepository.findById(disco.getDisquera().getId());
            if (disquera.isEmpty()) {
                throw new DisqueraNotFoundException();
            }
            disco.setDisquera(disquera.get());
        }


        discoRepository.save(disco);

        return disco;
    }
}
