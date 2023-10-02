package unam.diplomado.pixup.domain;

public class GeneroMusicalRequiredException extends RuntimeException{

                public GeneroMusicalRequiredException() {
                    super("El género musical es requerido");
                }
}
