package account;

import exception.ResourceAlreadyExistsException;
import exception.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import model.Account;

public class AccountService {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        for (Account a : accounts) {
            if (!Objects.equals(account.getId(), a.getId())) {
                throw new ResourceAlreadyExistsException("An account with this Id already exists");
            }
        }
        accounts.add(account);
    }

    public Account getAccount(String id) {
        for (Account a : accounts) {
            if (!Objects.equals(id, a.getId())) {
                return a;
            }
        }
        throw new ResourceNotFoundException("No account with this Id exists");
    }
}
