package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DesafioApplicationTest {
	
	public List<Integer> fibonacci() {
		
		List <Integer> sequencia = new ArrayList <>();
		int numero = 0;
        int i = 0;
		while (numero*2 < 350) {
            if(i==0){
                numero = 0;
            }else if(i==1){
                numero = 1;
            }else{
                numero = sequencia.get(i-1) + sequencia.get(i-2);
            }

            sequencia.add(numero);
            i++;
        }
       //System.out.println(sequencia);
       return sequencia;
	}

	//@Test
	public Boolean isFibonacci(Integer number) {
		List <Integer> test11 = fibonacci();
		return test11.contains(number);
		
		//retorno = sequencia.contains(number);
        //return retorno;
	}

}
