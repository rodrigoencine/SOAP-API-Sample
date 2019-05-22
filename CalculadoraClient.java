package calc;
 
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
 
class CalculadoraClient {
 
  public static void main(String args[]) throws Exception {
    URL url = new URL("http://127.0.0.1:9876/calc?wsdl");
    QName qname = new QName("http://calc/","CalculadoraServerImplService");
    Service ws = Service.create(url, qname);
    CalculadoraServer calc = ws.getPort(CalculadoraServer.class);
 
    System.out.println("-------- SISTEMA DE PRODUTOS ---------");
    System.out.println();
	System.out.println("Listagem inicial: ");
	System.out.println();
	System.out.println(calc.listAll());
	System.out.println("Agora listagem completa com a adição do produto noite e quantidade 2: ");
	System.out.println();
	System.out.println(calc.addProduto(66, "noite", 2));
	System.out.println("Agora remoção completa do produto midgnith: ");
	System.out.println();
	System.out.println(calc.remover(2));
	System.out.println("Agora alterando o produto tibia, colocando quantidade de 500: ");
	System.out.println(calc.alterar(1,500));
  }
}