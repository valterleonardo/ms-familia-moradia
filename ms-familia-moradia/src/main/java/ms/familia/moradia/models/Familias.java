package ms.familia.moradia.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "familia", 
	indexes = { @Index(name = "index_familia1", columnList = "id"), 
	@Index(name = "index_familia2", columnList = "status") })
public class Familias implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private Integer status;
	
	@ManyToMany
    @JoinTable(
    		name="pessoa", 
    		joinColumns = @JoinColumn(name="familia_id"), 
    		inverseJoinColumns = @JoinColumn(name="id"))
	private List<Pessoas> pessoas;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Pessoas> getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(List<Pessoas> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}