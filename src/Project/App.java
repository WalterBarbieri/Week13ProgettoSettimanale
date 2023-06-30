package Project;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		// Funzione per popolare l'array

		Multimediale[] myArray = new Multimediale[5];

		Scanner myScanner = new Scanner(System.in);

		for (int i = 0; i < myArray.length; i++) {
			System.out.println("Titolo oggetto multimediale");
			String titolo = myScanner.nextLine();

			int durata;

			// Controllo sull'input
			while (true) {
				System.out.println("Durata oggetto multimediale (inserire 0 per creare un immagine)");
				if (myScanner.hasNextInt()) {
					durata = myScanner.nextInt();
					if (durata >= 0 && durata <= 20) {
						myScanner.nextLine();
						break;
					} else {
						System.err.println("Input invalido, inserire un numero intero compreso tra 0 e 20");
						myScanner.nextLine();
					}

				} else {
					System.err.println("Input invalido, inserire un numero intero compreso tra 0 e 20");
					myScanner.nextLine();
				}
			}

			if (durata == 0) {
				myArray[i] = new Immagine(titolo);
			} else {
				audioOrVideo: while (true) {
					System.out.println("Vuoi creare un file audio o video? premi 1 per audio e 2 per video");
					if (myScanner.hasNextInt()) {
						int scegliMedia = myScanner.nextInt();
						myScanner.nextLine();
						switch (scegliMedia) {
						case 1:
							myArray[i] = new Audio(titolo, durata);
							break audioOrVideo;
						case 2:
							myArray[i] = new Video(titolo, durata);
							break audioOrVideo;
						default:
							System.err.println("Attenzione, inserire solamente i valori 1 e 2");
							continue audioOrVideo;
						}
					} else {
						System.err.println("Attenzione, inserire solamente i valori 1 e 2");
						myScanner.nextLine();
					}
				}

			}
			System.out.println("Oggetto creato con successo!");
		}
		System.out.println("Array creato con Successo! Puoi procedere con la riproduzione dei file!");

		// Funzione per la riproduzione e controllo volume e luminosità degli oggetti

		int scegliOggetto;
		do {
			System.out.println(
					"Seleziona l'oggetto da riprodurre (da 1 a 5). Premere 0 per interrompere la riproduzione");
			while (!myScanner.hasNextInt()) {
				System.err.println("Inserire un numero intero compreso tra 0 e 5");
				myScanner.next();
			}
			scegliOggetto = myScanner.nextInt();
			if (scegliOggetto < 0 || scegliOggetto > myArray.length) {
				System.err.println("Selezionare un numero compreso tra 1 e 5 per riprodurre un file, 0 per uscire");
				continue;
			} else if (scegliOggetto == 0) {
				System.out.println("Riproduzione interrotta");
				break;
			}
			myScanner.nextLine();
			Multimediale oggetto = myArray[scegliOggetto - 1];
			if (oggetto instanceof Video) {
				Video video = (Video) oggetto;
				video.play();
				volumeControl: while (true) {
					System.out.println(
							"Vuoi aumentare il volume? Per aumentare il volume premere +; per diminuire il volume premere -; premere qualsiasi altro tasto per proseguire.");
					String myVolume = myScanner.nextLine();

					if (myVolume.equals("+")) {
						video.alzaVolume();
						System.out.println("Volume: " + video.volume);
						continue volumeControl;
					} else if (myVolume.equals("-")) {
						video.abbassaVolume();
						System.out.println("Volume: " + video.volume);
						continue volumeControl;
					} else {
						break;
					}
				}

				luminosityControl: while (true) {
					System.out.println(
							"Vuoi aumentare la luminosità? Per aumentare la luminosità premere +; per diminuire la luminosità premere -");
					String myLuminosity = myScanner.nextLine();

					if (myLuminosity.equals("+")) {
						video.aumentaLuminosita();
						System.out.println("Luminosità: " + video.luminosita);
						continue luminosityControl;
					} else if (myLuminosity.equals("-")) {
						video.diminuisciLuminosita();
						System.out.println("Luminosità: " + video.luminosita);
						continue luminosityControl;
					} else {
						break;
					}
				}
				video.play();

			} else if (oggetto instanceof Audio) {
				Audio audio = (Audio) oggetto;
				audio.play();

				volumeControl: while (true) {
					System.out.println(
							"Vuoi aumentare il volume? Per aumentare il volume premere +; per diminuire il volume premere -; premere qualsiasi altro tasto per proseguire.");
					String myVolume = myScanner.nextLine();

					if (myVolume.equals("+")) {
						audio.alzaVolume();
						System.out.println("Volume: " + audio.volume);
						continue volumeControl;
					} else if (myVolume.equals("-")) {
						audio.abbassaVolume();
						System.out.println("Volume: " + audio.volume);
						continue volumeControl;
					} else {
						break;
					}
				}

				audio.play();
			} else if (oggetto instanceof Immagine) {
				Immagine immagine = (Immagine) oggetto;
				immagine.show();
				luminosityControl: while (true) {
					System.out.println(
							"Vuoi aumentare la luminosità? Per aumentare la luminosità premere +; per diminuire la luminosità premere -");
					String myLuminosity = myScanner.nextLine();

					if (myLuminosity.equals("+")) {
						immagine.aumentaLuminosita();
						System.out.println("Luminosità: " + immagine.luminosita);
						continue luminosityControl;
					} else if (myLuminosity.equals("-")) {
						immagine.diminuisciLuminosita();
						System.out.println("Luminosità: " + immagine.luminosita);
						continue luminosityControl;
					} else {
						break;
					}
				}
				immagine.show();
			}
		} while (scegliOggetto != 0);

		myScanner.close();

	}

}
