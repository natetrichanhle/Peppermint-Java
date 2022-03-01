package com.nate.peppermint.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "savingsAccounts")
public class SavingsAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int total;
    
    private int totalExpenses;

    // 1 : 1 account has one Month
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_id")
    private Month month;

    // 1 : M (savings account can have multiple expenses)
    @OneToMany(mappedBy="savingsAccount", fetch = FetchType.LAZY)
    private List<Budget> expenses;

    public SavingsAccount(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public List<Budget> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Budget> expenses) {
        this.expenses = expenses;
    }

    public int getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

}
