package com.tamdai.model.purchaseCart.repository;

import com.tamdai.model.purchaseCart.entity.PurchaseCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseCartRepository extends JpaRepository<PurchaseCart, Long> {
}
