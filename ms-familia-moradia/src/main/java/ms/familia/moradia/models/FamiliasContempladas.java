package ms.familia.moradia.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "familias_contempladas", 
	indexes = { @Index(name = "index_fc1", columnList = "id"), 
	@Index(name = "index_fc2", columnList = "pontos") })
public class FamiliasContempladas implements Serializable, Comparable<FamiliasContempladas>{
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "familia_id")
	private Long idFamilia;
	@Column(name = "criterioas_atendidos")
	private Integer criteriosAtendidos;
	private Integer pontos;
	@Temporal(TemporalType.DATE)
	private Date data;
	
	
	public Long getIdFamilia() {
		return idFamilia;
	}
	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}
	public Integer getCriteriosAtendidos() {
		return criteriosAtendidos;
	}
	public void setCriteriosAtendidos(Integer criteriosAtendidos) {
		this.criteriosAtendidos = criteriosAtendidos;
	}
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public int compareTo(FamiliasContempladas familias) {

		if (this.pontos > familias.getPontos()) {
	          return -1;
	     }
	     if (this.pontos < familias.getPontos()) {
	          return 1;
	     }
	     return 0;
    }
}