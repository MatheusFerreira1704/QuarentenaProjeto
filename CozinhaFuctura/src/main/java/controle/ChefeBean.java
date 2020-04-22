package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import dao.ChefeDAO;
import dao.ChefeDAOImpl;
import entidade.Chefe;
import entidade.Receitas;
import util.JpaUtil;

public class ChefeBean {

	private ChefeDAO chefDAO;
	
	private Chefe chefe;
	private Receitas receitas;
	private List<Chefe>listarechef;
	private String nomeSelecionado;
	
	public ChefeBean() {
		
		this.chefe = new Chefe();
		this.chefe.setReceitas(new ArrayList<Receitas>());
		
		this.receitas = new Receitas();
		this.listarechef = new ArrayList<Chefe>();
		
		
		this.chefDAO = new ChefeDAOImpl();
		
		this.listarechef = this.chefDAO.listarChefes();	
	}
	
	
	public void Cadastrar() throws IOException{
		if (this.chefDAO.inserirChefe(this.chefe)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Sucesso !!!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Erro ao cadastrar !!!"));
		}
		
	}
	
	public void addReceita() {
	
		Receitas novaReceita = new Receitas();
		novaReceita.setNome(this.receitas.getNome());
		novaReceita.setIngrediente(this.receitas.getIngrediente());
		novaReceita.setQuantidade(this.receitas.getQuantidade());
		novaReceita.setChefe(this.chefe);
		
		this.chefe.getReceitas().add(novaReceita);
		this.receitas = new Receitas();
	}
	
	public void editChefe() {
		
		Chefe editReceita = this.chefDAO.pesquisar(nomeSelecionado);
	}
	
	
	
	

	
	
	
	
	

	

	public Chefe getChefe() {
		return chefe;
	}

	public void setChefe(Chefe chefe) {
		this.chefe = chefe;
	}

	public Receitas getReceitas() {
		return receitas;
	}

	public void setReceitas(Receitas receitas) {
		this.receitas = receitas;
	}

	
	public String getNomeSelecionado() {
		return nomeSelecionado;
	}

	public void setNomeSelecionado(String nomeSelecionado) {
		this.nomeSelecionado = nomeSelecionado;
	}

	public List<Chefe> getListarechef() {
		return listarechef;
	}

	public void setListarechef(List<Chefe> listarechef) {
		this.listarechef = listarechef;
	}
	
	
	
}
