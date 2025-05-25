import java.util.Scanner;

public class VerificarConta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        System.out.println("*****************************************");
        System.out.println(" - Faça login na sua conta bancaria - ");
        System.out.print("Informe seu nome: ");
        String login = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        int senhaLogin = scanner.nextInt();
        System.out.println("*****************************************");

        String tipoConta = "Corrente";
        double saldo = 2500;
        int senha = 1234;
        int tentativasLogin = 3;

        for (int i = 1; i <= tentativasLogin; i++ ){
            if(senhaLogin == senha){
                System.out.println("Bem vindo " + login + "!");

                System.out.println("*****************************************");

                String detalheDaConta;

                detalheDaConta = String.format("""
                Dados iniciais do cliente:
                
                Nome:               %s
                Tipo de conta:      %s
                Saldo inicial:      R$ %.2f
                """, login,tipoConta,saldo);

                System.out.println(detalheDaConta);
                System.out.println("*****************************************");

                break;
            }else if (senhaLogin != senha){
                System.out.print("Senha incorreta, tente novamente: ");
                senhaLogin = scanner.nextInt();
            }if (i == tentativasLogin){
                System.out.println("Conta bloqueada! Favor, entrar em contato com o suporte.");
            }
        }

      /*  String detalheDaConta;

        detalheDaConta = String.format("""
                Nome:               %s
                Tipo de conta:      %s
                Saldo inicial:      R$ %f
                """, login,tipoConta,saldo);

        System.out.println(detalheDaConta);
        System.out.println("************************************");

*/



        scanner.close();
    }
}