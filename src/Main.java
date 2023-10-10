import java.util.Scanner;

public class Main {
	
	private static Scanner cmd;
	private Instituicao instituicao;
	
	public Main() {
		this.instituicao = new Instituicao("UCS");
	}
	
	public static void main(String[] args) {
		Main menu = new Main();
		menu.run();
	}
	
	public void run()
	{
		int opcao = 0;
		cmd = new Scanner(System.in);
		
		while (true){
			System.out.println("++++++++++++++++++++++Insituição de Ensino " + this.instituicao.getNome() + " ++++++++++++++++++++++");
			System.out.println("Escolha a opção:");
			System.out.println(" 1) Listar turmas");
			System.out.println(" 2) Cadastrar turmas");
			System.out.println(" 3) Detalhes turma");
			System.out.println(" 4) Notas das turmas");
			System.out.println(" 5) Sair");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
			opcao = cmd.nextInt();
			cmd.nextLine();
			switch (opcao) {
			case 1:
				listarTurmas();
				break;
			case 2:
				cadastrarTurmas();
				break;
			case 3:
				System.out.println("3...");
				break;
			case 4:
				System.out.println("4...");
				break;
			case 5:
				System.out.println("Deseja realmente sair? '1-Sim/2-Não'");
				opcao = cmd.nextInt();
				if (opcao == 1){
					System.out.println("Saindo...");
					cmd.close();
					System.exit(0);
				}
			}
			
		}
	}
	public void listarTurmas() {
		System.out.println("Turmas");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(this.instituicao.listaTurmas());
		System.out.println("Pressione qualquer tecla para voltar ao menu...");
		cmd.nextLine();
	}
	
	public void cadastrarTurmas() {
		int opcao = 0, continuarAluno = 0;
		boolean criado, codOK, diciplinaOK, continuar;
		Professor prof;
		do {
			prof = new Professor();
			diciplinaOK = codOK = true;
			System.out.println("Cadastro");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Informe o código da turma:");
			String codTurma = cmd.nextLine();
			codTurma = codTurma.toUpperCase();
			if(codTurma.equals("")) {
				codOK = false;
			}
			System.out.println("Informe o nome da diciplina:");
			String diciplina = cmd.nextLine();
			if(diciplina.equals("")) {
				diciplinaOK = false;
			}
			System.out.println("Informe o código do professor escolhido:");
			System.out.println(this.instituicao.listarProfessores());
			String codProf = cmd.nextLine();
			prof = this.instituicao.getProfessor(codProf);
			if (prof != null && codOK == true && diciplinaOK == true) {
				criado = this.instituicao.setTurmas(codTurma, prof, diciplina);
				System.out.println("Cadastro dos alunos:\n");
				if (criado == true) {
					do {
						System.out.println("Código do Aluno:");
						String codAluno = cmd.nextLine(); 
						codAluno = codAluno.toUpperCase();
						System.out.println("Curso do Aluno:");
						System.out.println(this.instituicao.listarCursos());
						int cursoAluno = cmd.nextInt();
						cmd.nextLine();
						System.out.println("Nome do Aluno:");
						String nomeAluno = cmd.nextLine();
						System.out.println("Email do Aluno:");
						String emailAluno = cmd.nextLine();
						System.out.println("N1 do Aluno:");
						double n1 = cmd.nextDouble();
						cmd.nextLine();
						System.out.println("N2 do Aluno:");
						double n2 = cmd.nextDouble();
						cmd.nextLine();
						System.out.println("N3 do Aluno:");
						double n3 = cmd.nextDouble();
						cmd.nextLine();
						continuar = this.instituicao.setAlunos(codTurma, codAluno, cursoAluno, nomeAluno, emailAluno, n1, n2, n3);
						System.out.println("Aluno cadastrado. Deseja continuar a inserir alunos: '1-Sim/2-Não'");
						continuarAluno = cmd.nextInt();
						cmd.nextLine();					}
					while( continuar == true && continuarAluno !=2);
					if(continuar == false) {
						System.out.println("Já excedeu o n° max de alunos.");
					}
					System.out.println("Turma cadastrada com sucesso.");
					System.out.println("Pressione qualquer tecla para voltar ao menu...");
					cmd.nextLine();
					opcao = 2;
				}
				else {
					System.out.println("Já excedeu o n° max de turmas.");
				}
				System.out.println("Você deseja continuar a inserir turmas: '1-Sim/2-Não'");
				opcao = cmd.nextInt();
				cmd.nextLine();
			}
			else {
				System.out.println("Erro no cadastro.");
				System.out.println("Pressione qualquer tecla para voltar ao menu...");
				cmd.nextLine();
				opcao = 2;
			}
		} while(opcao != 2);
		

	}
}
