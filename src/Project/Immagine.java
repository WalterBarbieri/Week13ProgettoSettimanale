package Project;

public class Immagine extends Multimediale implements Show, Luminosity {
	public Immagine(String titolo) {
		super(titolo);
	}

	@Override
	public void aumentaLuminosita() {
		luminosita += luminosita;

	}

	@Override
	public void diminuisciLuminosita() {
		luminosita -= luminosita;

	}

	@Override
	public void show() {
		String myImage = titolo;
		for (int i = 0; i < durata; i++) {
			myImage += "*";
		}
		System.out.println(myImage);
	}
}
