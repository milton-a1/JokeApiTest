package vista;

import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import modelo.Chiste;

public class Main {

	public static void main(String[] args) {

		programaPracticar(obtenerChistes(), obtenerChiste());
	}

	public static List<Chiste> obtenerChistes() {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("https://official-joke-api.appspot.com").path("random_ten");

		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

		Response respuestaChistes = invocationBuilder.get();

		List<Chiste> listaChistes = respuestaChistes.readEntity(new GenericType<List<Chiste>>() {
		});

		return listaChistes;
	}

	public static Chiste obtenerChiste() {
		Client client1 = ClientBuilder.newClient();

		WebTarget target1 = client1.target("https://official-joke-api.appspot.com").path("random_joke");

		Invocation.Builder invocationBuilder1 = target1.request(MediaType.APPLICATION_JSON);

		Response respuestaChistes1 = invocationBuilder1.get();

		Chiste chisteSolo = respuestaChistes1.readEntity(new GenericType<Chiste>() {
		});
		return chisteSolo;
	}

	public static void programaPracticar(List<Chiste> listaChistes, Chiste chisteSolo) {
		Scanner sc = new Scanner(System.in);

		int option = 0;

		do {
			System.out.println(
					"Welcome to practice program. \nOptions:\n1 - One random joke.\n2- 10 random jokes\n3 - exit program");
			option = sc.nextInt();

			switch (option) {
			case 1:
				// option 1 - get a single random joke
				System.out.println("\n" + chisteSolo.getSetup());
				System.out.println(chisteSolo.getPunchline() + "\n");

				break;
			case 2:
				// option 2 - get ten jokes to practice.
//				System.out.println("\n");
				for (int i = 0; i < listaChistes.size(); i++) {

					System.out.println("Joke number " + (i + 1) + ":");
					System.out.println(listaChistes.get(i).getSetup());
					System.out.println(listaChistes.get(i).getPunchline());
					System.out.println("\n");

				}

				break;
			case 3:
				System.out.println("Closing program.");
				break;
			default:

				break;
			}
		} while (option != 3);

	}

}
