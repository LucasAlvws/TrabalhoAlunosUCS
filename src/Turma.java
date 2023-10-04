
public class Turma {
	private static final int MAXALUNOS= 30;
	
	private String codigo;
	private Professor professor;
	private String nomeDiciplina;
	private AlunoNota[] alunos;
	private int qtdAlunos;
	
	private Turma() {
		alunos = new AlunoNota[this.MAXALUNOS];
		this.qtdAlunos = 0;
	}
	
	public Turma(String codigo, Professor professor, String nomeDiciplina) {
		this();
		this.codigo = codigo;
		this.professor = professor;
		this.nomeDiciplina = nomeDiciplina;
	}
	
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getNomeDiciplina() {
		return this.nomeDiciplina;
	}

	public void setNomeDiciplina(String nomeDiciplina) {
		this.nomeDiciplina = nomeDiciplina;
	}
	
	public AlunoNota[] getAluno() {
		return alunos;
	}

	public boolean setAlunos(AlunoNota aluno) {
		if(this.qtdAlunos < MAXALUNOS) {
			this.alunos[this.qtdAlunos++] = aluno;
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getQtdAlunos() {
		return qtdAlunos;
	}

	public static int getMaxalunos() {
		return MAXALUNOS;
	}
	
	
	
	
	
}
