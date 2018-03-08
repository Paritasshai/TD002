package com.tamdai.model.purchaseCart.service;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.purchaseCart.dao.PurchaseCartDao;
import com.tamdai.model.purchaseCart.entity.PurchaseCart;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */

@Service
public class PurchaseCartServiceImpl implements PurchaseCartService {

    @Autowired
    PurchaseCartDao purchaseCartDao;

    @Override
    public PurchaseCart saveCart(UserEntity userEntity, Course course, PurchaseCart purchaseCart) {
        return purchaseCartDao.saveCart(userEntity, course, purchaseCart);
    }

    @Override
    public PurchaseCart getPurchaseCartId(Long id) {
        return purchaseCartDao.getPurchaseCartId(id);
    }

    @Override
    public List<PurchaseCart> getPurchaseCartList() {
        return purchaseCartDao.getPurchaseCartList();
    }

	@Override
	public PurchaseCart updatePurchaseCart(PurchaseCart purchaseCart) {
		String status = "Expired";
		purchaseCart.setCartStatus(status);
		purchaseCartDao.updatePurchaseCart(purchaseCart);
		return purchaseCart;
	}

	@Override
	public void deletePurchaseCartList() {
		purchaseCartDao.deletePurchaseCartList();
	}

}
