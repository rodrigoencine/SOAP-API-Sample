package calc;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/** 
 * @author rodrigo encine
 */
public class PersistenciaDB {

	private String caminho = "calc/produto.xml";
	
	public void adicionar(Produto produto) {

		Integer id = this.criaID();
		try {
			Document d = DOMHelper.getDocument(caminho);
			Element produtos = d.getDocumentElement();
			Element prod = d.createElement("produto");

			Element prodNome = d.createElement("nome");
			prodNome.appendChild(d.createTextNode(produto.getNome()));
			prod.appendChild(prodNome);

			Element prodQuantidade = d.createElement("quantidade");
			String 	quantidade = Integer.toString(produto.getQuantidade());
			prodQuantidade.appendChild(d.createTextNode(quantidade));
			prod.appendChild(prodQuantidade);

			Element prodId = d.createElement("id");
			produto.setID(id);
			String i = Integer.toString(produto.getID());
			prodId.appendChild(d.createTextNode(i));
			prod.appendChild(prodId);

			produtos.appendChild(prod);

			DOMHelper.saveXMLContent(d,caminho);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Método responsável pelo retorno da lista de despesas
	 * @return ArrayList - Despesas
	 * */

	public List<Produto> listarTodos() {
		List<Produto> lista = new ArrayList<Produto>();
		String nome = null;
		String quantidade = null;
		String id = null;
		try {

			Document d = DOMHelper.getDocument(caminho);
			NodeList nl = d.getElementsByTagName("produto");

			for (int i = 0; i < nl.getLength(); i++) {
				Element produto = (Element) nl.item(i);
				nome = produto.getElementsByTagName("nome").item(0).getTextContent();
				quantidade = produto.getElementsByTagName("quantidade").item(0).getTextContent();
				id = produto.getElementsByTagName("id").item(0).getTextContent();

				Produto prod = new Produto();
				prod.setNome(nome);
				prod.setQuantidade(Integer.parseInt(quantidade));
				prod.setID(Integer.parseInt(id));
				lista.add(prod);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}
	
	public void update(String nome, int quantidade) {
		try {
			Document d = DOMHelper.getDocument(caminho);
			NodeList nl = d.getElementsByTagName("produto");
			for (int i = 0; i < nl.getLength(); i++) {
				Element produto = (Element) nl.item(i);
				if (produto.getElementsByTagName("nome").item(0).getTextContent().equals(nome)) {
					
					produto.getElementsByTagName("quantidade").item(0).setTextContent(Integer.toString(quantidade));
				}
				DOMHelper.saveXMLContent(d,caminho);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void delete(String id) {
		try {
			Document d = DOMHelper.getDocument(caminho);
			NodeList nl = d.getElementsByTagName("produto");
			for (int i = 0; i < nl.getLength(); i++) {
				Element produto = (Element) nl.item(i);
				if (produto.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					produto.getParentNode().removeChild(produto);
				}
			}
			DOMHelper.saveXMLContent(d,caminho);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getQuantidadeTotal() {
		int valor = 0;
		for(Produto p: this.listarTodos()) {
			valor+=p.getQuantidade();
		}
		return valor;
	}

	public Integer criaID() {
		return this.ultimoIdCriado() + 1;
	}

	public Integer ultimoIdCriado() {
		Integer id = 0;
		for(Produto p:listarTodos()) {
			if(p.getID()>=id) {
				id = p.getID();
			}
		}
		return id;
	}
}