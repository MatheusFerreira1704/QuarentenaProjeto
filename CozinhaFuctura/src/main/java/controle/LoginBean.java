package controle;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.ChefeDAO;
import dao.ChefeDAOImpl;
import entidade.Chefe;
import util.JpaUtil;

@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	
	private String login;
	private String senha;

	Chefe chefeL;
	ChefeDAO chefeDAO;

	private static final String CADASTRAR = "paginas/move/cadastro.xhtml";
	private String mensagem;

	public LoginBean() {
		this.chefeDAO = new ChefeDAOImpl();
		this.chefeL = new Chefe();
	}

	public void logar() throws IOException {
		
		if(this.login.equals(this.chefeL.getLogin()) 
		&&	this.senha.equals(this.chefeL.getSenha())) {
			
		}else {
			this.mensagem = "Por favor, verifique seus dados.";
			}
	}
	
	public void telCad() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect(CADASTRAR);
	}
	
	public void abrirCadastro() throws IOException{
		telCad();
	}
	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


}
