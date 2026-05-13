package modelo;

public class Noticia {
	private String texto;
	private String classificacao;
	
	public Noticia(String texto, String classificacao) {
		this.texto = texto;
		this.classificacao = (classificacao == null || classificacao.isEmpty() ? "duvidosa" : classificacao);
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
	
	@Override
	public String toString() {
		return "Texto: " + texto + "\nClassificacao: " + classificacao;
	}
}
