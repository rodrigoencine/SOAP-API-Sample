package calc;

public class Produto {

	private int id;
	private int quantidade;
	private String nome;
	
	public Produto() {
	}
	
	public Produto(int id, String nome, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
}
