import exceptions.ExConta;
import org.junit.jupiter.api.*;

public class ContaTest {
    private Conta conta;
    private static double depositoInicial = 100.00;
    private static double valorEsperado = depositoInicial;
    private static double saque = 70.00;
    private static double saqueInvalido = 110.00;
    private static double valorEsperadoSaque = depositoInicial - saque;
    @BeforeAll
    private static void definirValores() {
        depositoInicial = 100.00;
        valorEsperado = depositoInicial;
        saque = 70.00;
        saqueInvalido = 110.00;
        valorEsperadoSaque = depositoInicial - saque;
    }
    @BeforeEach
    private void inicializarConta(){
        conta = new Conta();
        conta.ativar();
    }
    @Test
    @DisplayName("deve depositar com a conta ativa!")
    public void activatedAccountDeposit() throws ExConta {
        conta.depositar(depositoInicial);

        Assertions.assertEquals(valorEsperado, conta.getSaldo());
    }
    @Test
    @DisplayName("não deve depositar com a conta inativa!")
    public void inactivatedAccountNotDeposit() throws ExConta {

        conta.inativar();
        Assertions.assertThrows(ExConta.class, () -> conta.depositar(depositoInicial));

        Assertions.assertEquals(0.00, conta.getSaldo());
    }
    @Test
    @DisplayName("deve sacar com a conta ativa e saldo maior que valor de saque!")
    public void activatedAccountSaqAndValueSmaller() throws ExConta {

        conta.depositar(depositoInicial);
        conta.sacar(saque);

        Assertions.assertEquals(valorEsperadoSaque, conta.getSaldo());
    }

    @Test
    @DisplayName("não deve sacar com a conta inativa!")
    public void inactivatedAccountNotSaq() throws ExConta {

        conta.depositar(depositoInicial);
        conta.inativar();
        Assertions.assertThrows(ExConta.class, () -> conta.sacar(saque));

        Assertions.assertEquals(valorEsperado, conta.getSaldo());
    }

    @Test
    @DisplayName("não deve sacar com a conta ativa e saldo menor que valor de saque!")
    public void activatedAccountNotSaqAndValueSmall() throws ExConta {

        conta.depositar(depositoInicial);
        Assertions.assertThrows(ExConta.class, () -> conta.sacar(saqueInvalido));

        Assertions.assertEquals(valorEsperado, conta.getSaldo());
    }
}
