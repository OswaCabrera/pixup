package unam.diplomado.pixup.domain;

public class TipoDomicilioRequiredException extends RuntimeException    {

        public TipoDomicilioRequiredException() {
            super("Es requerido un tipo de domicilio.");
        }
}
