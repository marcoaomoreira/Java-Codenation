package challenge;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CriptografiaCesarianaTest {


    private static final String TEXTO_CRIPTOGRAFADO = "d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr";
    private static final String TEXTO_DESCRIPTOGRAFADO = "a ligeira raposa marrom saltou sobre o cachorro cansado";

    private Criptografia criptografia;


    @Test
    public void deveCriptografarTexto() {
        String texto = TEXTO_DESCRIPTOGRAFADO;
        assertEquals(TEXTO_CRIPTOGRAFADO, criptografia.criptografar(texto));
    }

    @Test
    public void deveDescriptografarTexto() {
        String texto = TEXTO_CRIPTOGRAFADO;
        assertEquals(TEXTO_DESCRIPTOGRAFADO, criptografia.descriptografar(texto));
    }

    @Test
    public void deveManterOsNumerosNaCriptografia() {
        String texto = "sejam bem vindos ao Acelera Brasil 2019";
        assertEquals("vhmdp ehp ylqgrv dr dfhohud eudvlo 2019", criptografia.criptografar(texto));
    }

    @Test
    public void deveManterOsNumerosNaDescriptografia() {
        String textoCifrado = "vhmdp ehp ylqgrv dr dfhohud eudvlo 2019";
        assertEquals("sejam bem vindos ao acelera brasil 2019", criptografia.descriptografar(textoCifrado));
    }

    @Test
    public void deveConverterCaracteresParaMinusculoNaCriptografia() {
        String texto = "Aprender Java gera felicidade";
        assertEquals("dsuhqghu mdyd jhud iholflgdgh", criptografia.criptografar(texto));
    }

    @Test
    public void deveConverterCaracteresParaMinusculoNaDescriptografia() {
        String textoCifrado = "Dsuhqghu Mdyd jhud iholflgdgh";
        assertEquals("aprender java gera felicidade", criptografia.descriptografar(textoCifrado));
    }

    public static void main(String[] args) {
        //char alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String alfabeto = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        String cript = "";
        String texto2 = "Aprender Java gera felicidade".toLowerCase();
        //String alfabetomai = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(cript.concat("teste"));

        for (int i = 0; i < texto2.length(); i++) {

            char letter = texto2.charAt(i);
            String letter2 = Character.toString(letter);

                   //System.out.println(alfabeto.indexOf(letter));
            if (!alfabeto.contains(letter2)){
                cript = cript + letter2 ; //cript.concat(letter2);
            }else{
                String letter3 = Character.toString(alfabeto.charAt(alfabeto.indexOf(letter2)+3));
                cript = cript + letter3 ;
            }
           // char teste2 = letter;
           // cript.add(letter);
            //System.out.println(letter2);
        }

        System.out.println(cript);
        //System.out.println(texto2 + "eitarapaziada");
        //alphabet.toCharArray();
//        alfabetomin.charAt(5);
//        String vamo = "D".toLowerCase();
//        alfabetomin.contains(vamo);
//
//        System.out.println(alfabetomin.indexOf((alfabetomin.indexOf(vamo))-1));
//        System.out.println(alfabetomin.charAt(5));
       }

}
