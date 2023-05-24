import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContaTest {
    private Conta conta;
    private double depositoInicial = 100.00;
    private double valorEsperado = depositoInicial;
    private double saque = 70.00;
    private double saqueInvalido = 110.00;
    private double valorEsperadoSaque = depositoInicial - saque;
    @BeforeEach
    public void inicializarConta(){
        conta = new Conta();
        conta.ativar();
    }
    @Test
    @DisplayName("deve depositar com a conta ativa!")
    public void activatedAccountDeposit() {
        conta.depositar(depositoInicial);

        Assertions.assertEquals(valorEsperado, conta.getSaldo());
    }
    @Test
    @DisplayName("não deve depositar com a conta inativa!")
    public void inactivatedAccountNotDeposit() {

        conta.inativar();
        conta.depositar(depositoInicial);

        Assertions.assertEquals(0.00, conta.getSaldo());
    }
    @Test
    @DisplayName("deve sacar com a conta ativa e saldo maior que valor de saque!")
    public void activatedAccountSaqAndValueSmaller() {

        conta.depositar(depositoInicial);
        conta.sacar(saque);

        Assertions.assertEquals(valorEsperadoSaque, conta.getSaldo());
    }

    @Test
    @DisplayName("não deve sacar com a conta inativa!")
    public void inactivatedAccountNotSaq() {

        conta.depositar(depositoInicial);
        conta.inativar();
        conta.sacar(saque);

        Assertions.assertEquals(valorEsperado, conta.getSaldo());
    }

    @Test
    @DisplayName("não deve sacar com a conta ativa e saldo menor que valor de saque!")
    public void activatedAccountNotSaqAndValueSmall() {

        conta.depositar(depositoInicial);
        conta.sacar(saqueInvalido);

        Assertions.assertEquals(valorEsperado, conta.getSaldo());
    }
}
