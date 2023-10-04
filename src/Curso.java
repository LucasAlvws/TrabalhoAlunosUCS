
public class Curso {
	private String nome;
	private int codigo;
	public Curso() {
		
	}
	public Curso(String nome, int codi) {
		this.nome = nome;
		this.codigo = codi;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
