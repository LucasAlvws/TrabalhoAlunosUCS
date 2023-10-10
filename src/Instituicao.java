
public class Instituicao {
	private static final int NTURMAS = 5;
	private static final int NPROF = 5;
	private static final int NCUR = 4;
	
	private String nome;
	private Professor[] professores;
	private Turma[] turmas;
	private Curso[] cursos;
	private int qtdTurmas;
	
	private Instituicao() {
		this.turmas = new Turma[NTURMAS];
		this.qtdTurmas = 0;
		this.professores = new Professor[NPROF];
		this.professores[0] = new Professor("7B8F", "Lucas Alves", "lalves@ucs.br", "Ciência da Computação");
		this.professores[1] = new Professor("5D6S", "Guilherme Maieron", "gbmaieron@ucs.br", "Engenharia da Computação");
		this.professores[2] = new Professor("9A2Q", "Ana Paula", "anap@ucs.br", "Análise de Sistemas");
		this.professores[3] = new Professor("3C1A", "Nicoly Rosa", "nrosa@ucs.br", "Ciência da Computação");
		this.professores[4] = new Professor("4M8Y", "Lucca Drum", "ldrum@ucs.br", "Engenharia de Software");
		this.cursos = new Curso[NCUR];
		this.cursos[0] = new Curso("Ciência de Computação", 1);
		this.cursos[1] = new Curso("Engenharia de Software", 2);
		this.cursos[2] = new Curso("Engenharia de Computação", 3);
		this.cursos[3] = new Curso("Análise e Desenvolvimento de Sistemas", 4);
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
	
	
	public String listarProfessores() {
		StringBuilder retorno = new StringBuilder();
		for(int i=0; i < this.NPROF; i++) {
			retorno.append("-\n");
			retorno.append("Código: " + this.professores[i].getCodigo() + " Nome: " + this.professores[i].getNome() + "\n");
			
		}
		retorno.append("-------------------\n");
		return retorno.toString();
	}
	
	public String listarCursos() {
		StringBuilder retorno = new StringBuilder();
		for(int i=0; i < this.NCUR; i++) {
			retorno.append("-\n");
			retorno.append("Código: " + this.cursos[i].getCodigo() + " Nome: " + this.cursos[i].getNome() + "\n");
			
		}
		retorno.append("-------------------\n");
		return retorno.toString();
	}

	public Professor[] getProfessores() {
		return professores;
	}

	public static int getNprof() {
		return NPROF;
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
				retorno.append("-----------\n");
			}
			return retorno.toString();
		}
	}
	
	public String listaCodTurmas() {
		if(this.qtdTurmas==0) {
			return "Nenhuma turma foi registrada ainda"; 
		}else {
			StringBuilder retorno = new StringBuilder();
			for(int i=0; i < this.qtdTurmas; i++) {
				retorno.append("Código: " + this.turmas[i].getCodigo() + " Diciplina: " + this.turmas[i].getNomeDiciplina() + "\n");
				retorno.append("-----------\n");
			}
			return retorno.toString();
		}
	}
	
	
	public String detalheTurma(String cod) {
		StringBuilder retorno = new StringBuilder();
		Turma turma = getTurma(cod);
		retorno.append("Código: " + turma.getCodigo()+ "\n");
		retorno.append("Diciplina: " + turma.getNomeDiciplina()+ "\n");
		retorno.append("Professor: " + turma.getProfessor().getNome()+ "\n");
		retorno.append("Alunos:\n");
		for(int i=0; i < turma.getQtdAlunos();i++) {
			AlunoNota aluno = turma.getAluno()[i];
			double media = aluno.getN1()+aluno.getN2()+aluno.getN3()/3;
			retorno.append("---\n");
			retorno.append("Nome: " + aluno.getAluno().getNome() + "\n");
			retorno.append("N1: " + aluno.getN1() + "\n");
			retorno.append("N2: " + aluno.getN2() + "\n");
			retorno.append("N3: " + aluno.getN3() + "\n");
			retorno.append("Média: " + media + "\n");
			if(media>7) {
				retorno.append("Situaçao: Aprovado\n");
			}
			else {
				retorno.append("Situaçao: Reprovado\n");
			}
		}
		return retorno.toString();
	}
	
	public Professor getProfessor(String codigo) {
		for(Professor i : this.professores) {
			if (i.getCodigo().equalsIgnoreCase(codigo)) {
				return i;
			}
		}
		return null;
	}
	
	public Curso getCursos(int codigo) {
		for(Curso i : this.cursos) {
			if (i.getCodigo() == codigo) {
				return i;
			}
		}
		return null;
	}
	
	public Turma getTurma(String codigo) {
		for(Turma i : this.turmas) {
			if (i.getCodigo().equalsIgnoreCase(codigo)) {
				return i;
			}
		}
		return null;
	}
	
	public boolean setAlunos(String codTurma, String codAluno, int codCurso, String nomeAluno, String emailAluno, double n1, double n2, double n3) {
		Turma turma = getTurma(codTurma);
		Curso curso = getCursos(codCurso);
		Aluno aluno = new Aluno(codAluno, nomeAluno, emailAluno, curso);
		AlunoNota alunoNota = new AlunoNota(aluno, n1, n2, n3);
		boolean set = turma.setAlunos(alunoNota);
		return set;
	}
	
	
}
