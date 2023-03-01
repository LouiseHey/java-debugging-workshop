package model;

public class Transfer {

    private String id;
    private int amount;
    private String transactionIdTo;
    private String transactionIdFrom;

    public Transfer(String id, int amount, String transactionIdTo, String transactionIdFrom) {
        this.id = id;
        this.amount = amount;
        this.transactionIdTo = transactionIdTo;
        this.transactionIdFrom = transactionIdFrom;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getTransactionIdTo() {
        return transactionIdTo;
    }

    public String getTransactionIdFrom() {
        return transactionIdFrom;
    }
}
