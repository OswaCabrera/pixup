package unam.diplomado.pixup.domain;

public class TipoDomicilioNotFoundException extends RuntimeException{

        public TipoDomicilioNotFoundException(Integer id) {
            super("No se encontró el tipo de domicilio con el id " + id + "." );
        }
}
