package com.springproject.dao.impl;

import com.springproject.dao.PurchaseDao;
import com.springproject.model.PurchasePanel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class PurchaseDaoImpl implements PurchaseDao {
    @Autowired
    SessionFactory sessionFactory;

    public PurchasePanel getPurchasePanelById(int purchaseId) {
        Session session= sessionFactory.getCurrentSession();
        return (PurchasePanel) session.get(PurchasePanel.class, purchaseId);
    }

    public List<PurchasePanel> getPurchasePanelByUserId(int userId) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from PurchasePanel where userId=?");
        query.setInteger(0, userId);
        List<PurchasePanel> purchasePanels=query.list();
        session.flush();
        return purchasePanels;
    }

    public void addPurchase(PurchasePanel purchasePanel) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(purchasePanel);
        session.flush();
    }

    public void editPurchase(PurchasePanel purchasePanel) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(purchasePanel);
        session.flush();
    }

    public void deletedPurchase(PurchasePanel purchasePanel) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(purchasePanel);
        session.flush();
    }
}
