package calc;
 
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
 
@WebService(endpointInterface = "calc.CalculadoraServer")
public class CalculadoraServerImpl implements CalculadoraServer { 
  
  public String listAll(){
	  Service servico = new Service();
	  return servico.listarProdutos();
  }
  
  public String addProduto(int id, String nome, int quantidade){
	  Service servico = new Service();
	  return servico.addProduto(id, nome, quantidade);
  }
  
  public String remover(int id){
	  Service servico = new Service();
	  return servico.remover(id);
  }
  
  public String alterar(int id, int quantidade){
	  Service servico = new Service();
	  return servico.alterar(id, quantidade);
  }
 
}