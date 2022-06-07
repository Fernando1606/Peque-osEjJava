
import java.util.*;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		//Declaraciones
		Scanner teclado=new Scanner(System.in);
		String s=new String();
		int opcionmenu;
		
		do {
		//Opciones
		System.out.println("Elige la opcion a realizar:");
		System.out.println("1.Introducir una cadena");
		System.out.println("2.Contar el numero de palabras");
		System.out.println("3.Contar el numero de vocales");
		System.out.println("4.Mostrar la longitud, la cadena completamente en mayusculas y en minusculas");
		System.out.println("5. Solicitar un caracter, indicar si esta contenido en la cadena y en ese caso, contar el numero de veces contenido");
		System.out.println("6.Introducir otra cadena y mostrar, si son iguales, si esta contenida y cual de ambas es anterior");
		System.out.println("7.Salir");
		opcionmenu=teclado.nextInt();
		
		//Menu de opciones
		switch(opcionmenu) {
		
		case 1:
			s=ej1();
			break;
			
		case 2:
			System.out.println("El numero de palabras introducidas es: " + ej2(s));
			break;
			
		case 3:
			System.out.println("El numero de vocales es: " + ej3(s));
			break;
		
		case 4:
			ej4(s);
			break;
		
		case 5:
			ej5(s,teclado);
			break;
		
		case 6:
			ej6(s);
			break;
			
		}
		}while(opcionmenu!=7);
	}
	
	//Apartado 1(Rellenar String)
	public static String ej1() {
		Scanner teclado=new Scanner(System.in);
		String s;
		System.out.println("Introduce lo que quieras");
		s=teclado.nextLine();
		return s;
	}
	
	//Apartado 2(Contar el numero de palabras)
	public static int ej2(String s) {
		int contadorpalabras=0;
		contadorpalabras=s.length(); //CIPOTE MIRAR TOR FALLACO
		return contadorpalabras;
	}
	
	//Apartado3(Contar las vocales)
	public static int ej3(String s) {
		int contadorvocales=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u') {
				contadorvocales++;
			}
		}
		return contadorvocales;
	}
	
	//Apartado4
	public static void ej4(String s) {
		//Tamaño
		System.out.println("El tamaño de la cadena es: " + s.length());
		//Mayusculas
		System.out.println("La cadena en mayusculas es: " + s.toUpperCase());
		//Minusculas
		System.out.println("La cadena en minusculas es: " + s.toLowerCase());
	}
	
	//Apartado5
	public static void ej5(String s,Scanner teclado) {
		//Pedir el caracter
		char[] cadenacaracteres=s.toCharArray();
		char caracter;
		int contadorpalabrasrepetidas=0;
		System.out.println("Dime el caracter que quieras buscar");
		caracter=teclado.next().charAt(0);
		
		//Buscar el caracter
		for(int i=0;i<cadenacaracteres.length;i++) {
			if(cadenacaracteres[i]==caracter) {
				contadorpalabrasrepetidas++;
			}
		}
		//Mostrar las repeticiones
		if (contadorpalabrasrepetidas>0) {
			System.out.println("Esta letra esta contenida " + contadorpalabrasrepetidas + " veces.");
		}else System.out.println("Letra no contenida");
	}
	
	//Apartado6
	
	public static void ej6(String s) {
		
		//Variables
		Scanner teclado=new Scanner(System.in);
		String t;
		int palabraigual = 0;
		int palabraigual2 = 0;
		int contadorespaciosenblanco=0;
		
		//Mete cadena 
		System.out.println("Introduce otra cadena");
		t=teclado.nextLine();
		
		//Comprobacion si son iguales
		char[]tperoenchararray=t.toCharArray();
		if(t.equals(s)) {
			System.out.println("Son iguales");
		}else System.out.println("No son iguales");
		
		//Comprabacion si esta contenia
		if (s.contains(t)) {
			System.out.println("Esta contenida");
			palabraigual=s.indexOf(t);
			palabraigual2=t.indexOf(s);
		}else System.out.println("No esta contenida");
		
		//Cosas de mayores que no funcionan #Matrimonios
		for(int i=0;i<palabraigual;i++) {
			if(tperoenchararray[i]==' ') {
				contadorespaciosenblanco++;
			}
		}
		char[]speroenchararray=s.toCharArray();
		int contadorespaciosenblanco2=0;
		for(int i=0;i<palabraigual2;i++) {
			if(speroenchararray[i]==' ') {
				contadorespaciosenblanco2++;
			}
		}
		
		if (contadorespaciosenblanco>contadorespaciosenblanco2) {
			System.out.println("La primera cadena es la mas mejor");
		}else System.out.println("La segunda cadena es la mas mejor");
		teclado.close();
		
	}
	
	
	

}
