package com.springproject.service;

import com.springproject.model.PurchasePanel;

import java.util.List;

/**
 * Created by Женя on 21.03.2017.
 */
public interface PurchaseService {

    PurchasePanel getPurchasePanelById(int purchaseId);

    List<PurchasePanel> getPurchasePanelByUserId(int userId);

    void addPurchase ( PurchasePanel purchasePanel);

    void editPurchase(PurchasePanel purchasePanel);

    void deletedPurchase(PurchasePanel purchasePanel);

    List<PurchasePanel> getPurchasePanels();
}
