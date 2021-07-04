import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Anuncio {
	private String nome;
	private String cliente;
	private Double investimentoPorDia;
	private Date dataInicioAnuncio;
	private Date dataTerminoAnuncio;	
	
	public Anuncio(String nome, String cliente, Date dataInicio, Date dataTermino, Double investimentoPorDia) {
		this.nome = nome;
		this.cliente = cliente;
		this.dataInicioAnuncio = dataInicio;
		this.dataTerminoAnuncio = dataTermino;
		this.investimentoPorDia = investimentoPorDia;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public Date getDataInicio() {
		return dataInicioAnuncio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicioAnuncio = dataInicio;
	}
	
	public Date getDataTermino() {
		return dataTerminoAnuncio;
	}
	
	public void setDataTermino(Date dataTermino) {
		this.dataTerminoAnuncio = dataTermino;
	}
	
	public Double getInvestimentoPorDia() {
		return investimentoPorDia;
	}
	
	public void setInvestimentoPorDia(Double investimentoPorDia) {
		this.investimentoPorDia = investimentoPorDia;
	}
	
	public Double valorTotalInvestido() {
		long diferenca = Math.abs(this.dataTerminoAnuncio.getTime() - this.dataInicioAnuncio.getTime());
		long diff = TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
		return this.investimentoPorDia * diff;
	}
	
	public int qtdmaximaVisualizacoes() {
		return Calculadora.projecaoVisualizacoes(this.valorTotalInvestido());
	}
	
	public int qtdmaximaCliques() {
		return Calculadora.projecaoCliques(this.valorTotalInvestido());
	}
	
	public int qtdMaximaCompartilhamentos() {
		return Calculadora.projecaoCompartilhamento(this.valorTotalInvestido());
	}
}
