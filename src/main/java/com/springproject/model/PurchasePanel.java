//
//
//Якщо не виходить змінити звязок між таблицями User i PruchasePanel
//
//
package com.springproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class PurchasePanel implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue
    private int purchaseId;
    @NotNull
    private int purchasePrice;
    private  String category;
    private int balanc;
    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBalanc() {
        return balanc;
    }

    public void setBalanc(int balanc) {
        this.balanc = balanc;
    }
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

}
