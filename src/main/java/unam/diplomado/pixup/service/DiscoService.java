package unam.diplomado.pixup.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.domain.Cancion;
import unam.diplomado.pixup.domain.Disco;

import java.util.List;

@Local
public interface DiscoService {
    Disco registrarDisco(Disco disco);
}
