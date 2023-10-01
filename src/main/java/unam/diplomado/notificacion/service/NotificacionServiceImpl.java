package unam.diplomado.notificacion.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.notificacion.domain.Notificacion;
import unam.diplomado.notificacion.domain.TipoNotificacion;
import unam.diplomado.notificacion.domain.TipoNotificacionNotFoundException;
import unam.diplomado.notificacion.repository.NotificacionRepository;
import unam.diplomado.notificacion.repository.TipoNotificacionRepository;
import unam.diplomado.pixup.domain.Usuario;

import java.util.Optional;

@Stateless
public class NotificacionServiceImpl implements NotificacionService {

    @Inject
    private TipoNotificacionRepository tipoNotificacionRepository;
    @Inject
    private NotificacionRepository notificacionRepository;

    @Override
    @Transactional(value=Transactional.TxType.REQUIRED)
    public Notificacion enviarNotificacionAltaUsuario(Usuario usuario) {
        String descTipoNotificacion = "ALTA_USUARIO";
        Optional<TipoNotificacion> tipoNotificacion =
                tipoNotificacionRepository.findByDescripcion(descTipoNotificacion);
        if (tipoNotificacion.isEmpty()) {
            throw new TipoNotificacionNotFoundException(descTipoNotificacion);
        }
        Notificacion notificacion = new Notificacion();
        notificacion.setUsuario(usuario);
        notificacion.setTipoNotificacion(tipoNotificacion.get());
        notificacionRepository.save(notificacion);
        return notificacion;
    }

}
