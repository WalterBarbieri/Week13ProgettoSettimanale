package Project;

public abstract class Multimediale {
	String titolo;
	int durata;
	int volume;
	int luminosita;

	public Multimediale(String titolo, int durata) {
		this.titolo = titolo;
		this.durata = durata;
		volume = 5;
		luminosita = 5;
	}

	public Multimediale(String titolo) {
		this.titolo = titolo;
		luminosita = 5;

	}

}
