import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AnuncioBO {
	public static void cadastrarAnuncio(String nome, String cliente, Date dataInicio, Date dataTermino, Double investimentoPorDia) {	
		Anuncio anuncio = new Anuncio(nome, cliente, dataInicio, dataTermino, investimentoPorDia);
		AnuncioDAO.adicionar(anuncio);
	}
	
	public static Date formatoDataAnuncio(String dataAnuncio) throws ParseException {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		return data.parse(dataAnuncio);
	}
	
	public static List<Anuncio> listaAnuncios() {
		return AnuncioDAO.getAnuncios();
	}
}
