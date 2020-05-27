package challenge;



import java.util.ArrayList;
import java.util.List;

public class CriptografiaCesariana extends Criptografia {

    @Override
    public String criptografar(String texto) {
        String texto2 = texto.toLowerCase();
        String cript = new String();
        
        if (texto2 == "" || texto2 == null) {
            throw new IllegalArgumentException();
        }else{
            String alfabeto = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

            for (int i = 0; i < texto2.length(); i++) {
                char letter = texto2.charAt(i);
                String letter2 = Character.toString(letter);

                if (!alfabeto.contains(letter2)) {
                    cript = cript + letter2; //cript.concat(letter2);
                } else {
                    String letter3 = Character.toString(alfabeto.charAt(alfabeto.indexOf(letter2) + 3));
                    cript = cript + letter3;
                }
            }
        }
        return cript;
    }

    @Override
    public String descriptografar(String texto) {
        String texto2 = texto.toLowerCase();
        String cript = new String();

        if (texto2 == "" || texto2 == null) {
            throw new IllegalArgumentException();
        }else{
            String alfabeto = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

            for (int i = 0; i < texto2.length(); i++) {
                char letter = texto2.charAt(i);
                String letter2 = Character.toString(letter);

                if (!alfabeto.contains(letter2)) {
                    cript = cript + letter2;
                } else {
                    String letter3 = Character.toString(alfabeto.charAt(alfabeto.indexOf(letter2) - 3));
                    cript = cript + letter3;
                }
            }
        }
        return cript;
    }
}
