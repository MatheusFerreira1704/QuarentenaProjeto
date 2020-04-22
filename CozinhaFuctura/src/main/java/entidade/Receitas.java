package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "RECEITAS")
public class Receitas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receitas_sequence")
	@SequenceGenerator(name="receitas_sequence", sequenceName = "SEQ_RECEITA", initialValue = 1, allocationSize = 1)
	@Column (name="ID")
	private int id;
	
	@Column (name="nome", nullable = false)
	private String nome;
	
	@Column (name="ingrediente")
	private String ingrediente;
	
	@Column (name="quantidade")
	private int quantidade;
	
	@ManyToOne
	@JoinColumn (name="chefe_id", referencedColumnName = "login", nullable = false)
	private Chefe chefe;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Chefe getChefe() {
		return chefe;
	}
	public void setChefe(Chefe chefe) {
		this.chefe = chefe;
	}
	
	
	
	
	

}
