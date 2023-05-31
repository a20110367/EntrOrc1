package nom;

import java.util.Random;
import java.util.Arrays;

public class Prueba5 {
	public static void main(String[] args) {

		int cantidad = 10;
		int[] numeros = generarEnteros(cantidad);
		//int[] numeros = new int[] { 13, 19, 0, 12, 17, 15, 9, 7, 4, 14 };
		//int[] numeros = new int[] { 14, 15, 12, 18, 15, 0, 6, 8, 17, 18 };
		//int[] numeros = new int[] {11, 19, 19, 11, 3, 17, 17, 4, 18, 11};
		int[] resultados = mejorCompra(numeros);
		int[] resultados1 = mejorCompra5(numeros);
		System.out.println("\n");
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

	public static int[] mejorCompra5(int[] precios) {
		int iMinimo = 0;
		int iMaximo = precios.length - 1;
		int flag = 0;
		int[] resultados = new int[2];
		resultados[0] = iMinimo;
		resultados[1] = iMaximo;

		for (int i = 1; i < precios.length; i++) {
			if (flag == 0) {

				if (precios[i] >= precios[resultados[1]])
					resultados[1] = i;
				
				if (precios[i] < precios[resultados[0]]) {
					iMinimo = i;
					flag=1;
				}

			} else {
				if (precios[i] <= precios[iMinimo])
					iMinimo = i;
				
				if (precios[i] >= precios[iMinimo]) {
					iMaximo=i;
					if(precios[resultados[1]]- precios[resultados[0]]<=precios[iMaximo]-precios[iMinimo]) {
						resultados[0]=iMinimo;
						resultados[1]=iMaximo;
						flag=0;
					}
	
				}
			}
		}

		return resultados;

	}

}
