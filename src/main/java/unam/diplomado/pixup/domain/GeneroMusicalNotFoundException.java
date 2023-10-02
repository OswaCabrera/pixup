package unam.diplomado.pixup.domain;

public class GeneroMusicalNotFoundException extends RuntimeException{

                    public GeneroMusicalNotFoundException(Integer id) {
                        super("El género musical conn id: " + id + " no existe");
                    }
}
