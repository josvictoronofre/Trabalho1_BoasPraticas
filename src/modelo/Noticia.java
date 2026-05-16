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
			this.classificacao = "";
			break;
		}
	}
	
	public Noticia (String texto) {
		this.texto = texto;
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
	
	//polimorfismo ajuda a simplificar a passagem de dados pro usuario
	@Override
	public String toString() {
		return "Texto: " + texto + "\nClassificacao: " + classificacao + "\n";
	}
}
