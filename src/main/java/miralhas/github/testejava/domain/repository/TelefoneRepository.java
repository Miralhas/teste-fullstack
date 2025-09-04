package miralhas.github.testejava.domain.repository;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import miralhas.github.testejava.domain.models.Telefone;

@Repository
public interface TelefoneRepository extends CrudRepository<Telefone, Long> {
}
