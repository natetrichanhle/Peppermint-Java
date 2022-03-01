package com.nate.peppermint.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "investments")
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalInvestments;
    
    private Integer rothIraAmount;

    private Integer stocksAmount;

    private Integer cryptoAmount;

    @Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_id")
    private Month month;

    public Investment(){
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

    public Integer getRothIraAmount() {
        return rothIraAmount;
    }

    public void setRothIraAmount(Integer rothIraAmount) {
        this.rothIraAmount = rothIraAmount;
    }

    public Integer getStocksAmount() {
        return stocksAmount;
    }

    public void setStocksAmount(Integer stocksAmount) {
        this.stocksAmount = stocksAmount;
    }

    public Integer getCryptoAmount() {
        return cryptoAmount;
    }

    public Integer getTotalInvestments() {
        return totalInvestments;
    }

    public void setTotalInvestments(Integer totalInvestments) {
        this.totalInvestments = totalInvestments;
    }

    public void setCryptoAmount(Integer cryptoAmount) {
        this.cryptoAmount = cryptoAmount;
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

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
    
    
}
