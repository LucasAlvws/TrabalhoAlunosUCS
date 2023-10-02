
public class Aluno extends Pessoa{
	private String curso;
    private double n1;
    private double n2;
    private double n3;
    public Aluno(String cod, String nome, String email, String curso) {
		super.setCodigo(cod);
		super.setNome(nome);
		super.setEmail(email);
		this.curso = curso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public double getN1() {
		return n1;
	}
	public void setN1(double n1) {
		this.n1 = n1;
	}
	public double getN2() {
		return n2;
	}
	public void setN2(double n2) {
		this.n2 = n2;
	}
	public double getN3() {
		return n3;
	}
	public void setN3(double n3) {
		this.n3 = n3;
	}
    
}
