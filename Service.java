package calc;

import java.util.List;
import java.util.ArrayList;

public class Service {
	
	List<Produto> produto = new ArrayList<Produto>();
	Produto p = null;
	
	public Service() {
		
		p = new Produto(1, "tibia", 2);
		produto.add(p);
		p = new Produto(2, "midgnith", 44);
		produto.add(p);
	}
	
	public String listarProdutos(){
	  String output = "";
	  for(int i = 0; i < produto.size(); i++) {
			output += "Nome do produto: " + produto.get(i).getNome() + '\n' + "ID do produto: " + produto.get(i).getID() + '\n' + "Quantidade do produto: " +  produto.get(i).getQuantidade() + '\n' + "----------------" + '\n';
		}
	  return output;
	}
	
	public String addProduto(int id, String nome, int quantidade) {
		p = new Produto(id, nome, quantidade);
		produto.add(p);
		return listarProdutos();
	}
	
	public String remover(int id) {
		for(int i = 0; i < produto.size(); i++) {
			if(produto.get(i).getID() == id) {
				produto.remove(p);
			}
		}
		return listarProdutos();
	}
	
	public String alterar(int id, int quantidade) {
		for(int i = 0; i < produto.size(); i++) {
			if(produto.get(i).getID() == id) {
				produto.get(i).setQuantidade(quantidade);
			}
		}
		return listarProdutos();
	}
	
}
