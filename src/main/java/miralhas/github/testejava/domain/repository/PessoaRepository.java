package miralhas.github.testejava.domain.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import miralhas.github.testejava.domain.models.Pessoa;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class PessoaRepository implements CrudRepository<Pessoa, Long> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Pessoa> findAll() {
		return em.createQuery("SELECT p from Pessoa p", Pessoa.class).getResultList();
	}

	@Override
	public Optional<Pessoa> findById() {
		return Optional.empty();
	}

	@Override
	public void save(Pessoa p) {
		if (Objects.isNull(p.getId())) {
			em.persist(p);
			return;
		}
		em.merge(p);
	}

	@Override
	public void delete(Pessoa pessoa) {
		em.remove(em.contains(pessoa) ? pessoa : em.merge(pessoa));
	}
}
