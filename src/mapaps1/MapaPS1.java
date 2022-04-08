package mapaps1;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/*
Wesley Rodrigo Moreira - RA: 1948068-5
*/


public class MapaPS1 {
    
        private Scanner l;
	private boolean execute;
	private List<Paciente> paciente;
        
	public static void main(String[] args) {
		new MapaPS1();
	}

	private MapaPS1() {
		l = new Scanner(System.in);
		execute = true;
		paciente = new ArrayList<Paciente>();

		System.out.println("\nCADASTRO DE PACIENTES");

		while (execute) {
			String opcao = menu();

			if (opcao.equalsIgnoreCase("n")) {
				cadastrar();
			} else if (opcao.equalsIgnoreCase("l")) {
				listarCadastros();
			} else {
				System.out.println("\nOpção inválida! \n");
			}
		}
	}

	private String menu() {
		System.out.println("Selecione a opção:");
		System.out.println("N - Novo cadastro");
		System.out.println("L - Listar cadastros");
		return l.nextLine();
	}

	private void cadastrar() {
		boolean cadastrando = true;
                String sair = "sair";

		while (cadastrando) {
			System.out.println("\nCadastro de novos pacientes: ");
			Paciente p = new Paciente();
                        String cpf = textInput("CPF: ");
                        if (cpf.equals("sair")) {
                            System.out.println("Saindo do cadastro!");
                            System.exit(0);                       
                        }
                        else if(cpf != "sair"){
                            p.setCpf(cpf);
                        }                        
                        p.setNome(textInput("Nome: "));
			p.setIdade(textInput("Idade: "));
			p.setSexo(textInput("Sexo: "));
                                    

			System.out.println("\nResponda as perguntas: ");
                        String questionario;
                        int resultado = 0;

                        questionario = textInput("Tem Febre? (S/N) ?");
                        if(questionario.equals("s")){
                            resultado= resultado + 5;
                        }
                        questionario = textInput("Tem dor de cabeça? (S/N) ?");
                        if(questionario.equals("s")){
                            resultado= resultado + 1;
                        }
                        questionario = textInput("Tem secreção nasal ou espirros? (S/N) ?");
                        if(questionario.equals("s")){
                            resultado= resultado + 1;
                        }
                        questionario = textInput("Tem dor/irritação na garganta? (S/N) ?");
                        if(questionario.equals("s")){
                            resultado= resultado + 1;
                        }
                        questionario = textInput("Tem tosse seca? (S/N) ?");
                        if(questionario.equals("s")){
                            resultado= resultado + 3;
                        }
                        questionario = textInput("Tem dificuldade respiratória? (S/N) ?");
                        if(questionario.equals("s")){
                            resultado= resultado + 10;
                        }
                        questionario = textInput("Tem dores no corpo? (S/N) ?");
                        if(questionario.equals("s")){
                            resultado= resultado + 1;
                        }
                        questionario = textInput("Tem diarreia? (S/N) ?");
                        if(questionario.equals("s")){
                            resultado= resultado + 1;
                        }
                        questionario = textInput("Esteve em contato, nos últimos 14 dias, com um caso diagnosticado com COVID-19? (S/N) ?");
                        if(questionario.equals("s")){
                            resultado= resultado + 10;
                        }
                        questionario = textInput("Esteve em locais com grande aglomeração? (S/N) ?");
                        if(questionario.equals("s")){
                            resultado= resultado + 3;
                        }
                        p.setResultado(resultado);
                        
                        System.out.println("O resultado da pontuação é : " + resultado);
                        if(resultado <= 9){
                            System.out.println("O risco é baixo - Se dirija para a ala 1");
                        }
                        else if(resultado >9 && resultado <= 19){
                            System.out.println("O risco é médio - Se dirija para a ala 2");
                        }
                        else if(resultado > 19){
                            System.out.println("O risco é alto - Se dirija para a ala 3");
                        }
            
                        
                        
			String cadastrar = textInput("\nConfirmar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("\nCadastro adicionado !!!");
				paciente.add(p);
                                cadastrando = false;
			} else if (cadastrar.equalsIgnoreCase("n")){
				System.out.println("\nCadastro ignorado! \n");
                                cadastrando = false;
			} else {
				System.out.println("\n Opção inválida! \n");
			}

                        
                        
                        
                        
                        String mostrarLista = textInput("\nDeseja ver a lista de pacientes? (S/N)");
                        if (mostrarLista.equalsIgnoreCase("s")) {
                                listarCadastros();
                                cadastrando = true;
			} else if (mostrarLista.equalsIgnoreCase("n")){
                                cadastrando = true;
			} else {
				System.out.println("\n Opção inválida! \n");
			}

		}
	}

	private void listarCadastros() {
		if (paciente.size() == 0) {
			System.out.println("\nNão existem cadastros !!!\n");
		} else {
			System.out.println("\nLista de Cadastros\n");
			for (int i = 0; i < paciente.size(); i++) {
				Paciente d = paciente.get(i);
				System.out.println("Cadastro número: " + i);
				System.out.println("\tNome: " + d.getNome());
				System.out.println("\tIdade: " + d.getIdade());
				System.out.println("\tSexo: " + d.getSexo());
                                System.out.println("\tCpf: " + d.getCpf());
                                System.out.println("\tResultado Questionario: " + d.getResultado() + "\n");


			}
			System.out.println("\nFim da lista\n");
		}
	}

	private String textInput(String label) {
		System.out.println(label);
		return l.nextLine();
	}
}