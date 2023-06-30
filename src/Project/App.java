package Project;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Multimediale[] myArray = new Multimediale[5];

		Scanner myScanner = new Scanner(System.in);

		for (int i = 0; i < myArray.length; i++) {
			System.out.println("Titolo oggetto multimediale");
			String titolo = myScanner.nextLine();

			System.out.println("Durata oggetto multimediale (inserire 0 per creare un immagine)");
			int durata = myScanner.nextInt();
			myScanner.nextLine();
			if (durata == 0) {
				myArray[i] = new Immagine(titolo);
			} else if (durata < 0 || durata > 20) {
				System.err.println("Il valore deve essere compreso tra 0 e 20");
				continue;
			} else {
				System.out.println("Vuoi creare un file audio o video? premi 1 per audio e 2 per video");
				int scegliMedia = myScanner.nextInt();
				myScanner.nextLine();
				switch (scegliMedia) {
				case 1:
					myArray[i] = new Audio(titolo, durata);
					break;
				case 2:
					myArray[i] = new Video(titolo, durata);
					break;
				default:
					System.err.println("Attenzione, inserire solamente valori 1 e 2");
					continue;
				}

			}
			System.out.println("Oggetto creato con successo!");
		}
		System.out.println("Array creato con Successo! Puoi procedere con la riproduzione dei file!");
		int scegliOggetto;
		do {
			System.out.println(
					"Seleziona l'oggetto da riprodurre (da 1 a 5). Premere 0 per interrompere la riproduzione");
			scegliOggetto = myScanner.nextInt();
			if (scegliOggetto < 0 || scegliOggetto > myArray.length) {
				System.err.println("Selezionare un numero compreso tra 1 e 5 per riprodurre un file, 0 per uscire");
				continue;
			} else if (scegliOggetto == 0) {
				System.out.println("Riproduzione interrotta");
				break;
			}

			Multimediale oggetto = myArray[scegliOggetto - 1];
			if (oggetto instanceof Video) {
				Video video = (Video) oggetto;
				video.play();
			} else if (oggetto instanceof Audio) {
				Audio audio = (Audio) oggetto;
				audio.play();
			} else if (oggetto instanceof Immagine) {
				Immagine immagine = (Immagine) oggetto;
				immagine.show();
			}
		} while (scegliOggetto != 0);

		myScanner.close();

	}

}
