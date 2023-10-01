package unam.diplomado.pixup.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.domain.Disquera;
import unam.diplomado.pixup.repository.DisqueraRepository;

import java.util.Optional;

@Singleton
public class JpaDisqueraRepository implements DisqueraRepository {
   @PersistenceContext(unitName = "pixup")
   private EntityManager entityManager;

   @Override
   public Optional<Disquera> findById(Integer id) {
       Disquera disquera = entityManager.find(Disquera.class, id);
       return disquera != null ? Optional.of(disquera) : Optional.empty();
   }

}
