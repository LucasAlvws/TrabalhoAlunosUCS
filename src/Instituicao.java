
public class Instituicao {
	private static final int NTURMAS = 5;
	private static final int NPROF = 5;
	private static final int NCUR = 4;
	
	private String nome;
	private Professor[] professores;
	private Turma[] turmas;
	private Curso[] cursos;
	private int qtdTurmas, qtdProfessores, qtdCursos;
	
	private Instituicao() {
		this.turmas = new Turma[NTURMAS];
		this.qtdTurmas = 0;
		this.professores = new Professor[NPROF];
		this.qtdProfessores = 0;
		this.cursos = new Curso[NCUR];
		this.qtdCursos = 0;
		this.cursos[qtdCursos++] = new Curso("Ciência de Computação", 1);
		this.cursos[qtdCursos++] = new Curso("Engenharia de Software", 2);
		this.cursos[qtdCursos++] = new Curso("Engenharia de Computação", 3);
		this.cursos[qtdCursos++] = new Curso("Análise e Desenvolvimento de Sistemas", 4);
		
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

	public int getQtdProfessores() {
		return qtdProfessores;
	}

	public int getQtdCursos() {
		return qtdCursos;
	}

	public static int getNturmas() {
		return NTURMAS;
	}
	
	
	public String listarProfessores() {
		if (this.qtdProfessores == 0)
		{	
			return "Nenhum professor foi registrado ainda"; 
		}
		else
		{
			StringBuilder retorno = new StringBuilder();
			for(int i=0; i < this.qtdProfessores; i++) {
				retorno.append("-\n");
				retorno.append("Código: " + this.professores[i].getCodigo() + " Nome: " + this.professores[i].getNome() + "\n");
				
			}
			retorno.append("-------------------\n");
			return retorno.toString();
		}
	}

	public boolean addCurso(Curso curso) {
		if(qtdCursos < NCUR) {
			this.cursos[this.qtdCursos++] = curso;
			return true;
		}
		
		return false;
	}

	public boolean addProfessor(Professor prof) {
		if(qtdProfessores < NPROF) {
			this.professores[this.qtdProfessores++] = prof;
			return true;
		}
		return false;
	}
	
	public String listarCursos() {
		if (this.qtdCursos == 0)
		{
			return "Nenhum curso foi registrado ainda"; 
		}
	
		StringBuilder retorno = new StringBuilder();
		for(int i=0; i < this.qtdCursos; i++) {
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
		}

		StringBuilder retorno = new StringBuilder();
		for(int i=0; i < this.qtdTurmas; i++) {
			retorno.append("Código: " + this.turmas[i].getCodigo() + " ");
			retorno.append("Diciplina: " + this.turmas[i].getNomeDiciplina() + " ");
			retorno.append("Professor: " + this.turmas[i].getProfessor().getNome() + " ");
			retorno.append("Nmr Alunos: " + this.turmas[i].getQtdAlunos() + "\n");
			retorno.append("-----------\n");
		}
		return retorno.toString();
	}
	
	public String listaCodTurmas() {
		if(this.qtdTurmas==0) {
			return "Nenhuma turma foi registrada ainda"; 
		}

		StringBuilder retorno = new StringBuilder();
		for(int i=0; i < this.qtdTurmas; i++) {
			retorno.append("Código: " + this.turmas[i].getCodigo() + " Diciplina: " + this.turmas[i].getNomeDiciplina() + "\n");
			retorno.append("-----------\n");
		}
		return retorno.toString();
	}


	public String detalhesGeral() {
		if (this.qtdTurmas == 0)
		{
			return ("Nenhuma turma foi registrada ainda");
		}

		StringBuilder retorno = new StringBuilder();
		int nAprovadosGeral = 0;
		int nReprovadosGeral = 0;
		int qtdAlunosGeral = 0;

		retorno.append("--------LISTAGEM DAS TURMAS--------\n");
		for (int i =0; i < this.qtdTurmas; i ++)
		{	
			int nAprovadosTurma = 0;
			int nReprovadosTurma = 0;

			Turma turma = this.turmas[i];
			retorno.append("\n");
			retorno.append("Código: " + turma.getCodigo() + " ");
			retorno.append("Disciplina: " + turma.getNomeDiciplina() + " ");
			retorno.append("Professor: " + turma.getProfessor() + " ");
			retorno.append("Quantidade alunos: " + turma.getQtdAlunos() + "\n");

			for(int iTurma=0; iTurma < turma.getQtdAlunos(); iTurma++) {
				AlunoNota aluno = turma.getAluno()[i];
				double media = aluno.getN1()+aluno.getN2()+aluno.getN3()/3;
				if(media>7) {
					nAprovadosTurma++;
					nAprovadosGeral++;
				}
				else {
					nReprovadosTurma++;
					nReprovadosGeral++;
				}
				qtdAlunosGeral++;
			}	
			retorno.append("Nº alunos aprovados: " + nAprovadosTurma + "\n");
			retorno.append("Nº alunos reprovados: " + nReprovadosTurma + "\n");

			double taxaAprovacaoTurma = nAprovadosTurma * 100 / turma.getQtdAlunos(); 

			retorno.append("Taxa de aprovação na turma: " + String.format("%.2f", taxaAprovacaoTurma) + "% \n");
		}
		
		retorno.append("\n--------NOTAS DA INSTITUIÇÃO--------\n");

		retorno.append("Quantidade de alunos na instituição: " + qtdAlunosGeral + "\n");

		double taxaAprovacaoGeral = nAprovadosGeral * 100 / qtdAlunosGeral; 
		retorno.append("Taxa de aprovação na instituição: " + String.format("%.2f", taxaAprovacaoGeral) + "% \n");
		
		return retorno.toString();
	}
	
	public String detalheTurma(String cod) {
		StringBuilder retorno = new StringBuilder();
		Turma turma = getTurma(cod);
	
		retorno.append("Código: " + turma.getCodigo()+ "\n");
		retorno.append("Diciplina: " + turma.getNomeDiciplina()+ "\n");
		retorno.append("Professor: " + turma.getProfessor().getNome()+ "\n");
		retorno.append("-----------------------------------------\n");
		retorno.append("Alunos:\n");
		for(int i=0; i < turma.getQtdAlunos();i++) {
			AlunoNota aluno = turma.getAluno()[i];
			double media = (aluno.getN1()+aluno.getN2()+aluno.getN3())/3;
			retorno.append("---\n");
			retorno.append("Nome: " + aluno.getAluno().getNome() + " ");
			retorno.append("N1: " + aluno.getN1() + " ");
			retorno.append("N2: " + aluno.getN2() + " ");
			retorno.append("N3: " + aluno.getN3() + " ");
			retorno.append("Média: " + String.format("%.2f", media) + " ");
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
