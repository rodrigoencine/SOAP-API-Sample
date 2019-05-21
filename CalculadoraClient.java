package calc;
 
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.ArrayList;
import javax.xml.ws.Service;
import java.net.URL;
 
class CalculadoraClient {
 
  public static void main(String args[]) throws Exception {
    URL url = new URL("http://127.0.0.1:9876/calc?wsdl");
    QName qname = new QName("http://calc/","CalculadoraServerImplService");
    Service ws = Service.create(url, qname);
    CalculadoraServer calc = ws.getPort(CalculadoraServer.class);
 
    System.out.println("Soma (5+1): " + calc.soma(5,1));
    System.out.println("Subtracao de(5-1): " + calc.subtracao(5,1));
    System.out.println("Multiplicacao (5*1): " + calc.multiplicacao(5,1));
    System.out.println("Divisao (5/1): " + calc.divisao(5,1));
	System.out.println("Impressão do outro: " + calc.hello());
	System.out.println("fOI AQUI?");
	Produto produto[] = calc.listAll();
	for(int i = 0; i < produto.length; i++) {
		System.out.println("Nome do produto: " + produto[i].getNome() + '\n' + "ID do produto: " + produto[i].getID() + '\n' + "Quantidade do produto: " +  produto[i].getQuantidade());
	}
  }
}