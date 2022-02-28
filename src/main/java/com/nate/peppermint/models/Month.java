package com.nate.peppermint.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "months")
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String monthOfYear;
    
    @NotNull
    private Integer monthlyTotal;

    @NotNull
    private Integer savingsPercentage;

    @NotNull
    private Integer investmentPercentage;

    @NotNull
    private Integer utilityPercentage;

    @OneToMany(mappedBy="month",  cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Goal> goals;

    @OneToOne(mappedBy="month", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Investment investment;

    @Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

    public Month() {
    }

    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(String monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public Integer getMonthlyTotal() {
        return monthlyTotal;
    }

    public void setMonthlyTotal(Integer monthlyTotal) {
        this.monthlyTotal = monthlyTotal;
    }

    public Integer getSavingsPercentage() {
        return savingsPercentage;
    }

    public void setSavingsPercentage(Integer savingsPercentage) {
        this.savingsPercentage = savingsPercentage;
    }

    public Integer getInvestmentPercentage() {
        return investmentPercentage;
    }

    public void setInvestmentPercentage(Integer investmentPercentage) {
        this.investmentPercentage = investmentPercentage;
    }

    public Integer getUtilityPercentage() {
        return utilityPercentage;
    }

    public void setUtilityPercentage(Integer utilityPercentage) {
        this.utilityPercentage = utilityPercentage;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    
}
