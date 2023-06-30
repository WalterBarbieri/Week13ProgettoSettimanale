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

	}
}
