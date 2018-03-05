package com.tamdai.model.purchaseCart.dao;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.purchaseCart.entity.PurchaseCart;
import com.tamdai.model.purchaseCart.repository.PurchaseCartRepository;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */

@Repository
public class PurchaseCartDaoImpl implements PurchaseCartDao {

	@Autowired
	PurchaseCartRepository purchaseCartRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public PurchaseCart saveCart(UserEntity userEntity, Course course, PurchaseCart purchaseCart) {

		String datePurchased = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		LocalDate localDate = LocalDate.parse(datePurchased);
		long year = Integer.parseInt(course.getCourseAge());
		LocalDate yearLater = localDate.plusMonths(year);
		System.out.println("localDate: " + localDate + " and yearLater: " + yearLater);

		String a = localDate.toString();
		String b = yearLater.toString();

		purchaseCart.setDatePurchased(a);
		purchaseCart.setDateExpired(b);
		purchaseCart.getCourses().add(course);
		purchaseCartRepository.save(purchaseCart);
		purchaseCart.getUsers().add(userEntity);

		userEntity.getCourses().add(course);
		userRepository.save(userEntity);
		return purchaseCart;
	}

	@Override
	public PurchaseCart getPurchaseCartId(Long id) {
		return purchaseCartRepository.findOne(id);
	}

	@Override
	public List<PurchaseCart> getPurchaseCartList() {
		return purchaseCartRepository.findAll();
	}

	@Override
	public PurchaseCart updatePurchaseCart(PurchaseCart purchaseCart) {
		return purchaseCartRepository.save(purchaseCart);
	}

}
