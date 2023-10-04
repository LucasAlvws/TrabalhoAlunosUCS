
public class Aluno extends Pessoa{
	private Curso curso;
    
    public Aluno(String cod, String nome, String email, Curso curso) {
		super.setCodigo(cod);
		super.setNome(nome);
		super.setEmail(email);
		this.curso = curso;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
    
}
