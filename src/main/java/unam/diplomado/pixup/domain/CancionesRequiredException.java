package unam.diplomado.pixup.domain;

public class CancionesRequiredException extends RuntimeException{
    public CancionesRequiredException() {
        super("Las canciones son requeridas");
    }
}
