package nom;

import java.util.Random;
import java.util.Arrays;

public class prueba4 {
	public static void main(String[] args) {

		int cantidad = 10;
		int[] numeros = generarEnteros(cantidad);
		//int[] numeros = new int[] { 13, 19, 0, 12, 17, 15, 9, 7, 4, 14 };
		//int[] numeros = new int[] { 14, 15, 12, 18, 15, 0, 6, 8, 17, 18 };
		int[] resultados = mejorCompra(numeros);
		int[] resultados1 = mejorCompra4(numeros);
		System.out.println("\n\n");
		System.out.println(Arrays.toString(resultados));
		System.out.println(Arrays.toString(resultados1));
		if (numeros[resultados[1]] - numeros[resultados[0]] == numeros[resultados1[1]] - numeros[resultados1[0]])
			System.out.println("Success");
		else
			System.out.println("Failed");

	}

	public static int[] mejorCompra(int[] precios) {

		int iCompra = 0;
		int iVenta = 1;
		int pivote = 0;
		int[] resultados = new int[2];
		int gananciaMaxima = precios[1] - precios[0];
		while (pivote < precios.length) {
			for (int i = pivote + 1; i < precios.length; i++) {
				if (precios[i] - precios[pivote] > gananciaMaxima) {
					gananciaMaxima = precios[i] - precios[pivote];
					iCompra = pivote;
					iVenta = i;
					System.out.println(gananciaMaxima);
				}

			}

			pivote++;
		}
		System.out.println(Arrays.toString(precios));
		System.out.println(iCompra + "  " + iVenta);
		System.out.println(precios[iCompra] + "  " + precios[iVenta]);
		resultados[0] = iCompra;
		resultados[1] = iVenta;
		return resultados;

	}

	public static int[] generarEnteros(int cantidad) {
		int[] numeros = new int[cantidad];
		Random random = new Random();
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = random.nextInt(20);
		}

		return numeros;

	}

	public static int[] mejorCompra4(int[] precios) {
		System.out.println("\ninicia metodo 4");
		int iMinimo = -1;
		int iMaximo = -1;
		int iMinimoNuevo = -1;
		int iMaximoNuevo = -1;
		int pivote = 0;
		int[] resultados = new int[2];
		System.out.println("Inicio Base");
		while (pivote < precios.length && iMinimo == -1) {
			if (precios[pivote + 1] <= precios[pivote])
				pivote++;
			else {
				iMinimo = pivote;
				pivote++;
				break;
			}
		}

		while (pivote < precios.length && iMaximo == -1) {
			if (precios[pivote + 1] >= precios[pivote])
				pivote++;
			else {
				iMaximo = pivote;
				pivote++;
				break;
			}
		}
		System.out.println("Fin Base");

		System.out.println(iMinimo + "  " + iMaximo + "\n");

		while (pivote < precios.length) {
			System.out.println("Inicio ciclo");
			System.out.println(iMinimo + "  " + iMaximo);
			System.out.println("pivote " + pivote);
			if (precios[pivote] <= precios[iMinimo]) {
				if (iMinimoNuevo == -1) {
					iMinimoNuevo = pivote;
					System.out.println("iMinimoNuevo " + iMinimoNuevo);
					pivote++;
					continue;
				} else {
					if (precios[pivote] <= precios[iMinimoNuevo]) {
						iMinimoNuevo = pivote;
						pivote++;
						continue;
					}
				}
			}

			if (iMinimoNuevo == -1) {
				if (precios[pivote] >= precios[iMaximo]) {
					iMaximo = pivote;
					System.out.println("Maximo " + iMaximo);
					pivote++;
				} else
					pivote++;

			} else {
				if (precios[pivote] >= precios[iMinimoNuevo]) {
					iMaximoNuevo = pivote;
					System.out.println("iMaximoNuevo " + iMaximoNuevo);
					pivote++;
				} else
					pivote++;
			}

			// Analisis si hay candidatos

			if (iMaximoNuevo != -1 && iMinimoNuevo != -1) {
				System.out.println("Actuales");
				System.out.println(iMinimo + "  " + iMaximo);
				System.out.println("Candidatos");
				System.out.println(iMinimoNuevo + "  " + iMaximoNuevo);
				if (precios[iMaximoNuevo] >= precios[iMaximo]) {
					iMaximo = iMaximoNuevo;
					iMinimo = iMinimoNuevo;
					iMaximoNuevo = -1;
					iMinimoNuevo = -1;

				} else {
					if (precios[iMaximoNuevo] - precios[iMinimoNuevo] >= precios[iMaximo] - precios[iMinimo]) {
						iMaximo = iMaximoNuevo;
						iMinimo = iMinimoNuevo;
						iMaximoNuevo = -1;
						iMinimoNuevo = -1;
					} else {
						iMaximoNuevo = -1;

					}
				}

			}

		}
		resultados[0] = iMinimo;
		resultados[1] = iMaximo;

		return resultados;

	}

}
