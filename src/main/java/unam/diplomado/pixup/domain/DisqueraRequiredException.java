package unam.diplomado.pixup.domain;

public class DisqueraRequiredException extends RuntimeException {

        public DisqueraRequiredException() {
            super("La disquera es requerida");
        }
}
