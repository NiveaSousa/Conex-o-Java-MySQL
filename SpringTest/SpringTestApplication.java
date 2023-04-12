package com.unifacisa.SpringTest;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unifacisa.SpringTest.entities.Pessoa;
import com.unifacisa.SpringTest.services.ChamadoService;
import com.unifacisa.SpringTest.services.PessoaService;

@SpringBootApplication

public class SpringTestApplication implements CommandLineRunner {

	@Autowired
	PessoaService pessoaServico;
	
	@Autowired
	ChamadoService chamadoServico;

	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner leitor = new Scanner(System.in);

		System.out.println("Digite seu email:");
		String email = leitor.nextLine();
		System.out.println("Digite sua senha:");
		String senha = leitor.nextLine();
			
		

		if (pessoaServico.pessoaExiste(email) == false) {
			
		
			System.out.println("Não há usuários cadastrados. Cadastre Usuário");
			System.out.println("Digite seu email:");
			String novo_email = leitor.nextLine();
			System.out.println("Digite sua senha:");
			String nova_senha = leitor.nextLine();
			pessoaServico.addPessoa(novo_email, nova_senha, false);

		} else {
			if (pessoaServico.pessoaEAdmin(email) == true) {
				int opcao = 0;
				while (opcao != 4) {
					System.out.println("O que deseja fazer? 1. Listar Chamados abertos 2. Remover Chamados. 3. Adicionar administrador. 4. Sair");

					try {
						opcao = leitor.nextInt();
						if (opcao > 3) {
							System.out.println("Digite número dentro das opções");
						}
					} catch (InputMismatchException e) {
						System.out.println("Digite o número da opção");
						leitor.nextLine();
					}
					switch (opcao) {
					case 1:
						chamadoServico.listartodos();
						break;
					case 2:
						System.out.println("Esses são os chamados em aberto: ");
						chamadoServico.listartodos();
						System.out.println("Digite o Id do que quer remover: ");
						int id = leitor.nextInt();
						leitor.nextLine();
						chamadoServico.deletar(id);
						break;
						
					case 3:
						System.out.println("Digite email do Administrador:");
						String novo_email = leitor.nextLine();
						System.out.println("Digite senha:");
						String nova_senha = leitor.nextLine();
						pessoaServico.addPessoa(novo_email, nova_senha, true);
						break;
					}
				}
			} else {
				Pessoa criador = pessoaServico.pessoaCriadora(email);
				int loop = 0;
				while (loop != 3) {

					System.out.println("O que deseja fazer? 1. Listar seus Chamados 2. Cadastrar Chamados. 3. Sair");
					loop = leitor.nextInt();
					switch (loop) {
					case 1:
						chamadoServico.listarApenasCriador(email);
						break;
					case 2:
						leitor.nextLine();
						System.out
								.println("Digite sua manifestação aqui:");
						String conteudo = leitor.nextLine();
						
						System.out.println(chamadoServico.addChamado(criador, conteudo));
						leitor.nextLine();
						break;
						
					}
					leitor.nextLine();
				}
			}
		}

		leitor.close();

	}
}
