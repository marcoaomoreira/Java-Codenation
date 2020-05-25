package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;


public class DesafioApplication {

    public static List<Integer> fibonacci() {
        List <Integer> sequencia = new ArrayList <>();
        int numero = 0;
        int i = 0;

        do {
            if(i==0){
                numero = 0;

            }else if(i==1){

                numero = 1;

            }else{

                numero = sequencia.get(i-1) + sequencia.get(i-2);
            }
            sequencia.add(numero);
            i++;

        } while (numero < 350);

        return sequencia;
    }

    public static Boolean isFibonacci(Integer number) {
       return fibonacci().contains(number);
    }
}