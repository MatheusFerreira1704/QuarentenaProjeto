package dao;

import java.util.List;

import entidade.Chefe;

public interface ChefeDAO {

	public boolean inserirChefe(Chefe chefe);

	public boolean editarChefe(Chefe chefe);
	
	public boolean removerChefe(Chefe chefe);

	public Chefe pesquisar(String login);
	
	public List<Chefe> listarChefes();
}
