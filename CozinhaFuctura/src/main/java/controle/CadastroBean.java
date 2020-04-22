package controle;

import java.io.IOException;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.ChefeDAOImpl;
import entidade.Chefe;
import util.JpaUtil;

@ManagedBean (name="CadastroBean")
@SessionScoped

public class CadastroBean {
	private Chefe chefe;
	private ChefeDAOImpl chefDAO;
	
	
	private static final String LOGIN = "cadastro.xhtml";
	
	public CadastroBean(){
		
		
		this.chefe = new Chefe();
		this.chefDAO = new ChefeDAOImpl(JpaUtil.getEntityManager());
	}
	
	public void cadastrar() throws IOException{
		if (this.chefDAO.inserir(this.chefe)) {
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
	
}
