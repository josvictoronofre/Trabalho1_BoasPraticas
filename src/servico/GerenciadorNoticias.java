package servico;

import java.util.ArrayList;
import java.util.List;

import modelo.Noticia;

public class GerenciadorNoticias {
	private List<Noticia> repositorio = new ArrayList<>();
	
	public void adicionar(Noticia noticia) {
        // Programação defensiva: evita adicionar objetos ou textos nulos/vazios
        if (noticia != null && noticia.getTexto() != null && !noticia.getTexto().isBlank()) {
            repositorio.add(noticia);
        } else {
            System.err.println("Erro: Texto inválido! A notícia não foi adicionada.");
        }
    }
	
	//retorna o valor dos objetos sem dar acesso indevido às variáveis
	public List<Noticia> getTodasNoticias() {
		return repositorio;
	}
}
