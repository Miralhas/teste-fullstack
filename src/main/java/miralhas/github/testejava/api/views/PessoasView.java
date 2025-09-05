package miralhas.github.testejava.api.views;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import miralhas.github.testejava.domain.models.Documento;
import miralhas.github.testejava.domain.models.Endereco;
import miralhas.github.testejava.domain.models.Pessoa;
import miralhas.github.testejava.domain.models.Telefone;
import miralhas.github.testejava.domain.service.PessoaService;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ViewScoped
@Named("pessoasView")
public class PessoasView implements Serializable {

	@Inject
	private PessoaService pessoaService;

	private Pessoa pessoa;

	private List<Telefone> telefonesInput = new ArrayList<>();

	private List<Documento> documentosInput = new ArrayList<>();

	private List<Endereco> enderecosInput = new ArrayList<>();

	public void novaPessoa() {
		this.pessoa = new Pessoa();
		telefonesInput = new ArrayList<>();
		documentosInput = new ArrayList<>();
		enderecosInput = new ArrayList<>();
		addTelefone();
		addDocumento();
		addEndereco();
	}

	public void addEndereco() {
		enderecosInput.add(new Endereco());
	}

	public void addDocumento() {
		documentosInput.add(new Documento());
	}

	public void editPessoa(Pessoa p) {
		this.pessoa = p;
		populateTelefones();
		populateDocumentos();
		populateEnderecos();
	}

	public void deletePessoa(Pessoa pessoa) {
		pessoaService.deletePessoa(pessoa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa Apagada"));

	}

	private void populateEnderecos() {
		enderecosInput = new ArrayList<>();
		if (!pessoa.getEnderecos().isEmpty()) {
			enderecosInput.addAll(pessoa.getEnderecos());
		}
	}

	private void populateDocumentos() {
		documentosInput = new ArrayList<>();
		if (!pessoa.getDocumentos().isEmpty()) {
			documentosInput.addAll(pessoa.getDocumentos());
		}
	}

	private void populateTelefones() {
		telefonesInput = new ArrayList<>();
		if (!pessoa.getTelefones().isEmpty()) {
			telefonesInput.addAll(pessoa.getTelefones());
		}
	}

	public void addTelefone() {
		telefonesInput.add(new Telefone());
	}


	public void removeTelefoneInput() {
		if (telefonesInput.isEmpty()) return;
		telefonesInput.remove(telefonesInput.size() - 1);
	}

	public void removeDocumentoInput() {
		if (documentosInput.isEmpty()) return;
		documentosInput.remove(documentosInput.size()-1);
	}

	public void removeEnderecoInput() {
		if (enderecosInput.isEmpty()) return;
		enderecosInput.remove(enderecosInput.size()-1);
	}

	public void submit() {
		pessoa.setEnderecos(enderecosInput);
		pessoa.setDocumentos(documentosInput);
		pessoa.setTelefones(telefonesInput);

		if (Objects.isNull(pessoa.getId())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa Adicionada"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pessoa Atualizada"));
		}

		pessoaService.savePessoa(this.pessoa);

		PrimeFaces.current().executeScript("PF('pessoaDialogWidgetVar').hide()");
		PrimeFaces.current().ajax().update("tabela");
	}

}
