import java.util.Scanner;

public class Calculadora {
	private static Scanner scanner;
	private double investimento = 0;

	public Calculadora(double investimento) {
		Integer visualizacao = (int)(investimento * 30);
		Integer compartilhamento = (int)(investimento * 40);
		Integer click = 0;

		for(int i=0; i<4;i++) {
			if(visualizacao > 100) {
				click = 12;
				if(visualizacao >= 200) {
					click = click * (visualizacao/100);
				}
			}
			if(click >= 20) {
				compartilhamento = compartilhamento + 3 * (click / 20);
				visualizacao = visualizacao + 3 * 40 * (click / 20);
			}
		}
		System.out.println("O total de visualização: " + visualizacao);
		System.out.println("O total de cliques: " + click);
		System.out.println("O total de compartilhamento: " +compartilhamento);

	}
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("*****Sistema de Agência Divulga Tudo******");
		System.out.println("Informar o valor do Investimento em reais: ");
		double investimento = scanner.nextDouble();
		Calculadora calculadora = new Calculadora(investimento);
	}





}
