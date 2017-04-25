package com.springproject.service.impl;

import com.springproject.dao.PurchaseDao;
import com.springproject.model.PurchasePanel;
import com.springproject.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Женя on 21.03.2017.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
   private  PurchaseDao purchaseDao;

    public PurchasePanel getPurchasePanelById(int purchaseId) {
        return purchaseDao.getPurchasePanelById(purchaseId);
    }

    public List<PurchasePanel> getPurchasePanelByUserId(int userId) {
        return purchaseDao.getPurchasePanelByUserId(userId );
    }

    public void addPurchase(PurchasePanel purchasePanel) {
        purchaseDao.addPurchase(purchasePanel);
    }

    public void editPurchase(PurchasePanel purchasePanel) {
        purchaseDao.editPurchase(purchasePanel);
    }

    public void deletedPurchase(PurchasePanel purchasePanel) {
        purchaseDao.deletedPurchase(purchasePanel);
    }

    public List<PurchasePanel> getPurchasePanels() {
        return null;
    }
}
