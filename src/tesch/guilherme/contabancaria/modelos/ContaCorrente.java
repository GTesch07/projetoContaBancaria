package tesch.guilherme.contabancaria.modelos;

public class ContaCorrente extends InformacoesConta{

    private boolean tarifaCobrada = false;

    public void cobrarTarifaMensal(){
        double tarifaMensal = 12.90;
        if (tarifaCobrada){
            System.out.println("A tarifa mensal já foi cobrada.");
            return;
        }
        if (getSaldo() >= tarifaMensal){
            saldo -= tarifaMensal;
            tarifaCobrada = true;
            System.out.printf("Tarifa mensal de R$: %.2f cobrada\n", tarifaMensal);
        }else {
            System.out.println("Saldo insuficiente para cobrar tarifa mensal.");
        }
    }
}
