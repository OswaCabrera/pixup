package unam.diplomado.pixup.domain;

public class ArtistaRequiredException extends RuntimeException{

            public ArtistaRequiredException() {
                super("El artista es requerido");
            }
}
