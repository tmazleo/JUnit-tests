import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContaTest {

    @Test
    @DisplayName("deve depositar com a conta ativa!")
    public void activatedAccountDeposit() {
        Conta conta = new Conta();
        conta.ativar();
        conta.depositar(100.00);

        Assertions.assertEquals(100.00, conta.getSaldo());
    }
    @Test
    @DisplayName("não deve depositar com a conta inativa!")
    public void inactivatedAccountNotDeposit() {
        Conta conta = new Conta();
        conta.inativar();
        conta.depositar(100.00);

        Assertions.assertEquals(0.00, conta.getSaldo());
    }
    @Test
    @DisplayName("deve sacar com a conta ativa e saldo maior que valor de saque!")
    public void activatedAccountSaqAndValueSmaller() {
        Conta conta = new Conta();
        conta.ativar();
        conta.depositar(100.00);
        conta.sacar(70.00);

        Assertions.assertEquals(30.00, conta.getSaldo());
    }

    @Test
    @DisplayName("não deve sacar com a conta inativa!")
    public void inactivatedAccountNotSaq() {
        Conta conta = new Conta();
        conta.ativar();
        conta.depositar(100.00);
        conta.inativar();
        conta.sacar(70.00);

        Assertions.assertEquals(100.00, conta.getSaldo());
    }

    @Test
    @DisplayName("não deve sacar com a conta ativa e saldo menor que valor de saque!")
    public void activatedAccountNotSaqAndValueSmall() {
        Conta conta = new Conta();
        conta.ativar();
        conta.depositar(100.00);
        conta.sacar(110.00);

        Assertions.assertEquals(100.00, conta.getSaldo());
    }
}
