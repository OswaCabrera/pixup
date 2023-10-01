package unam.diplomado.pixup.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.domain.Domicilio;
import unam.diplomado.pixup.domain.Usuario;

@Local
public interface UsuarioService {
    Usuario registrarUsuario(Usuario usuario, Domicilio domicilio);
}
