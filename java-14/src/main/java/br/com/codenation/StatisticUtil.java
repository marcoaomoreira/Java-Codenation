package br.com.codenation;

public class StatisticUtil {

	public static int average(int[] elements) {
		int[] media = elements;
		int soma=0;
		for(int i=0; i < media.length ; i++ ){
			soma = soma + media[i];
		}

		return (soma/media.length);
	}

	public static int mode(int[] elements) {
		int[] modavetor = elements;
		int soma=0;

		int nVezes = 0;
		int moda = 0;
		int comparaV = 0;
		for (int p = 0; p < modavetor.length; p++) {

			nVezes = 0;
			for (int k = p + 1; k < modavetor.length; k++) {
				if (modavetor[p] == modavetor[k]) {
					++nVezes;
				}
			}
			if (nVezes > comparaV) {
				moda = modavetor[p];
				comparaV = nVezes;
			}
		}
		return moda;

	}

	public static int median(int[] elements) {
		int[] mediana = elements;
		int temp;
		int temp2 = 0;

		for (int i = 0; i < mediana.length; i++)
		{
			for (int j = i + 1; j < mediana.length; j++)
			{
				if (mediana[i] > mediana[j])
				{
					temp = mediana[i];
					mediana[i] = mediana[j];
					mediana[j] = temp;
				}
			}
		}
		if((mediana.length%2==0)){
			temp2 = (mediana[mediana.length/2] + mediana[mediana.length/2 -1])/2;
		}else{
			temp2 = mediana[mediana.length/2];
		}

		return (temp2);
	}
}