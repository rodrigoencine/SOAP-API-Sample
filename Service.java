package calc;

import java.util.List;
import java.util.ArrayList;

public class Service {
	
	List<Produto> produto = new ArrayList<Produto>();
	PersistenciaDB  persistencia = new PersistenciaDB();
	Produto p = null;
	
	public Service() {

	}
	
	public String listarProdutos(){
	  List<Produto> listaProdutos = new ArrayList<Produto>();
	  listaProdutos = persistencia.listarTodos();
	  String output = "";
	  for(int i = 0; i < listaProdutos.size(); i++) {
			output += "Nome do produto: " + listaProdutos.get(i).getNome() + '\n' + "ID do produto: " + listaProdutos.get(i).getID() + '\n' + "Quantidade do produto: " +  listaProdutos.get(i).getQuantidade() + '\n' + "----------------" + '\n';
		}
	  return output;
	}
	
	public String addProduto(String nome, int quantidade) {
		p = new Produto(nome, quantidade);
		persistencia.adicionar(p);
		return listarProdutos();
	}
	
	public String remover(int id) {
		persistencia.delete(Integer.toString(id));
		return listarProdutos();
	}
	
	public String alterar(String nome, int quantidade) {
		persistencia.update(nome, quantidade);
		return listarProdutos();
	}
	
}
