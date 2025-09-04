package miralhas.github.testejava.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pessoa {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false, name = "data_nascimento")
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	private List<Endereco> enderecos = new ArrayList<>();

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	private List<Telefone> telefones = new ArrayList<>();

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	private List<Documento> documentos = new ArrayList<>();


	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Pessoa pessoa = (Pessoa) o;
		return getId() != null && Objects.equals(getId(), pessoa.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
