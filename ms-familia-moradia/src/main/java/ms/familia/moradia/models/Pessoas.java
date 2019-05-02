package ms.familia.moradia.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ms.familia.moradia.dict.TipoPessoas;


@Entity
@Table(name = "pessoa", 
	indexes = { @Index(name = "index_pessoa1", columnList = "id"), 
	@Index(name = "index_pessoa2", columnList = "familia_id") })
public class Pessoas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Enumerated
	@Column(name = "tipo")
	private TipoPessoas tipoPessoas;
	
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name = "familia_id")
	private Long idFamilia;
		
	@ManyToMany
    @JoinTable(
    		name="renda", 
    		joinColumns = @JoinColumn(name="pessoa_id"), 
    		inverseJoinColumns = @JoinColumn(name="id"))
	private List<Rendas> rendas;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public TipoPessoas getTipoPessoas() {
		return tipoPessoas;
	}
	public void setTipoPessoas(TipoPessoas tipoPessoas) {
		this.tipoPessoas = tipoPessoas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdFamilia() {
		return idFamilia;
	}
	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}
	public List<Rendas> getRendas() {
		return rendas;
	}
	public void setRendas(List<Rendas> rendas) {
		this.rendas = rendas;
	}
}