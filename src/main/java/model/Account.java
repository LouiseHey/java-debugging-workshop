package model;

import java.util.ArrayList;
import java.util.List;
import util.IdGenerator;

public class Account {

    private String id;
    private int balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public int getBalance() {
        return 0;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Transaction increment(int amount) {
        balance += amount;
        Transaction transaction = new Transaction(IdGenerator.generate(), amount, this.id);
        transactions.add(transaction);
        return transaction;
    }

    public Transaction decrement(int amount) {
        balance += amount;
        Transaction transaction = new Transaction(IdGenerator.generate(), amount, this.id);
        transactions.add(transaction);
        return transaction;
    }
}
