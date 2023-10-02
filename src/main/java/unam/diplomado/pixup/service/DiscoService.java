package unam.diplomado.pixup.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.domain.Disco;

@Local
public interface DiscoService {
    Disco registrarDisco(Disco disco);
}
