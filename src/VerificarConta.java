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
            System.out.println("Bem vindo " + login + "!");
            System.out.println("*****************************************");

            String detalheDaConta = String.format("""
                Dados iniciais do cliente:
                
                Nome:               %s
                Tipo de conta:      %s
                Saldo inicial:      R$ %.2f
                """, login,tipoConta,saldo);

            System.out.println(detalheDaConta);
            System.out.println("*****************************************");

        } else {
            System.out.println("Conta bloqueada! Favor, entrar em contato com o suporte.");
        }
        scanner.close();
    }
}