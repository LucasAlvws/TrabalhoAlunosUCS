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
			System.out.println("\n\n++++++++++++++++++++++Insituição de Ensino " + this.instituicao.getNome() + " ++++++++++++++++++++++");
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
				System.out.println("2...");
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
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Turmas");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(this.instituicao.listaTurmas());
		
		
	}
}
