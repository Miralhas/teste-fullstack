package miralhas.github.testejava.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import miralhas.github.testejava.domain.models.Pessoa;
import miralhas.github.testejava.domain.repository.PessoaRepository;

import java.util.List;

@ApplicationScoped
public class PessoaService {

	@Inject
	private PessoaRepository pessoaRepository;

	public List<Pessoa> findAllPessoas() {
		return pessoaRepository.findAll();
	}

	@Transactional
	public void savePessoa(Pessoa p) {
		setRelationship(p);
		pessoaRepository.save(p);
	}

	@Transactional
	public void deletePessoa(Pessoa p) {
		pessoaRepository.delete(p);
	}

	private void setRelationship(Pessoa p) {
		p.getTelefones().forEach(t -> t.setPessoa(p));
		p.getDocumentos().forEach(d -> d.setPessoa(p));
		p.getEnderecos().forEach(e -> e.setPessoa(p));
	}
}
