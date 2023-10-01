package unam.diplomado.notificacion.service;

import jakarta.ejb.Local;
import unam.diplomado.notificacion.domain.Notificacion;
import unam.diplomado.pixup.domain.Usuario;

@Local
public interface NotificacionService {

    Notificacion enviarNotificacionAltaUsuario(Usuario usuario);

}
