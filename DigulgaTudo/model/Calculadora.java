
public class Calculadora {

	public static int projecaoVisualizacoes(double investimento) {
		double resultado = 0;
		double viewsOriginais = (investimento * 30);
		double numClicks = (viewsOriginais / 100) * 12;
		double compartilhamentoRedesSociais = (numClicks / 20) * 3;
		double viewsRedesSociais = compartilhamentoRedesSociais * 40;
		resultado = viewsRedesSociais;
		for(int i = 0; i < 2; i++) {
			double resultadoIClick = (resultado / 100) * 12;
			double resultadoICRS = (resultadoIClick / 20) * 3;
			double resultadoIViewRS = resultadoICRS * 40;
			resultado += resultadoIViewRS;
		}
		return (int) resultado;
	}
	
	public static int projecaoCliques(double investimento) {
		double resultadoCliques = 0;
		double resultado = 0;
		double viewsOriginais = (investimento * 30);
		double numClicks = (viewsOriginais / 100) * 12;
		double compartilhamentoRedesSociais = (numClicks / 20) * 3;
		double viewsRedesSociais = compartilhamentoRedesSociais * 40;
		resultado = viewsRedesSociais;
		resultadoCliques = numClicks;
		for(int i = 0; i < 2; i++) {
			double resultadoIClick = (resultado / 100) * 12;
			double resultadoICRS = (resultadoIClick / 20) * 3;
			double resultadoIViewRS = resultadoICRS * 40;
			resultado += resultadoIViewRS;
			resultadoCliques += resultadoIClick;
		}
		return (int) resultadoCliques;
	}
	
	public static int projecaoCompartilhamento(double investimento) {
		double resultadoCompartilhamento = 0;
		double resultado = 0;
		double viewsOriginais = (investimento * 30);
		double numClicks = (viewsOriginais / 100) * 12;
		double compartilhamentoRedesSociais = (numClicks / 20) * 3;
		double viewsRedesSociais = compartilhamentoRedesSociais * 40;
		resultado = viewsRedesSociais;
		resultadoCompartilhamento =  compartilhamentoRedesSociais;
		for(int i = 0; i < 2; i++) {
			double resultadoIClick = (resultado / 100) * 12;
			double resultadoICRS = (resultadoIClick / 20) * 3;
			double resultadoIViewRS = resultadoICRS * 40;
			resultado += resultadoIViewRS;
			resultadoCompartilhamento += resultadoICRS;
		}
		return (int) resultadoCompartilhamento;
	}
}
