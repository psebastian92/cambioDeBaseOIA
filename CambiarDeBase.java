package cambiarDeBase;

import java.util.Scanner;

public class CambiarDeBase {

	// Método principal para convertir números desde base 10 a otra base entre 2 y 10
	public static void cambiarBase(int numerosAPasar[], int base) {
		// Creamos un arreglo de Strings para guardar los números convertidos
		String[] numeroConvertido = new String[numerosAPasar.length];

		// Mostramos los números ingresados, antes de convertir
		for (int num : numerosAPasar) {
			System.out.println("Numero a pasar: " + num);
		}

		// Recorremos cada número para convertirlo a la nueva base
		for (int i = 0; i < numerosAPasar.length; i++) {
			// Inicializamos cada string vacío antes de empezar a construirlo
			numeroConvertido[i] = "";

			// Usamos una variable auxiliar para no modificar el número original
			int variableAuxiliar = numerosAPasar[i];

			// Mientras la variable sea mayor a 0, seguimos dividiendo y tomando el resto
			while (variableAuxiliar > 0) {
				int resto = variableAuxiliar % base; // Obtenemos el resto
				// Agregamos el resto al principio del número convertido
				numeroConvertido[i] = resto + numeroConvertido[i];
				variableAuxiliar /= base; // Dividimos el número por la base
			}
		}

		// Separador visual
		System.err.println("-------------");

		// Mostramos el resultado final: número original → número convertido
		System.out.println("Numero de base " + base);
		for (int i = 0; i < numeroConvertido.length; i++) {
			System.out.println(numerosAPasar[i] + " → " + numeroConvertido[i]);
		}
	}

	// Método para pedir y validar la cantidad de números que el usuario quiere convertir
	public static int limitarCantidadNumeros() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Cuantos numeros desea ingresar?");
		int cantNumeros = entrada.nextInt(); // Leemos cantidad
		return cantNumeros;
	}

	// Método para pedir una base válida entre 2 y 10
	public static int ingresarBase() {
		Scanner entrada = new Scanner(System.in);
		int base;

		System.out.println("Ingrese el valor de la nueva base (entre 2 y 10)");

		// Repetimos hasta que el usuario ingrese una base válida
		do {
			base = entrada.nextInt();
			if (base < 2 || base > 10) {
				System.err.println("Valor incorrecto. Ingresar nuevamente:");
			}
		} while (base < 2 || base > 10);

		return base;
	}

	// Método para ingresar cada número (entre 1 y 100), con validación
	public static int[] ingresarNumeros(int cantNumeros) {
		Scanner entrada = new Scanner(System.in);
		int[] numerosAPasar = new int[cantNumeros];

		// Pedimos un número por vez
		for (int i = 0; i < numerosAPasar.length; i++) {
			System.out.println("Ingrese numero entre 1 y 100:");

			// Validamos que esté dentro del rango pedido
			do {
				numerosAPasar[i] = entrada.nextInt();
				if (numerosAPasar[i] < 1 || numerosAPasar[i] > 100) {
					System.err.println("Valor incorrecto. Ingresar nuevamente:");
				}
			} while (numerosAPasar[i] < 1 || numerosAPasar[i] > 100);
		}

		return numerosAPasar;
	}

	// Método principal: organiza el orden de ejecución del programa
	public static void main(String[] args) {
		// Primero pedimos cuántos números se van a convertir
		int limite = limitarCantidadNumeros();

		// Luego pedimos la base deseada
		int base = ingresarBase();

		// Luego pedimos los números uno por uno
		int numerosAPasar[] = ingresarNumeros(limite);

		// Finalmente realizamos la conversión y mostramos el resultado
		cambiarBase(numerosAPasar, base);
	}
}
