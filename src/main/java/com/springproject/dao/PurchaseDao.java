package com.springproject.dao;

import com.springproject.model.PurchasePanel;

import java.util.List;

/**
 * Created by Женя on 21.03.2017.
 */
public interface PurchaseDao {
    PurchasePanel getPurchasePanelById(int purchaseId);

    List<PurchasePanel> getPurchasePanelByUserId(int userId);

    void addPurchase (PurchasePanel purchasePanel);

    void editPurchase(PurchasePanel purchasePanel);

    void deletedPurchase(PurchasePanel purchasePanel);
}
