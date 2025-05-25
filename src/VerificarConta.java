import java.sql.SQLOutput;
import java.util.Scanner;

public class VerificarConta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        System.out.println("*****************************************");
        System.out.println(" - Faça login na sua conta bancaria - ");
        System.out.print("Informe seu nome: ");
        String login = scanner.nextLine();

        String tipoConta = "Corrente";
        double saldo = 2500;
        int senha = 1234;
        int tentativasLogin = 3;
        boolean loginBemSucedido = false;

        for (int i = 1; i <= tentativasLogin; i++ ){
            System.out.print("Digite sua senha: ");
            int senhaLogin = scanner.nextInt();

            if(senhaLogin == senha){
                loginBemSucedido = true;
                break;
            }else {
                if (i < tentativasLogin){
                    System.out.println("Senha incorreta, tente novamente.");
                }
            }

        }
        if(loginBemSucedido){
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
                """, login,tipoConta,saldo);

            System.out.println(detalheDaConta);
            System.out.println("*****************************************");

            while(true){
                String operacao = String.format("""
                    
                    Operações
                    
                    1- Consultar saldo
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    
                    """);

                System.out.println(operacao);
                System.out.print("Digite a opção desejada: ");
                int opcaoOperacao = scanner.nextInt();

                switch (opcaoOperacao){
                    case 1:
                        System.out.println("O saldo atual é R$ " + saldo+"\n");
                        break;
                    case 2:
                        System.out.print("Informe o valor a receber: ");
                        double valorRecebido = scanner.nextDouble();
                        saldo += valorRecebido;
                        System.out.println("Saldo atualizado R$ "+ saldo);
                        break;
                    case 3:
                        System.out.print("Informe o valor a transferir: ");
                        double valorTransferencia = scanner.nextDouble();
                        if (valorTransferencia > saldo){
                            System.out.println("Saldo insuficiente!");
                        }else {
                            saldo -= valorTransferencia;
                            System.out.println("Saldo atualizado R$ "+ saldo);
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