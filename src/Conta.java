import tesch.guilherme.contabancaria.modelos.ContaCorrente;

import java.util.Scanner;

public class Conta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
       // InformacoesConta info = new InformacoesConta();
        ContaCorrente info = new ContaCorrente();

        System.out.println("*****************************************");
        System.out.println(" - Faça login na sua conta bancaria - ");
        System.out.print("Informe seu nome: ");
        String login = scanner.nextLine();

        info.setTipoConta("Corrente");
        info.setSaldo(2500);
        info.setSenha(1234);
        info.setTentativasLogin(3);
        info.setLoginBemSucedido(false);



        for (int i = 1; i <= info.getTentativasLogin(); i++ ){
            System.out.print("Digite sua senha: ");
            int senhaLogin = scanner.nextInt();

            if(senhaLogin == info.getSenha()){
                info.setLoginBemSucedido(true);
                break;
            }else {
                if (i < info.getTentativasLogin()){
                    System.out.println("Senha incorreta, tente novamente.");
                }
            }

        }
        if(info.isLoginBemSucedido()){
            String bemVindo =String.format("""
                    
                    *****************************************
                    Bem vindo %s!
                    *****************************************
                    
                    """,login);
            System.out.println(bemVindo);

            String detalheDaConta = String.format("""
                Dados iniciais do cliente:
                
                Nome:               %s
                Tipo de conta:      %s
                Saldo inicial:      R$ %.2f
                """, login,info.getTipoConta(),info.getSaldo());

            System.out.println(detalheDaConta);
            System.out.println("*****************************************");

            while(true){
                String operacao = """
                    
                    Operações
                    
                    1- Consultar saldo
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    
                    """;

                System.out.println(operacao);
                System.out.print("Digite a opção desejada: ");
                int opcaoOperacao = scanner.nextInt();

                switch (opcaoOperacao){
                    case 1:
                        System.out.println("O saldo atual é R$ " + info.getSaldo()+"\n");
                        break;
                    case 2:
                        System.out.print("Informe o valor a receber: ");
                        double valorRecebido = scanner.nextDouble();
                        info.setSaldo(info.getSaldo() + valorRecebido);
                        System.out.println("Saldo atualizado R$ "+ info.getSaldo());
                        break;
                    case 3:
                        System.out.print("Informe o valor a transferir: ");
                        double valorTransferencia = scanner.nextDouble();
                        if (valorTransferencia > info.getSaldo()){
                            System.out.println("Saldo insuficiente!");
                        }else {
                            info.setSaldo(info.getSaldo()-valorTransferencia);
                            info.cobrarTarifaMensal();
                            System.out.println("Saldo atualizado R$ "+ info.getSaldo());
                        }
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }

        } else {
            System.out.println("Conta bloqueada! Favor, entrar em contato com o suporte.");
        }
        scanner.close();
    }
}