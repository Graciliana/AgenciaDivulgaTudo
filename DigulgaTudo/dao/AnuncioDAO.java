import java.util.ArrayList;
import java.util.List;

public class AnuncioDAO {
	private static List<Anuncio> anuncios = new ArrayList<Anuncio>();
	public static void adicionar(Anuncio anuncio) {
		// TODO Auto-generated method stub
		anuncios.add(anuncio);
	}

	public static List<Anuncio> getAnuncios() {
		// TODO Auto-generated method stub
		return new ArrayList<Anuncio>(anuncios);
	}

}
