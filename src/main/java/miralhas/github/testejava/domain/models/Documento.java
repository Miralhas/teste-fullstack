package miralhas.github.testejava.domain.models;

import jakarta.persistence.*;
import lombok.*;
import miralhas.github.testejava.domain.models.enums.DocumentoTipo;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Documento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private DocumentoTipo tipo = DocumentoTipo.RG;

	@Column(nullable = false)
	private String numero;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	@ToString.Exclude
	private Pessoa pessoa;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Documento documento = (Documento) o;
		return getId() != null && Objects.equals(getId(), documento.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
