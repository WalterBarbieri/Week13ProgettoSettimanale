package Project;

public class Audio extends Multimediale implements Play {
	public Audio(String titolo, int durata) {
		super(titolo, durata);

	}

	@Override
	public void play() {
		for (int i = 0; i < durata; i++) {
			String mySong = titolo;
			for (int j = 0; j < volume; j++) {
				mySong += "!";
			}
			System.out.println(mySong);
		}
	}

	@Override
	public void alzaVolume() {
		volume += volume;

	}

	@Override
	public void abbassaVolume() {
		volume -= volume;

	}
}
