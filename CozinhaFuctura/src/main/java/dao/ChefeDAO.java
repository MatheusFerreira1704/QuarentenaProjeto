package dao;

import java.util.List;

import entidade.Chefe;
import entidade.Receitas;

public interface ChefeDAO {

	public boolean inserir(Chefe chefe);

	public void editarChefe(Chefe chefe);
	
	public void remover(Chefe chefe);

	public Chefe pesquisar(String login);
	
	public List<Chefe> listarChefes();
}
