package unam.diplomado.pixup.repository;


import unam.diplomado.pixup.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findByEmail(String email);
    Usuario save(Usuario usuario);
}
