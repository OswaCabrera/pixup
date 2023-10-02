package unam.diplomado.pixup.domain;

public class ArtistaNotFoundException extends RuntimeException{

            public ArtistaNotFoundException(Integer id) {
                super("No se encontró el artista con el id " + id + "." );
            }
}
