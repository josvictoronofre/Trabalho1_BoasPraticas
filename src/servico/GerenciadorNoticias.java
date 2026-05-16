package servico;

import java.util.ArrayList;
import java.util.List;

import modelo.Noticia;

public class GerenciadorNoticias {
	private List<Noticia> repositorio = new ArrayList<>();
	
	public void adicionar(Noticia noticia) {
		
		//evita tentar adicionar objetos ou textos vazios ou nulos
		if (noticia != null && noticia.getTexto() != null && !noticia.getTexto().isBlank()) {
			if (noticia.getClassificacao() == null || noticia.getClassificacao().isEmpty()) {
				this.gerarClassificacaoAutomatica(noticia);
				repositorio.add(noticia);
			} else repositorio.add(noticia);
		} else System.out.println("Erro: Texto inválido!");
	}
	
	public List<Noticia> getTodasNoticias() {
		return repositorio;
	}
	
	//O sistema de pontuacao continua o mesmo
	public void gerarClassificacaoAutomatica(Noticia noticia) {
		int pontuacao = 0;
		
		if (!noticia.getTexto().contains("FONTE")) pontuacao++;
		if (noticia.getTexto().contains("!!!")) pontuacao++;
		if (noticia.getTexto().contains("URGENTE")) pontuacao++;
		
		if (pontuacao == 0) noticia.setClassificacao("confiavel");
		else if (pontuacao == 1) noticia.setClassificacao("duvidosa");
		else noticia.setClassificacao("falsa");
	}
}
