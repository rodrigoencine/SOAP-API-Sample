package calc;
 
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
 
class CartClient {
 
  public static void main(String args[]) throws Exception {
    URL url = new URL("http://127.0.0.1:9876/calc?wsdl");
    QName qname = new QName("http://calc/","CartServerImplService");
    Service ws = Service.create(url, qname);
    CartServer calc = ws.getPort(CartServer.class);
 
    System.out.println("-------- SISTEMA DE PRODUTOS ---------");
    System.out.println();
	System.out.println("Listagem inicial: ");
	System.out.println();
	System.out.println(calc.listAll());
	System.out.println("Agora listagem completa com a adição do produto Playstation 4 e quantidade 2: ");
	System.out.println();
	System.out.println(calc.addProduto("Playstation 4", 2));
	System.out.println("Agora remoção completa do produto Cerveja: ");
	System.out.println();
	System.out.println(calc.remover(1));
	System.out.println("Agora alterando o produto JoJo, colocando quantidade de 500: ");
	System.out.println(calc.alterar("JoJo",500));
  }
}