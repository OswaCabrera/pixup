package unam.diplomado.pixup.domain;

public class ColoniaNotFoundException extends RuntimeException{

        public ColoniaNotFoundException(Integer id) {
            super("No se encontró la colonia con el id " + id + "." );
        }
}
