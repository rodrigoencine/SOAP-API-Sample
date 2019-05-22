package calc;
 
import javax.jws.WebService;
import java.util.List;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
@WebService
@SOAPBinding(style = Style.RPC)
public interface CartServer {

  @WebMethod String listAll();
  @WebMethod String remover(int id);
  @WebMethod String addProduto(String nome, int quantidade);
  @WebMethod String alterar(String nome, int quantidade);
}