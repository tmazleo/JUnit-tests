import exceptions.ExConta;

public class Conta {

    private double saldo;
    private boolean ativo;

    public double getSaldo() {
        return saldo;
    }
    public void ativar() {
        this.ativo = true;
    }
    public void inativar() {
        this.ativo = false;
    }

    public void depositar(double valor) throws ExConta {
        if (this.ativo) {
            this.saldo += valor;
        }else {
            throw new ExConta(saldo,valor);
        }
    }

    public void sacar(double valor) throws ExConta{
            if(this.ativo && (this.saldo - valor >= 0)) {
                this.saldo -= valor;
            } else {
                throw new ExConta(saldo,valor);
            }

    }
}
