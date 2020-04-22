package controle;

import java.io.IOException;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.ChefeDAOImpl;
import entidade.Chefe;

@ManagedBean (name="CadastroBean")
@SessionScoped

public class CadastroBean {
	private Chefe chefe;
	private ChefeDAOImpl chefDAO;
	
	
	private static final String LOGIN = "entrar.xhtml";
	
	public CadastroBean(){
		
		
		this.chefe = new Chefe();
		
	}
	
	public void cadastrar() throws IOException{
		if (this.chefDAO.inserirChefe(this.chefe)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Sucesso !!!"));
			abrirLogin();
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Erro ao cadastrar !!!"));
		}
		
	}
	
	public void abrirLogin() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect(LOGIN);
	}
	

	public Chefe getChefe() {
		return chefe;
	}

	public void setChefe(Chefe chefe) {
		this.chefe = chefe;
	}
	
}
