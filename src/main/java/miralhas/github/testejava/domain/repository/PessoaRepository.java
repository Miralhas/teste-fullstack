package miralhas.github.testejava.domain.repository;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import miralhas.github.testejava.domain.models.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
