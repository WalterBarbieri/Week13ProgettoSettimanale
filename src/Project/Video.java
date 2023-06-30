package Project;

public class Video extends Multimediale implements Play, Luminosity {

	public Video(String titolo, int durata) {
		super(titolo, durata);
	}

	public void play() {
		for (int i = 0; i < durata; i++) {
			String myVideo = titolo;
			for (int j = 0; j < volume; j++) {
				myVideo += "!";

			}
			for (int z = 0; z < luminosita; z++) {
				myVideo += "*";
			}
			System.out.println(myVideo);
		}
	};

	public void alzaVolume() {
		if (volume < 10) {
			volume++;
		}
	};

	public void abbassaVolume() {
		if (volume > 0) {
			volume--;
		}
	};

	public void aumentaLuminosita() {
		if (luminosita < 10) {
			luminosita++;
		}

	};

	public void diminuisciLuminosita() {
		if (luminosita > 0) {
			luminosita--;
		}

	};
}
