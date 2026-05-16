package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Noticia;
import servico.GerenciadorNoticias;

public class SistemaNoticias {

	public static void main(String[] args) {
		GerenciadorNoticias gerenciador = new GerenciadorNoticias();
		int opcao = 0;
		Scanner scanner = new Scanner(System.in);
		
		//loop que controla o menu
		while (opcao != 4) {
			System.out.println("\n--- Menu principal ---");
			System.out.println("1. Adicionar manual");
			System.out.println("2. Adicionar automatico");
			System.out.println("3. Listar");
			System.out.println("4. Sair");
				
				try {
					opcao = scanner.nextInt();
					switch (opcao) {
					 case 1: {
						System.out.print("Digite o texto: ");
						// Limpeza preventiva do buffer do teclado (usado múltiplas vezes no código)
						scanner.nextLine();
						String texto = scanner.nextLine(); 
						System.out.print("Digite a classificacao: ");
						String classificacao = scanner.nextLine();
						gerenciador.adicionar(new Noticia(texto, classificacao));
						break;
					 }
					 case 2: {
						 System.out.print("Digite o texto: ");
						 scanner.nextLine();
						 String texto = scanner.nextLine();
						 gerenciador.adicionar(new Noticia(texto));
						 break;
					 }
					 case 3:
						for (Noticia noticia : gerenciador.getTodasNoticias()) {
							System.out.println(noticia);
						}
						break;
					 case 4:
						System.out.println("Fechando sistema...");
						break;
					}
				} 
				//captura o erro de tipo de variável sem quebrar o loop
				catch (InputMismatchException e) {
					System.err.println("Erro! valor inserido invalido para o campo!");
					scanner.nextLine(); 
				}
		}
		scanner.close();
	}

}
