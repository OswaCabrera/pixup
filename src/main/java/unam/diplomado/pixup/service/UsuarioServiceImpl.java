package unam.diplomado.pixup.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.notificacion.service.NotificacionService;
import unam.diplomado.pixup.domain.*;
import unam.diplomado.pixup.repository.*;

import java.util.Optional;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;
    @Inject
    private DomicilioRepository domicilioRepository;
    @Inject
    private ColoniaRepository coloniaRepository;
    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;
    @Inject
    private NotificacionService notificacionService;

    @Override
    @Transactional(value=Transactional.TxType.REQUIRED)
    public Usuario registrarUsuario(Usuario usuario, Domicilio domicilio) {
        // validacion usuario duplicado
        Optional<Usuario> usuarioExistente =
                usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new UsuarioAlreadyExistsException(usuario.getEmail());
        }

        // validacion colonia
        if (domicilio.getColonia() == null ||
                domicilio.getColonia().getId() == null) {
            throw new ColoniaRequiredException();
        } else {
            Optional<Colonia> colonia = coloniaRepository.findById(domicilio.getColonia().getId());
            if (colonia.isEmpty()) {
                throw new ColoniaNotFoundException(domicilio.getColonia().getId());
            }
            domicilio.setColonia(colonia.get());
        }

        // validacion tipoDomicilio
        if (domicilio.getTipoDomicilio() == null ||
                domicilio.getTipoDomicilio().getId() == null) {
            throw new TipoDomicilioRequiredException();
        } else {
            Optional<TipoDomicilio> tipoDomicilio =
                    tipoDomicilioRepository.findById(domicilio.getTipoDomicilio().getId());
            if (tipoDomicilio.isEmpty()) {
                throw new TipoDomicilioNotFoundException(domicilio.getTipoDomicilio().getId());
            }
            domicilio.setTipoDomicilio(tipoDomicilio.get());
        }

        // persistencia entidades
        usuarioRepository.save(usuario);
        domicilio.setUsuario(usuario);
        domicilioRepository.save(domicilio);

        // enviando notificacion
        notificacionService.enviarNotificacionAltaUsuario(usuario);

        return usuario;
    }

}
