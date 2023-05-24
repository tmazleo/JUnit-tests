public class TestConta {

    public static void main(String[] args) {

        //ativo
        Conta conta = new Conta();

        conta.ativar();

        conta.depositar(100.00);

        //inativo
        conta = new Conta();

        conta.inativar();

        conta.depositar(100.00);
    }
}
