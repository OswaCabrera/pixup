package unam.diplomado.pixup.domain;

public class DiscoExistsException extends RuntimeException{

            public DiscoExistsException(String titulo, String artista) {

                super("El disco " + titulo + " del artista " + artista + " ya existe");
            }
}
