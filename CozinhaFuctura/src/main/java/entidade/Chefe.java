package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name= "CHEFE")
public class Chefe {
	
	@Column (name="nome", nullable = false)
	private String nome;
	
	@Id
	@Column (name="login")
	private String Login;
	
	@Column (name="senha", nullable = false)
	private String senha;
	
	@Column (name="pais", nullable = false)
	private String pais;
	
	@Column (name="especialidade")
	private String especialidade;
	
	@OneToMany (mappedBy = "chefe", cascade = CascadeType.ALL)
	private List<Receitas>receitas;
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public List<Receitas> getReceitas() {
		return receitas;
	}
	public void setReceitas(List<Receitas> receitas) {
		this.receitas = receitas;
	}
	
	
	

}
