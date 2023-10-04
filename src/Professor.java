
public class Professor extends Pessoa{
	private String formacao;
	
	
	public Professor(String cod, String nome, String email, String profissao) {
		super.setCodigo(cod);
		super.setNome(nome);
		super.setEmail(email);
		this.formacao = profissao;
	}
	public String getProfissao() {
		return formacao;
	}

	public void setProfissao(String profissao) {
		this.formacao = profissao;
	}
}
