import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		AnuncioView anuncioView = new AnuncioView(scanner);
		anuncioView.menu();
		scanner.close();

	}

}
