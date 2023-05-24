public class TestContaCompara {
    public static void main(String[] args) {

        //ativo
        Conta conta = new Conta();

        conta.ativar();

        conta.depositar(100.00);

        System.out.println("deve depositar com a conta ativa:");

        if(conta.getSaldo() == 100.00) {
            System.out.println("teste funcionou!");
        }else {
            System.out.println("teste falhou!");
        }
        System.out.println();
        //inativo
        conta = new Conta();

        conta.inativar();

        conta.depositar(100.00);

        System.out.println("não deve depositar com a conta inativa:");

        if(conta.getSaldo() == 0.00) {
            System.out.println("teste funcionou!");
        }else {
            System.out.println("teste falhou!");
        }
    }
}
