package model;

public class Transaction {

    private String id;
    private int amount;
    private String accountId;

    public Transaction(String id, int amount, String accountId) {
        this.id = id;
        this.amount = amount;
        this.accountId = accountId;
    }
    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getAccountId() {
        return accountId;
    }
}
