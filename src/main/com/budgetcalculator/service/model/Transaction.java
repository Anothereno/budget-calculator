package com.budgetcalculator.service.model;

public class Transaction {
    private TransactionType type;
    private User user;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
