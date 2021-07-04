import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AnuncioView {

	private Scanner scanner;
	private Date dataInicio;
	private Date dataFim;
	

	public AnuncioView(Scanner scanner) {
		// TODO Auto-generated constructor stub
		this.scanner = scanner;
	}

	public void menu() {
		// TODO Auto-generated method stub
		int opcao = -1;
		System.out.println("****SISTEMA GERENCIADOR DE AN�NCIOS****\n");
		System.out.println("***********Ag�ncia Divulga Tudo*********\n");
		while (opcao != 0) {
			System.out.println("\nFUNCIONALIDADES DISPON�VEIS:");
			System.out.println("------------------------------------------------------------------");
			System.out.println("Digite 1 para cadastrar um an�ncio");
			System.out.println("Digite 2 para ver o relat�rio dos an�ncios");
			System.out.println("Digite 3 para ver o relat�rio dos an�ncios por intervalo de tempo");
			System.out.println("Digite 4 para ver o relat�rio dos an�ncios por cliente");
			System.out.println("Digite 5 para ver o relat�rio dos an�ncios por intervalo de tempo e por cliente");
			System.out.println("------------------------------------------------------------------");
			System.out.println("DIGITE 0 PARA SAIR");
			System.out.println("------------------------------------------------------------------");
			try {
				opcao = scanner.nextInt();
				scanner.nextLine();
				operacao(opcao);
			} catch (Exception e) {
				System.out.println("Op��o inv�lida por favor informe uma op��o valida\n");
				scanner.nextLine();
			}
		} 
	}

	private void operacao(int opcao) {
		// TODO Auto-generated method stub
		List<Anuncio> anuncios = null;
		if (opcao != 1) {
			anuncios = AnuncioBO.listaAnuncios();
		}
		switch (opcao) {
		case 1:
			cadastrarAnuncio();
			break;
		case 2:
			gerarRelatorioAnuncios(anuncios);
			break;
		case 3:
			gerarRelatorioAnuncios(
					AnunciosIntervaloTempo(anuncios, getDataInicioAnuncio(), getDataTerminoAnuncio()));
			break;
		case 4:
			gerarRelatorioAnuncios(AnunciosClientes(anuncios, getNomeCliente()));
			break;
		case 5:
			gerarRelatorioAnuncios(AnunciosIntervaloTempoCliente(anuncios, getDataInicioAnuncio(),
					getDataTerminoAnuncio(), getNomeCliente()));
			break;
		}
	}

	

	private List<Anuncio> AnunciosIntervaloTempoCliente(List<Anuncio> anuncios, Date dataInicioAnuncio,
			Date dataTerminoAnuncio, String cliente) {
		// TODO Auto-generated method stub
		List<Anuncio> anunciosIntervaloCliente = new ArrayList<Anuncio>();
		if (anuncios != null && !anuncios.isEmpty()) {	
			List<Anuncio> anunciosIntervalo = AnunciosIntervaloTempo(anuncios, dataInicio, dataFim);
			anunciosIntervaloCliente = AnunciosClientes(anunciosIntervalo, cliente);
		}
		return anunciosIntervaloCliente;
	}

	private List<Anuncio> AnunciosClientes(List<Anuncio> anuncios, String cliente) {
		// TODO Auto-generated method stub
		List<Anuncio> anunciosCliente = new ArrayList<Anuncio>();
		if (anuncios != null && !anuncios.isEmpty()) {	
			for (Anuncio anuncio : anuncios) {
				if (anuncio.getCliente().equals(cliente)) {
					anunciosCliente.add(anuncio);
				}
			}
		}
		return anunciosCliente;
	}

	private List<Anuncio> AnunciosIntervaloTempo(List<Anuncio> anuncios, Date dataInicioAnuncio,
			Date dataTerminoAnuncio) {
		// TODO Auto-generated method stub
		List<Anuncio> anunciosIntervalo = new ArrayList<Anuncio>();
		if (anuncios != null && !anuncios.isEmpty()) {		
			for (Anuncio anuncio : anuncios) {
				if (anuncio.getDataInicio().getTime() >= dataInicio.getTime()
						&& anuncio.getDataTermino().getTime() <= dataFim.getTime()) {
					anunciosIntervalo.add(anuncio);
				}
			}
		}
		return anunciosIntervalo;
	}

	private void cadastrarAnuncio() {
		// TODO Auto-generated method stub
		String nome = getNomeAnuncio();
		String cliente = getNomeCliente();
		Date dataInicio = getDataInicioAnuncio();
		Date dataTermino = getDataTerminoAnuncio();
		Double investimentoPorDia = getValorInvestimentoPorDia();
		AnuncioBO.cadastrarAnuncio(nome, cliente, dataInicio, dataTermino, investimentoPorDia);
		System.out.println("\nAN�NCIO CADASTRADO COM SUCESSO!\n");
	}





	private String getNomeAnuncio() {
		// TODO Auto-generated method stub
		boolean isValidInput = false;
		String anuncio = "";
		while (!isValidInput){
			System.out.print("Informe o nome do an�ncio: ");
			try {
				anuncio = scanner.nextLine();
				isValidInput = true;
			} catch (Exception e) {
				System.out.println("Entrada errada, por favor tente novamente\n");
				scanner.nextLine();
			}
		} 

		return anuncio;
	}

	private String getNomeCliente() {
		// TODO Auto-generated method stub
		boolean isValidInput = false;
		String cliente = "";
		while (!isValidInput){
			System.out.print("Informe o nome do cliente: ");
			try {
				cliente = scanner.nextLine();
				isValidInput = true;
			} catch (Exception e) {
				System.out.println("Entrada errada, por favor tente novamente\n");
				scanner.nextLine();
			}
		} 
		return cliente;
	}

	private Date getDataInicioAnuncio() {
		// TODO Auto-generated method stub
		Date dataInicio = null;
		boolean isFormatted = false;
		while (!isFormatted) {
			System.out.print("Informe a data de in�cio do an�ncio(DD/MM/AAAA): ");
			try {
				dataInicio = AnuncioBO.formatoDataAnuncio(scanner.nextLine());
				isFormatted = true;
			} catch (ParseException e) {
				System.out.println("Erro no formato da data, ela deve ser informada com DD/MM/AAAA\n");
				scanner.nextLine();
			}
		} 
		return dataInicio;
	}
	

	private Date getDataTerminoAnuncio() {
		// TODO Auto-generated method stub
		Date dataTermino = null;
		boolean isFormatted = false;
		while (!isFormatted) {
			System.out.print("Informe a data de termino do an�ncio(DD/MM/AAAA): ");
			try {
				dataTermino = AnuncioBO.formatoDataAnuncio(scanner.nextLine());
				isFormatted = true;
			} catch (ParseException e) {
				System.out.println("Erro no formato da data, ela deve ser informada com DD/MM/AAAA\n");
				scanner.nextLine();
			}
		} 
		return dataTermino;
	}
	
	private Double getValorInvestimentoPorDia() {
		// TODO Auto-generated method stub
		Double investimentoPorDia = 0.0;
		boolean isValidInput = false;
		while (!isValidInput) {
			System.out.print("Informe o valor que ser� investido por dia: ");
			try {
				investimentoPorDia = scanner.nextDouble();
				isValidInput = true;
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Entrada errada, por favor tente novamente\n");
				scanner.nextLine();
			}
		} 
		return investimentoPorDia;
	}
	
	private void gerarRelatorioAnuncios(List<Anuncio> anuncios) {
		// TODO Auto-generated method stub
		if (anuncios == null || anuncios.isEmpty()) {
			System.out.println("\nSEM AN�NCIOS CADASTRADOS.");
		} else {
			System.out.println("RELAT�RIO DE AN�NCIOS");
			for (int i = 0; i < anuncios.size(); i++) {
				System.out.println("------------------------------------------------------------------");
				System.out.println("Nome do an�ncio: " + anuncios.get(i).getNome());
				System.out.println("Valor total investido: " + anuncios.get(i).valorTotalInvestido());
				System.out.println("Quantidade m�xima de visualiza��es: " + anuncios.get(i).qtdmaximaVisualizacoes());
				System.out.println("Quantidade m�xima de cliques: " + anuncios.get(i).qtdmaximaCliques());
				System.out.println(
						"Quantidade m�xima de compartilhamentos: " + anuncios.get(i).qtdMaximaCompartilhamentos());
				System.out.println("------------------------------------------------------------------");
			}

		}
	}
}


