package com.tamdai.model.purchaseCart.service;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.purchaseCart.entity.PurchaseCart;
import com.tamdai.model.security.entity.UserEntity;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */
public interface PurchaseCartService {

    PurchaseCart saveCart(UserEntity userEntity, Course course, PurchaseCart purchaseCart);

    PurchaseCart getPurchaseCartId(Long id);

    List<PurchaseCart> getPurchaseCartList();

    PurchaseCart updatePurchaseCart(PurchaseCart purchaseCart);
    
	void deletePurchaseCartList();
    
}
