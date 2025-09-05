package miralhas.github.testejava.domain.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
	List<T> findAll();
	Optional<T> findById();
	void save(T t);
	void delete(T t);
}
