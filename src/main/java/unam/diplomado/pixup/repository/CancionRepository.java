package unam.diplomado.pixup.repository;

import unam.diplomado.pixup.domain.Cancion;
import unam.diplomado.pixup.domain.Disco;
import unam.diplomado.pixup.domain.Usuario;

public interface CancionRepository {
    Cancion save(Cancion cancion);
}
