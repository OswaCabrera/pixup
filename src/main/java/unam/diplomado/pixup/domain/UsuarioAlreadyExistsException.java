package unam.diplomado.pixup.domain;

public class UsuarioAlreadyExistsException extends RuntimeException  {

    public UsuarioAlreadyExistsException(String email) {
        super("Ya existe un usuario con el correo " + email + ".");
    }
}
