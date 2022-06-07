import java.util.ArrayList;
import java.util.Scanner;

public class LOTERIA {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		ArrayList<Integer> numeroseuromillon = new ArrayList<Integer>();
		ArrayList<Integer> estrellas = new ArrayList<Integer>();
		double dinerointroducido = 0;
		int numeroloteria;
		// Meter dinero

		System.out.println("Inserte el dinero que desea jugar.");
		dinerointroducido = teclado.nextDouble();

		do {

			numeroseuromillon.clear();
			estrellas.clear();
			if (dinerointroducido < 3) {
				System.out.println("Dinero inferior a la cuantia minima para el juego");
				System.exit(0);
			} else {
				// Elegir a que juego quiere jugar

				System.out.println("1.Loteria		2.Euromillones		3.Salir");
				int opcion = teclado.nextInt();

				// Menu de las dos opciones

				switch (opcion) {

				case 1:
					numeroloteria = loteria(teclado);

					// Metodo de comprobacion del premio de la loteria

					premioloteria(numeroloteria);
					dinerointroducido -= 3;
					break;

				case 2:
					euromillones(teclado, numeroseuromillon, estrellas);

					// Metodo de comprobacion del premio del euromillon

					premioeuromillon(numeroseuromillon, estrellas);
					dinerointroducido -= 2.5;
					break;

				case 3:
					System.out.println("Saliendo");
					System.exit(3);

				default:
					System.out.println("Opcion erronea");
				}
			}
		} while (dinerointroducido >= 0);

	}

	// Metodo loteria

	public static int loteria(Scanner teclado) {

		int boletoloteria = 0;

		// Comprobante de manera de juego

		System.out.println("Como desea jugar, de manera automatica o de manera manual?");
		String opcionjuego = teclado.next();

		// Pasar a mayusculas para que no exista error

		String opcionjuegomayusculas = opcionjuego.toUpperCase();

		// Menu de opciones de juego en loteria

		switch (opcionjuegomayusculas) {

		case "AUTOMATICA":

			// Generacion de numero aleatorio

			int numeroaleatorio = (int) (Math.random() * 99999);
			System.out.println(numeroaleatorio);
			boletoloteria = numeroaleatorio;
			break;

		case "MANUAL":

			// Bucle para meter boleto correcto

			int loteriamanual = 0;
			do {
				System.out.println("Dime los numeros que quieres tener en tu boleto");
				loteriamanual = teclado.nextInt();
			} while (loteriamanual > 100000);

			boletoloteria = loteriamanual;
			break;

		// Metodo default

		default:
			System.out.println("Error");
			System.exit(0);
			break;
		}

		return boletoloteria;
	}

	// Metodo euromillones

	public static void euromillones(Scanner teclado, ArrayList<Integer> numeroseuromillon,
			ArrayList<Integer> estrellas) {
		String opcioneuromillon;
		int numero, estrella;

		// Comprobacion manual o automatica

		System.out.println("Quieres jugar de manera manual o automatica?");
		opcioneuromillon = teclado.next();

		// Pasar a mayusculas para que no exista error

		String opcioneuromillonmayusculas = opcioneuromillon.toUpperCase();

		// Menu de las dos opciones

		switch (opcioneuromillonmayusculas) {

		case "MANUAL":

			// Relleno de la primera parte del euromillon

			// Repeticion hasta tener los 5 numeros

			while (numeroseuromillon.size() <= 4) {
				System.out.println("");
				System.out.println("Dime el numero");
				numero = teclado.nextInt();
				// Comprobacion del rango

				if (numero >= 1 && numero <= 49) {

					// Ahora se comprueba que no se repita

					if (numeroseuromillon.contains(numero)) {
						System.out.println("Numero ya apostado. Elejir otro");
					} else {
						numeroseuromillon.add(numero);
					}
					System.out.println("");
					System.out.println("Numeros apostados");
					for (int i = 0; i <= numeroseuromillon.size(); i++) {
						System.out.println(numeroseuromillon + " ");
					}
				} else {
					System.out.println("Apuesta no valida");

					// Fin de pedir numeros manualmente
				}
			}

			// Ahora vamos a pedir las estrellas

			while (estrellas.size() < 2) {

				// Metemos la estrella

				System.out.println("");
				System.out.println("Elija un numero entre 1 y 9");
				estrella = teclado.nextInt();

				// Comprobacion de numero mayor que 1 y menor que 9 para añadirla o no y si esta
				// ya contenido

				if (estrella >= 1 && estrella <= 9) {
					if (estrellas.contains(estrella)) {
						System.out.println("Estrella ya introducida");
					} else {
						estrellas.add(estrella);
						System.out.print("Estrellas apostadas");

					}
				} else {
					System.out.println("Estrella no valida. Elije otra.");
				}
				for (int i = 0; i <= estrellas.size(); i++) {
					System.out.println(estrellas);
				}

				// Fin del while de estrellas

			}
			break;
		case "AUTOMATICA":

			// Generacion de numeros automatica * 5
			System.out.println("Te vamos a generar los numeros automaticamente");
			int c = 4;
			int aux;
			while (c >= 0) {

				aux = ((int) (49 * Math.random()) + 1);

				if (!(numeroseuromillon.contains(aux))) {
					numeroseuromillon.add(aux);
					c--;
				}
			}

			// Generacion estrellas automaticas *2
			int aux3;
			int c1 = 1;
			while (c1 >= 0) {
				aux3 = ((int) (9 * Math.random()) + 1);
				if (!(estrellas.contains(aux3))) {
					estrellas.add(aux3);
					c1--;
				}
			}
			break;

		default:
			System.out.println("Error");
			System.exit(0);
		}
	}

	// Metodo premio de loteria

	public static void premioloteria(int numeroloteria) {

		// Vamos a generar el numero aleatorio para realizar la comprobacion de los
		// premios

		int c = 0;
		int numlotganador = (int) (Math.random() * 99999);

		if (numlotganador == numeroloteria) {
			System.out.println("Su premio es de 30000€, FELICIDADES!!");
		} else {
			if ((numeroloteria + 1) == numlotganador || (numeroloteria - 1) == numlotganador) {
				System.out.println("Su premio es de 1200€, FELICIDADES!!");
			} else {

				// Comprobar N posiciones del String
				String comprueba3premio = Integer.toString(numeroloteria);
				String comprueba3premioganador = Integer.toString(numlotganador);

				for (int i = 0; i <= 4; i++) {
					if (comprueba3premio.charAt(i) == comprueba3premioganador.charAt(i)) {
						c++;
					}
				}

				// Comprobador premios segun contador

				if (c == 4) {
					System.out.println("Su premio es de 75€");
				} else if (c == 3) {
					System.out.println("Su premio es de 15€");
				} else if (c == 2) {
					System.out.println("Su premio es de 6€");
				} else
					System.out.println("Numero no acertado ya que su numero es el " + numeroloteria
							+ " y el numero premiado es el " + numlotganador);
			}
		}
	}

	// Metodo premio euromillon

	@SuppressWarnings("unlikely-arg-type")
	public static void premioeuromillon(ArrayList<Integer> numeroseuromillon, ArrayList<Integer> estrellas) {

		ArrayList<Integer> numeuromganador = new ArrayList<Integer>();
		ArrayList<Integer> estrellasganadoras = new ArrayList<Integer>();
		int xnumganador;
		@SuppressWarnings("unused")
		boolean check = false;
		int contador = 5;

		// Generamos el numero del boleto ganador del euromillon y las estrellas

		do {
			xnumganador = ((int) (49 * Math.random()) + 1);
			if (!(numeuromganador.contains(xnumganador))) {
				numeuromganador.add(xnumganador);
				contador--;
			}

		} while (contador > 0);

		int esteuromllonganador1 = ((int) (9 * Math.random()) + 1);
		int esteuromllonganador2;
		// Vamos a generar un bucle para que el numero que sea de la segunda estrella
		// sea diferente al primero

		do {

			esteuromllonganador2 = ((int) (9 * Math.random()) + 1);
			if (esteuromllonganador1 != esteuromllonganador2) {
				check = true;
			}
		} while (check = false);

		estrellasganadoras.add(esteuromllonganador1);
		estrellasganadoras.add(esteuromllonganador2);

		// Ahora realizamos las comprobaciones

		if (numeroseuromillon == numeuromganador && estrellas == estrellasganadoras) {
			System.out.println("Felicidades, su premio es de " + ((int) (900 + Math.random()) * 75) + " M€.");
		} else if (numeroseuromillon == numeuromganador && estrellas.contains(estrellasganadoras)) {
			System.out.println("Felicidades, su premio es de " + ((int) (2000000 + Math.random()) * 600000) + " €.");
		}

		// Ahora necesitamos recorrer las listas para hacer las comprobaciones de los
		// siguientes premios y lo pasamos a string para ello

		int c1 = 0;
		int c2 = 0;

		for (int i = 0; i <= 4; i++) {
			if (numeuromganador.contains(numeroseuromillon)) {
				c1++;
			}
		}

		// Ahora hacemos otro bucle para comprobar las estrellas

		for (int j = 0; j <= 2; j++) {
			if (estrellasganadoras.contains(estrellas)) {
				c2++;
			}
		}

		if (c1 == 5 && c2 == 0) {
			System.out.println("Su premio es de " + ((int) (120000 + Math.random()) * 80000) + " €.");
		} else if (c1 == 4 && c2 == 2) {
			System.out.println("Su premio es de " + ((int) (6000 + Math.random()) * 750) + " €.");
		} else if (c1 == 4 && c2 == 1) {
			System.out.println("Su premio es de " + ((int) (600 + Math.random()) * 90) + " €.");
		} else if (c1 == 4 && c2 == 0) {
			System.out.println("Su premio es de " + ((int) (60 + Math.random()) * 20) + " €.");
		} else if (c1 == 3 && c2 == 2) {
			System.out.println("Su premio es de " + ((int) (80 + Math.random()) * 30) + " €.");
		} else if (c1 == 3 && c2 == 1) {
			System.out.println("Su premio es de  " + ((int) (15 + Math.random()) * 8) + " €.");
		} else if (c1 == 2 && c2 == 2) {
			System.out.println("Su premio es de " + ((int) (20 + Math.random()) * 10) + " €.");
		} else if (c1 == 2 && c2 == 1) {
			System.out.println("Su premio es de " + ((int) (7 + Math.random()) * 4) + " €.");
		} else if (c1 == 2 && c2 == 0) {
			System.out.println("Su premio es de " + ((int) (6 + Math.random()) * 1) + " €.");
		} else
			System.out.println("Numero no premiado ya que sus numeros eran " + numeroseuromillon + " - " + estrellas
					+ " y los numeros premiados eran " + numeuromganador + " - " + estrellasganadoras);
	}
}
