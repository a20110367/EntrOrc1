package nom;

import java.util.Random;
import java.util.Arrays;

public class Pruebas3 {

	public static void main(String[] args) {

		int cantidad = 10;
		//int[] numeros = generarEnteros(cantidad);
		int [] numeros = new int[] {9, 13, 3, 3, 15, 0, 10, 6, 16, 11};
		int [] resultados = mejorCompra(numeros);
		int[] resultados1 = mejorCompra4(numeros);
		System.out.println("\n\n");
		System.out.println(Arrays.toString(resultados));
		System.out.println(Arrays.toString(resultados1));
		if(numeros[resultados[1]]-numeros[resultados[0]] == numeros[resultados1[1]]-numeros[resultados1[0]])
			System.out.println("Success");
		else
			System.out.println("Failed");

	}
	
	public static int [] mejorCompra(int[] precios) {

		int iCompra = 0;
		int iVenta = 1;
		int pivote = 0;
		int [] resultados= new int[2];
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
		resultados[0]=iCompra;
		resultados[1]=iVenta;
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
		int iMinimo = 0;
		int iMaximo = 0;
		int iMinimoNuevo = 0;
		int iMaximoNuevo = 0;
		int pivote = 0;
		int[] resultados = new int[2];
		System.out.println("Inicio Base");
		while (pivote < precios.length && iMinimo == 0) {
			if (precios[pivote + 1] <= precios[pivote])
				pivote++;
			else {
				iMinimo = pivote;
				pivote++;
				break;
			}
		}

		while (pivote < precios.length && iMaximo == 0) {
			if (precios[pivote + 1] >= precios[pivote])
				pivote++;
			else {
				iMaximo = pivote;
				pivote++;
				break;
			}
		}
		System.out.println("Fin Base");
		
		System.out.println(iMinimo+"  "+iMaximo+"\n");

		if (pivote > precios.length - 2) {
			resultados[0] = iMinimo;
			resultados[1] = iMaximo;
			
		}
		else {
			while(pivote < precios.length-1) {
				while (pivote < precios.length-1 && iMinimoNuevo == 0) {
					if (precios[pivote + 1] <= precios[pivote]) {
						System.out.println("bajada Se sigue con el "+ pivote);
						pivote++;
					}
					else {
						System.out.println("Bajada Se asigana "+ pivote);
						iMinimoNuevo = pivote;
						pivote++;
						break;
					}
				}

				while (pivote < precios.length-1 && iMaximoNuevo == 0) {
					if (precios[pivote + 1] >= precios[pivote]) {
						System.out.println("Subida Se sigue con el "+ pivote);
						pivote++;
					}
					else {
						System.out.println("Subida Se asigana "+pivote);
						iMaximoNuevo = pivote;
						pivote++;
						break;
					}
				}
				if(pivote== precios.length-1 && iMaximoNuevo==0) {
					if(precios[pivote]>precios[pivote-1])
						iMaximoNuevo=pivote;
				}
				System.out.println("Candidatos");
				System.out.println(iMinimo+"  "+iMaximo);
				System.out.println(iMinimoNuevo+"  "+iMaximoNuevo);
				System.out.println("");
				
				//System.out.println(precios[iMinimo]+"  "+precios[iMaximo]+"\n");
				//Aqui hay que hacer evaluaciones y resets
				if(precios[iMinimo]<precios[iMinimoNuevo] && precios[iMaximoNuevo]>precios[iMaximo]) {
					iMaximo=iMaximoNuevo;
					iMinimoNuevo=0;
					iMaximoNuevo=0;
					
				}
				else if(precios[iMaximoNuevo]-precios[iMinimoNuevo]>precios[iMaximo]-precios[iMinimo]) {
					
					iMaximo=iMaximoNuevo;
					iMinimo=iMinimoNuevo;
					iMinimoNuevo=0;
					iMaximoNuevo=0;
							
				}
				else {
					
					iMinimoNuevo=0;
					iMaximoNuevo=0;
					
				}
				System.out.println("Resultado de Evaluaciones");
				System.out.println(iMinimo+"  "+iMaximo);
				//System.out.println(precios[iMinimo]+"  "+precios[iMaximo]);
				
			}
			resultados[0]=iMinimo;
			resultados[1]=iMaximo;
		}
		
		
		return resultados;

	}

}
