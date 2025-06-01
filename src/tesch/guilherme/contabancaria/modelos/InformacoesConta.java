package tesch.guilherme.contabancaria.modelos;

public class InformacoesConta {
    protected String tipoConta;
    protected double saldo;
    private int senha;
    private int tentativasLogin;
    private boolean loginBemSucedido;

    public String getTipoConta(){
        return tipoConta;
    }

    public void setTipoConta(String tipoConta){
        this.tipoConta = tipoConta;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;

    }

    public int getSenha(){
        return senha;
    }

    public void setSenha(int senha){
        this.senha = senha;
    }

    public int getTentativasLogin(){
        return tentativasLogin;
    }

    public void setTentativasLogin(int tentativasLogin){
        this.tentativasLogin = tentativasLogin;
    }

    public boolean isLoginBemSucedido(){
        return loginBemSucedido;
    }

    public void setLoginBemSucedido(boolean loginBemSucedido){
        this.loginBemSucedido = loginBemSucedido;
    }
}
