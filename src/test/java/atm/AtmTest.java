package atm;

import account.AccountService;
import model.Account;
import model.Transaction;
import model.Transfer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtmTest {
    AccountService service;
    Atm atm;

    @BeforeEach
    void beforeEach() {
        service = new AccountService();
        service.addAccount(new Account("id", 0));
        service.addAccount(new Account("id2", 0));
        atm = new Atm(service);
    }

    @Test
    void whenCheckBalance_thenCorrectBalanceReturned() {
        assertEquals(0, atm.checkBalance("id"));
    }

    @Test
    void whenDeposit_thenBalanceUpdatedAndTransactionReturnedAndTransactionsAddedToAccount() {
        Transaction t = atm.deposit("id", 10);

        assertEquals(10, atm.checkBalance("id"));
        assertEquals("id", t.getAccountId());
        assertEquals(10, t.getAmount());

        assertEquals(t, service.getAccount("id").getTransactions().get(0));
    }

    @Test
    void whenWithdraw_thenBalanceUpdatedAndTransactionReturnedAndTransactionsAddedToAccount() {
        Transaction t = atm.withdraw("id", 10);

        assertEquals(-10, atm.checkBalance("id"));
        assertEquals("id", t.getAccountId());
        assertEquals(10, t.getAmount());

        assertEquals(t, service.getAccount("id").getTransactions().get(0));
    }

    @Test
    void whenTransferFromOneAccountToAnother_thenBalancesUpdatedAndTransferReturnedAndTransactionsAddedToAccounts() {
        Transfer t = atm.transfer(10, "id", "id2");

        assertEquals(-10, atm.checkBalance("id"));
        assertEquals(10, atm.checkBalance("id2"));

        assertEquals(10, t.getAmount());

        assertEquals(t.getTransactionIdFrom(), service.getAccount("id").getTransactions().get(0).getId());
        assertEquals(t.getTransactionIdTo(), service.getAccount("id2").getTransactions().get(0).getId());
    }
}