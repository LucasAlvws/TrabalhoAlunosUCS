
public class Instituicao {
	private static final int NTURMAS = 5;
	
	private String nome;
	private Turma[] turmas;
	private int qtdTurmas;
	
	private Instituicao() {
		this.turmas = new Turma[NTURMAS];
		this.qtdTurmas = 0;
	}
	
	public Instituicao(String nome) {
		this();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean setTurmas(String codigo, Professor professor, String nomeDiciplina) {
		Turma turma = new Turma(codigo, professor, nomeDiciplina);
		if(this.qtdTurmas < this.NTURMAS) {
			this.turmas[this.qtdTurmas++] = turma;
			return true;
		}
		else {
			return false;
		}
	}
	public Turma[] getTurmas() {
		return turmas;
	}

	public int getQtdTurmas() {
		return qtdTurmas;
	}

	public static int getNturmas() {
		return NTURMAS;
	}
	
	public String listaTurmas() {
		if(this.qtdTurmas==0) {
			return "Nenhuma turma foi registrada ainda"; 
		}else {
			StringBuilder retorno = new StringBuilder();
			for(int i=0; i < this.qtdTurmas; i++) {
				retorno.append("Código: " + this.turmas[i].getCodigo() + "\n");
				retorno.append("Diciplina: " + this.turmas[i].getNomeDiciplina() + "\n");
				retorno.append("Professor: " + this.turmas[i].getProfessor().getNome() + "\n");
				retorno.append("Nmr Alunos: " + this.turmas[i].getQtdAlunos() + "\n");
			}
			return retorno.toString();
		}
	}

	
	
}
