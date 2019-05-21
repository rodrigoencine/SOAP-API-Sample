package calc;

import java.util.List;
import java.util.ArrayList;

public class Service {

	public Produto[] listarProdutos(){
	 Produto p = new Produto(1, "joao", 2);
	  List<Produto> produto = new ArrayList<Produto>();
	  Produto array[] = {p};
	  return array;
	}
	
}
