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
		volume += volume;
	};

	public void abbassaVolume() {
		volume -= volume;
	};

	public void aumentaLuminosita() {
		luminosita += luminosita;
	};

	public void diminuisciLuminosita() {
		luminosita -= luminosita;
	};
}
