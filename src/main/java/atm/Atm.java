package atm;

import account.AccountService;
import model.Account;
import model.Transaction;
import model.Transfer;
import util.IdGenerator;

public class Atm {
    private AccountService service;

    public Atm(AccountService service) {
        this.service = service;
    }

    public Transaction deposit(String accountId, int amount) {
        return service.getAccount(accountId).increment(amount);
    }

    public Transaction withdraw(String accountId, int amount) {
        return service.getAccount(accountId).decrement(amount);
    }

    public Transfer transfer(int amount, String accountId, String accountIdToTransferTo) {
        Account account = service.getAccount(accountId);
        Account accountToTransferTo = service.getAccount(accountIdToTransferTo);

        Transaction transactionFrom = account.decrement(amount);
        Transaction transactionTo = accountToTransferTo.increment(amount);

        return new Transfer(IdGenerator.generate(), amount, transactionTo.getId(), transactionFrom.getId());
    }

    public int checkBalance(String accountId) {
        return service.getAccount(accountId).getBalance();
    }
}
