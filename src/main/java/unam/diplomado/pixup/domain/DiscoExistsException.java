package unam.diplomado.pixup.domain;

public class DiscoExistsException extends RuntimeException{

            public DiscoExistsException() {
                super("El disco ya existe.");
            }
}
