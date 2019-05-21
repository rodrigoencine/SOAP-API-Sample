package calc;
 
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
 
@WebService(endpointInterface = "calc.CalculadoraServer")
public class CalculadoraServerImpl implements CalculadoraServer {
     
  public float soma(float num1, float num2) {
    return num1 + num2;
  }
   
  public float subtracao(float num1, float num2) {
    return num1 - num2;
  }
 
  public float multiplicacao(float num1, float num2) {
    return num1 * num2;
  }
 
  public float divisao(float num1, float num2) {
    return num1 / num2;
  }
  
  public String hello() {
	  return "eae men kkk";
  }
  
  public Produto[] listAll(){
	  Service servico = new Service();
	  return servico.listarProdutos();
  }
 
}