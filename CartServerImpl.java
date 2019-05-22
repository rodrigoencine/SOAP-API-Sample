package calc;
 
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
 
@WebService(endpointInterface = "calc.CartServer")
public class CartServerImpl implements CartServer { 
  
  public String listAll(){
	  Service servico = new Service();
	  return servico.listarProdutos();
  }
  
  public String addProduto(String nome, int quantidade){
	  Service servico = new Service();
	  return servico.addProduto(nome, quantidade);
  }
  
  public String remover(int id){
	  Service servico = new Service();
	  return servico.remover(id);
  }
  
  public String alterar(String nome, int quantidade){
	  Service servico = new Service();
	  return servico.alterar(nome, quantidade);
  }
 
}