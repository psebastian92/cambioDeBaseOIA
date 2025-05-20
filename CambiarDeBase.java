package cambiarDeBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CambiarDeBase {

	public static void cambiarBase(int numerosAPasar[], int base) {
		String[] numeroConvertido = new String[numerosAPasar.length];

		for (int num : numerosAPasar) {
			System.out.println("Numero a pasar: " + num);
		}

		// Este while pasa de base decimal a bases 2 a 10

		for (int i = 0; i < numerosAPasar.length; i++) {
			numeroConvertido[i] = "";

			int variableAuxiliar = numerosAPasar[i];
			while (variableAuxiliar > 0) {

				int resto = variableAuxiliar % base;

				numeroConvertido[i] = resto + numeroConvertido[i];

				variableAuxiliar /= base;

			}

		}

		System.err.println("-------------");

		// Mostrar en pantalla el numero convertido
		System.out.println("Numero de base " + base);

		for (int i = 0; i < numeroConvertido.length; i++) {
			System.out.println(numerosAPasar[i] + " → " + numeroConvertido[i]);

		}

	}

	public static int[] ingresarNumeros(int cantNumeros) {
		Scanner entrada = new Scanner(System.in);

		int[] numerosAPasar = new int[cantNumeros];

		for (int i = 0; i < numerosAPasar.length; i++) {
			System.out.println("Ingrese numero entre 1 y 100: ");

			do {
				numerosAPasar[i] = entrada.nextInt();
				if (numerosAPasar[i] < 1 || numerosAPasar[i] > 100) {
					System.err.println("Valor incorrecto. Ingresar nuevamente:");
				}
			} while (numerosAPasar[i] < 1 || numerosAPasar[i] > 100);
		}

		return numerosAPasar;
	}

	public static int ingresarBase() {
		Scanner entrada = new Scanner(System.in);
		int base;

		System.out.println("Ingrese el valor de la nueva base (entre 2 y 10)");
		do {
			base = entrada.nextInt();
			if (base < 2 || base > 10) {
				System.err.println("Valor incorrecto. Ingresar nuevamente:");
			}
		} while (base < 2 || base > 10);
		return base;
	}

	public static int limitarCantidadNumeros() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Cuantos numeros desea ingresar?");
		int cantNumeros = entrada.nextInt();

		return cantNumeros;
	}

	public static void main(String[] args) {

		int limite = limitarCantidadNumeros();
		int base = ingresarBase();
		int numerosAPasar[] = ingresarNumeros(limite);

		cambiarBase(numerosAPasar, base);

	}

}