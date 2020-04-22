package dao;

import java.util.List;
import entidade.Receitas;

public interface ReceitaDAO {

	public boolean inserirReceita(Receitas receita);

	public boolean editarReceita(Receitas receita);
	
	public boolean removerReceita(Receitas receita);
	
	List<Receitas> listaReceita(String coluna, String valor);
	
}
