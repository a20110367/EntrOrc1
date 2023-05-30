package nom;


import java.util.Random;
import java.util.Arrays;

public class Pruebas2 {

	public static void main(String[] args) {
		
		int cantidad = 30;
		int[] numeros = generarEnteros(cantidad);
		int[] resultados = mejorCompra3(numeros);
		System.out.println(Arrays.toString(resultados));

	}

	
	public static int[] generarEnteros(int cantidad) {
		int[] numeros = new int[cantidad];
		Random random = new Random();
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = random.nextInt(100);
		}

		return numeros;

	}

	
	public static int[] mejorCompra3(int[] precios) {
		System.out.println("\n \n inicia metodo tres");
		int maximo = precios[0];
		int minimo = precios[0];
		int iMaximo = 0;
		int iMinimo = 0;
		int iCompra1 = -1;
		int iVenta1 = -1;
		int iCompra2 = -1;
		int iVenta2 = -1;
		int iCompra3 = -1;
		int iVenta3 = -1;
		int iCompraFinal = 0;
		int iVentaFinal = 0;
		int [] resultados= new int[2]; 
		int ganancia1, ganancia2, ganancia3, gananciaMaxima;
		ganancia1 = ganancia2 = ganancia3 = gananciaMaxima = 0;

		// int gananciaMaxima=precios[1]-precios[0];
		// Buscar Maximo y Minimo
		for (int i = 0; i < precios.length; i++) {
			if (precios[i] >= maximo) {
				maximo = precios[i];
				iMaximo = i;
			}
			if (precios[i] <= minimo) {
				minimo = precios[i];
				iMinimo = i;
			}
		}
		// Caso ideal, el indice del Mimino Absoluto es menos al indice del Maximo
		// Absoluto
		if (iMinimo < iMaximo) {
			iCompraFinal = iMinimo;
			iVentaFinal = iMaximo;
			gananciaMaxima=precios[iVentaFinal]-precios[iCompraFinal];

			// Caso extremo, el indice del Maximo Absoluto es una unidad menos que el indice
			// del minimo absoluto

		} else if (iMinimo - iMaximo == 1) {
			iVenta1 = iMaximo;
			int minimoIzquierdo = precios[iMaximo];
			for (int i = 0; i < iMaximo; i++) {
				if (precios[i] < minimoIzquierdo) {
					minimoIzquierdo = precios[i];
					iCompra1 = i;
				}
			}
			iCompra3 = iMinimo;
			int maximoDerecho = precios[iMinimo];
			for (int j = iMinimo+1; j < precios.length; j++) {
				if (precios[j] > maximoDerecho) {
					maximoDerecho = precios[j];
					iVenta3 = j;
				}
			}

			if (iVenta1 - iCompra1 > iVenta3 - iCompra3) {
				iVentaFinal = iVenta1;
				iCompraFinal = iCompra1;
				gananciaMaxima=precios[iVentaFinal]-precios[iCompraFinal];
			} else {
				iVentaFinal = iVenta3;
				iCompraFinal = iCompra3;
				gananciaMaxima=precios[iVentaFinal]-precios[iCompraFinal];
			}

			// Caso normal no ideal, el indice del Maximo Absoluto es menor al indice del
			// minimo absoluto por más de una unidad
			// En este caso el arreglo presenta 3 segmentos, uno que contiene el maximo
			// absoluto, otro que contiene el minimo absoluto y
			// el espacio ente ambos indices que se analiza de manera independiente
		} else {

			iCompra1 = 0;
			iVenta1 = iMaximo;
			int minimoIzquierdo = precios[iMaximo];
			for (int i = 0; i < iMaximo; i++) {
				if (precios[i] < minimoIzquierdo) {
					minimoIzquierdo = precios[i];
					iCompra1 = i;
				}
			}
			ganancia1 = precios[iVenta1] - precios[iCompra1];

			iCompra3 = iMinimo;
			iVenta3 = precios.length - 1;
			int maximoDerecho = precios[iMinimo];
			for (int j = iMinimo; j < precios.length; j++) {
				if (precios[j] > maximoDerecho) {
					maximoDerecho = precios[j];
					iVenta3 = j;
				}
			}
			ganancia3 = precios[iVenta3] - precios[iCompra3];

		
			iCompra2=iMaximo+1;
			iVenta2=iMinimo-1;

			ganancia2 = precios[iVenta2]-precios[iCompra2];
			for (int k = iMaximo + 1; k < iMinimo; k++) {
				if (precios[k + 1] - precios[k] > ganancia2) {
					ganancia2 = precios[k + 1] - precios[k];
					iCompra2 = k;
					iVenta2 = k + 1;
				}

			}
			
			for (int l = iCompra2; l > iMaximo; l--) {
				if (precios[l] < precios[iCompra2]) {
					iCompra2 = l;
				}
			}
			for (int l = iVenta2; l < iMinimo; l++) {
				if (precios[l] > precios[iVenta2])
					iVenta2 = l;
			}
			
			for (int l = iCompra2; l < iVenta2; l++) {
				if (precios[l] < precios[iCompra2]) {
					iCompra2 = l;
				}
			}

			ganancia2 = precios[iVenta2] - precios[iCompra2];

			if (ganancia1 >= ganancia2 && ganancia1 >= ganancia3) {
				iVentaFinal = iVenta1;
				iCompraFinal = iCompra1;
				gananciaMaxima = ganancia1;
			}

			if (ganancia2 >= ganancia3 && ganancia2 >= ganancia1) {
				iVentaFinal = iVenta2;
				iCompraFinal = iCompra2;
				gananciaMaxima = ganancia2;
			}
			if (ganancia3 >= ganancia1 && ganancia3 >= ganancia2) {
				iVentaFinal = iVenta3;
				iCompraFinal = iCompra3;
				gananciaMaxima = ganancia3;
			}

		}

		System.out.println(Arrays.toString(precios));
		
		if (iCompra1 != -1) {
			System.out.println("Opcion1");
			System.out.println(iCompra1 + "  " + iVenta1);
			System.out.println(precios[iCompra1] + "  " + precios[iVenta1]);
			System.out.println(ganancia1);
			System.out.println("\n");
		}
		if (iCompra2 != -1) {
			System.out.println("Opcion2");
			System.out.println(iCompra2 + "  " + iVenta2);
			System.out.println(precios[iCompra2] + "  " + precios[iVenta2]);
			System.out.println(ganancia2);
			System.out.println("\n");
		}
		if (iCompra3 != -1) {
			System.out.println("Opcion3");
			System.out.println(iCompra3 + "  " + iVenta3);
			System.out.println(precios[iCompra3] + "  " + precios[iVenta3]);
			System.out.println(ganancia3);
			System.out.println("\n");
		}
		
		System.out.println("Resultado");
		System.out.println(iCompraFinal + "  " + iVentaFinal);
		System.out.println(precios[iCompraFinal] + "  " + precios[iVentaFinal]);
		System.out.println(gananciaMaxima);
		
		resultados[0]=iCompraFinal;
		resultados[1]=iVentaFinal;
		return resultados;

	}

}
