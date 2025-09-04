package miralhas.github.testejava.domain.repository;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import miralhas.github.testejava.domain.models.Documento;

@Repository
public interface DocumentoRepository extends CrudRepository<Documento, Long> {
}
