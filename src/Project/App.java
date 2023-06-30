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
		myScanner.close();

	}

}
