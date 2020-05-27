package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    List<Carro> carros = new ArrayList<>();

    public void estacionar(Carro carro) {
        if(carro.getMotorista() == null) throw new EstacionamentoException("Carro sem motorista, favor cadastrar!");
        else if(carro.getMotorista().getIdade() < 18 || carro.getMotorista().getPontos() > 20)
            throw new EstacionamentoException("Motorista não pode ser cadastrado, informar outro motorista!");
        else{
            carroEstacionado(carro);
        }
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        int soma=0;
       if (carrosEstacionados() >= 10 && carro.getMotorista().getIdade() > 55){
           for(int i=0;i < carrosEstacionados(); i++) {
               if(carros.get(i).getMotorista().getIdade() < 55){
                    carros.remove(i);
                    carros.add(carro);
                    return true;
               }else{
                   soma = soma + 1;
               }
           }
           if (soma==10){
               throw new EstacionamentoException("Não é possível estacionar o carro");

           }else{
               carros.add(carro);
               return true;
           }

       }else if (carrosEstacionados() >= 10 && carro.getMotorista().getIdade() < 55){
           return false;
       }else{
           carros.add(carro);
           return true;
       }

    }
}
