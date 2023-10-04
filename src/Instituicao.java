
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
	/*PAREI AQUIIIIIIIIIIIIPAREI AQUIIIIIIIIIIIIPAREI AQUIIIIIIIIIIIIPAREI AQUIIIIIIIIIIIIPAREI AQUIIIIIIIIIIIIPAREI AQUIIIIIIIIIIII*/
	public void setTurmas(String codigo, Professor professor, String nomeDiciplina) {
		
		this.turmas = turmas;
	}
	/*PAREI AQUIIIIIIIIIIIIPAREI AQUIIIIIIIIIIIIPAREI AQUIIIIIIIIIIIIPAREI AQUIIIIIIIIIIIIPAREI AQUIIIIIIIIIIIIPAREI AQUIIIIIIIIIIII*/
	public Turma[] getTurmas() {
		return turmas;
	}

	public int getQtdTurmas() {
		return qtdTurmas;
	}

	public static int getNturmas() {
		return NTURMAS;
	}

	
	
}
