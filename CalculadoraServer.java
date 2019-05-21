package calc;
 
import javax.jws.WebService;
import java.util.List;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
@WebService
@SOAPBinding(style = Style.RPC)
public interface CalculadoraServer {
  @WebMethod float soma(float num1, float num2);
  @WebMethod float subtracao(float num1, float num2);
  @WebMethod float multiplicacao(float num1, float num2);
  @WebMethod float divisao(float num1, float num2);
  @WebMethod String hello();
  //métodos que ficarao
  @WebMethod Produto[] listAll();
 // @WebMethod List<Produto> remover(int id);
 // @WebMethod List<Produto> adicionar(int id, String nome, int quantidade);
  //@WebMethod List<Produto> alterar(int id, int quantidade);
}