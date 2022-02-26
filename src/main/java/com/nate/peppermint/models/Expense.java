package com.nate.peppermint.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String expenseName;

    private int amount;

    // M : 1 with SavingsAccount
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "savingsAccount_id")
    private SavingsAccount savingsAccount;

    public Expense() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public SavingsAccount getAccount() {
        return savingsAccount;
    }

    public void setAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

}
