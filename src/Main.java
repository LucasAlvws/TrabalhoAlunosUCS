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
		int opcao;
		cmd = new Scanner(System.in);
		
		while (true){
			System.out.println("++++++++++++++++++++++Insituição de Ensino " + this.instituicao.getNome() + " ++++++++++++++++++++++");
			System.out.println("Escolha a opção:");
			System.out.println(" 1) Listar turmas");
			System.out.println(" 2) Cadastrar turmas");
			System.out.println(" 3) Listar professores");
			System.out.println(" 4) Cadastrar professores");
			System.out.println(" 5) Listar cursos");
			System.out.println(" 6) Cadastrar cursos");
			System.out.println(" 7) Detalhes turma");
			System.out.println(" 8) Notas gerais");
			System.out.println(" 9) Sair");
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
				listarProfessor();
				break;
			case 4:
				cadastrarProfessor();
				break;
			case 5:
				listarCurso();
				break;
			case 6:
				cadastrarCurso();
				break;
			case 7:
				listarTurmasNotas();
				break;
			case 8:
				notasGerais();
				break;
			case 9:
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

	public void notasGerais() {
		System.out.println("Notas gerais");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(this.instituicao.detalhesGeral());
		System.out.println("Pressione qualquer tecla para voltar ao menu...");
		cmd.nextLine();
	}

	public void listarTurmas() {
		System.out.println("Turmas");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(this.instituicao.listaTurmas());
		System.out.println("Pressione qualquer tecla para voltar ao menu...");
		cmd.nextLine();
	}

	public void listarProfessor() {
		System.out.println("Professores");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(this.instituicao.listarProfessores());
		System.out.println("Pressione qualquer tecla para voltar ao menu...");
		cmd.nextLine();
	}

	public void listarCurso() {
		System.out.println("Cursos");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(this.instituicao.listarCursos());
		System.out.println("Pressione qualquer tecla para voltar ao menu...");
		cmd.nextLine();
	}

	public void cadastrarCurso() {
		int opcao;
		boolean codOK, nomeOK;
		do {

			nomeOK = codOK = true;

			System.out.println("Cadastro");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Informe o código do curso:");
			String cursoTemp = cmd.nextLine();
			cursoTemp = cursoTemp.toUpperCase();
			if(cursoTemp.equals("")) {
				codOK = false;
			}
			int codCurso = Integer.parseInt(cursoTemp);
			
			System.out.println("Informe o nome do curso:");
			String nome = cmd.nextLine();
			if(nome.equals("")) {
				nomeOK = false;
			}


			if (codOK == true && nomeOK == true) {
				
				Curso prof = new Curso(nome, codCurso);

				boolean adicionou = this.instituicao.addCurso(prof);

				if (adicionou == false)
				{
					System.out.println("Já excedeu o n° max de cursos.");
					opcao = 0;
					cmd.nextLine();	
				}
				else
				{
					System.out.println("Você deseja continuar a cadastrar cursos: '1-Sim/0-Não'");
					opcao = cmd.nextInt();
					cmd.nextLine();
				}

			}
			else {
				System.out.println("Erro no cadastro.");
				System.out.println("Pressione qualquer tecla para voltar ao menu...");
				cmd.nextLine();
				opcao = 0;
			}
		} while(opcao != 0);
	}

	public void cadastrarProfessor() {
		int opcao = 0;
		boolean codOK, nomeOK, emailOK, formacaoOk;
		do {

			nomeOK = codOK = emailOK = formacaoOk = true;

			System.out.println("Cadastro");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Informe o código do professor:");
			String codProf = cmd.nextLine();
			codProf = codProf.toUpperCase();
			if(codProf.equals("")) {
				codOK = false;
			}

			System.out.println("Informe o nome do professor:");
			String nome = cmd.nextLine();
			if(nome.equals("")) {
				nomeOK = false;
			}

			System.out.println("Informe o email do professor:");
			String email = cmd.nextLine();
			if(email.equals("")) {
				emailOK = false;
			}

			System.out.println("Informe a formação do professor:");
			String formacao = cmd.nextLine();
			if(formacao.equals("")) {
				formacaoOk = false;
			}

			if (emailOK == true && codOK == true && nomeOK == true && formacaoOk == true) {
				
				Professor prof = new Professor(codProf, nome, email, formacao);
				
				boolean adicionou = this.instituicao.addProfessor(prof);

				if (adicionou == false)
				{
					System.out.println("Já excedeu o n° max de professores.");
					opcao = 0;
					cmd.nextLine();	
				}
				else
				{
					System.out.println("Você deseja continuar a cadastrar professores: '1-Sim/0-Não'");
					opcao = cmd.nextInt();
					cmd.nextLine();
				}

			}
			else {
				System.out.println("Erro no cadastro.");
				System.out.println("Pressione qualquer tecla para voltar ao menu...");
				cmd.nextLine();
				opcao = 0;
			}
		} while(opcao != 0);
	}
	
	public void cadastrarTurmas() {
		if (this.instituicao.getQtdProfessores() == 0)
		{
			System.out.println("Nenhum professor foi registrado ainda...");
			System.out.println("Pressione qualquer tecla para voltar ao menu...");
			cmd.nextLine();
		 	return;
		}

		if (this.instituicao.getQtdCursos() == 0)
		{
			System.out.println("Nenhum curso foi registrado ainda...");
			System.out.println("Pressione qualquer tecla para voltar ao menu...");
			cmd.nextLine();
		 	return;
		}

		int opcao, continuarAluno;
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
				System.out.println("Cadastro dos alunos");
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
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
						System.out.println("Aluno cadastrado. Deseja continuar a inserir alunos: '1-Sim/0-Não'");
						continuarAluno = cmd.nextInt();
						cmd.nextLine();					}
					while( continuar == true && continuarAluno !=0);
					if(continuar == false) {
						System.out.println("Já excedeu o n° max de alunos.");
					}
					System.out.println("Turma cadastrada com sucesso.");
					opcao = 0;
				}
				else {
					System.out.println("Já excedeu o n° max de turmas.");
				}
				System.out.println("Você deseja continuar a inserir turmas: '1-Sim/0-Não'");
				opcao = cmd.nextInt();
				cmd.nextLine();
			}
			else {
				System.out.println("Erro no cadastro.");
				System.out.println("Pressione qualquer tecla para voltar ao menu...");
				cmd.nextLine();
				opcao = 0;
			}
		} while(opcao != 0);
		

	}
	
	public void listarTurmasNotas() 
	{
		System.out.println("Detalhes Turma");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(this.instituicao.listaCodTurmas());
		System.out.println("Insira o código da turma:");
		String cod = cmd.nextLine();
		cod = cod.toString();
		System.out.println("\n");
		System.out.println(this.instituicao.detalheTurma(cod));
		System.out.println("Pressione qualquer tecla para voltar ao menu...");
		cmd.nextLine();
	}
}

	
