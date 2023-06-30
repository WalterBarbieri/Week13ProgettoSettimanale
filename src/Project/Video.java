package Project;

public class Video extends Multimediale implements Play, Luminosity {

	public Video(String titolo, int durata) {
		super(titolo, durata);
	}

	public void play() {
		for (int i = 0; i < durata; i++) {
			String mySong = titolo;
			for (int j = 0; j < volume; j++) {
				mySong += "!";
				for (int z = 0; z < luminosita; z++) {
					mySong += "*";
				}
			}
			System.out.println(mySong);
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
