package tesch.guilherme.contabancaria.modelos;

public class ContaCorrente extends InformacoesConta{

    public void cobrarTarifaMensal(){
        double tarifaMensal = 12.90;
        if (getSaldo() >= tarifaMensal){
            saldo -= tarifaMensal;
            System.out.println("Tarifa mensal de R$: " + tarifaMensal + " cobrada.");
        }else {
            System.out.println("Saldo insuficiente para cobrar tarifa mensal.");
        }
    }
}
