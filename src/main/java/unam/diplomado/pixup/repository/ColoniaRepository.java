package unam.diplomado.pixup.repository;

import unam.diplomado.pixup.domain.Colonia;

import java.util.Collection;
import java.util.Optional;

public interface ColoniaRepository {
    Collection<Colonia> findbyCp(String cp);
    //Puede encontrar o no una colonia
    Optional<Colonia> findById(Integer id);
}
