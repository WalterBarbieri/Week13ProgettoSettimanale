package Project;

public class Immagine extends Multimediale implements Show, Luminosity {
	public Immagine(String titolo) {
		super(titolo);
	}

	@Override
	public void aumentaLuminosita() {
		if (luminosita < 10) {
			luminosita++;
		}

	}

	@Override
	public void diminuisciLuminosita() {
		if (luminosita > 0) {
			luminosita--;
		}

	}

	@Override
	public void show() {
		String myImage = titolo;
		for (int i = 0; i < luminosita; i++) {
			myImage += "*";
		}
		System.out.println(myImage);
	}
}
