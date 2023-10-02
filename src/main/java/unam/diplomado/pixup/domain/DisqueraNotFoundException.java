package unam.diplomado.pixup.domain;

public class DisqueraNotFoundException extends RuntimeException{

        public DisqueraNotFoundException() {
            super("La disquera no existe");
        }
}
