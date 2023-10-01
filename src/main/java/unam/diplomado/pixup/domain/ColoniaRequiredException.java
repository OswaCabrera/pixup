package unam.diplomado.pixup.domain;

public class ColoniaRequiredException extends RuntimeException{

        public ColoniaRequiredException() {
            super("La colonia es requerida.");
        }
}
