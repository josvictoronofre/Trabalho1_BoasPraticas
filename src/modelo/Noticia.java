package modelo;

public class Noticia {
	private String texto;
	private String classificacao;
	
	public Noticia(String texto, String classificacao) {
		this.texto = texto;
		String classeTratada = (classificacao == null) ? "" : classificacao.trim().toLowerCase();
		
		switch (classeTratada) {
		 case "confiavel":
			 this.classificacao = classeTratada;
			 break;
		 case "falsa":
			 this.classificacao = classeTratada;
			 break;
		 case "duvidosa":
			 this.classificacao = classeTratada;
			 break;
		default:
			this.gerarClassificacaoAutomatica();
			break;
		}
	}
	
	public Noticia (String texto) {
		this(texto, null);
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getClassificacao() {
		return classificacao;
	}
	
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	//O sistema de pontuação continua o mesmo
		public void gerarClassificacaoAutomatica() {
			int pontuacao = 0;
			
			if (!this.texto.contains("FONTE")) pontuacao++;
			if (this.texto.contains("!!!")) pontuacao++;
			if (this.texto.contains("URGENTE")) pontuacao++;
			if (this.texto.length() < 10) pontuacao++;
			
			if (pontuacao == 0) this.classificacao = ("confiavel");
			else if (pontuacao == 1) this.classificacao = ("duvidosa");
			else this.classificacao = ("falsa");
		}
	
	//polimorfismo ajuda a simplificar a passagem de dados pro usuario
	@Override
	public String toString() {
		return "Texto: " + texto + "\nClassificacao: " + classificacao + "\n";
	}
}
