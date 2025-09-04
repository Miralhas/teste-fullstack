package miralhas.github.testejava.domain.repository;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import miralhas.github.testejava.domain.models.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
}
