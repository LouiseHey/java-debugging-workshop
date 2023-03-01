package account;

import exception.ResourceAlreadyExistsException;
import exception.ResourceNotFoundException;
import model.Account;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountServiceTest {

    @Test
    void givenNoAccounts_WhenAddAccount_thenGetAccountShowsNewAccountAdded() {
        AccountService service = new AccountService();

        String accountId = "AccountId";
        int balance = 0;
        Account newAccount = new Account(accountId, balance);

        service.addAccount(newAccount);

        assertEquals(accountId, service.getAccount(accountId).getId());
        assertEquals(balance, service.getAccount(accountId).getBalance());
    }

    @Test
    void givenAccountWithSameIdInAccountsList_WhenAddAccountWithSameId_thenExceptionThrown() {
        AccountService service = new AccountService();

        String accountId = "AccountId";
        int balance = 0;
        Account newAccount = new Account(accountId, balance);
        Account anotherAccount = new Account("anotherId", balance);

        service.addAccount(anotherAccount);
        service.addAccount(newAccount);

        ResourceAlreadyExistsException e = assertThrows(ResourceAlreadyExistsException.class, () -> service.addAccount(newAccount));

        assertEquals("An account with this Id already exists", e.getMessage());
    }

    @Test
    void givenAccountNotInAccountsList_WhenGetAccount_thenExceptionThrown() {
        AccountService service = new AccountService();

        ResourceNotFoundException e = assertThrows(ResourceNotFoundException.class, () -> service.getAccount("unknownId"));

        assertEquals("No account with this Id exists", e.getMessage());
    }
}