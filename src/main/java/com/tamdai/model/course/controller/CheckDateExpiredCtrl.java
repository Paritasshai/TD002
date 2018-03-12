package com.tamdai.model.course.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.service.CourseService;
import com.tamdai.model.purchaseCart.entity.PurchaseCart;
import com.tamdai.model.purchaseCart.repository.PurchaseCartRepository;
import com.tamdai.model.purchaseCart.service.PurchaseCartService;
import com.tamdai.model.security.dao.UserDao;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.service.UserService;

@Component
public class CheckDateExpiredCtrl {

	@Autowired
	PurchaseCartRepository purchaseCartRepository;

	@Autowired
	CourseService courseService;

	@Autowired
	UserService userService;

	@Autowired
	PurchaseCartService purchaseCartService;

	@Autowired
	UserDao userDao;

	@Scheduled(cron = "0 54 23 ? * *")
	public void reportCurrentTime1() {

		System.out.println("============= Start Process Expired =============");
		String expirationDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		List<PurchaseCart> purchasCart = purchaseCartRepository.findAll();

		for (Iterator<PurchaseCart> it = purchasCart.iterator(); it.hasNext();) {
			PurchaseCart f = it.next();

			if (f.getDateExpired().equals(expirationDate)) {

				System.out.println("==========================");
				System.out.println("Cart getId: " + f.getId());
				System.out.println("Cart getDateExpired: " + f.getDateExpired());
				System.out.println("Cart expirationDate: " + expirationDate);
				System.out.println("Cart Status : " + f.getCartStatus());
				System.out.println("==============================================================================");

				Course course = f.getCourses().iterator().next();
				System.out.println("Show Course ID: " + course.getId());

				UserEntity user = f.getUsers().iterator().next();
				System.out.println("Show Users ID: " + user.getId());

				PurchaseCart getPurchaseCart = purchaseCartService.getPurchaseCartId(f.getId());
				UserEntity getUser = userService.getUserId(user.getId());
				Set<Course> courses = getUser.getCourses();

				try {
					for (Iterator<Course> ic = courses.iterator(); it.hasNext();) {
						Course c = ic.next();
						
						if (c.getId().equals(course.getId())) {
							getUser.getCourses().remove(c);
							userService.deleteUserCourse(getUser, c.getId());
							purchaseCartService.updatePurchaseCart(getPurchaseCart);
							System.out.println(" Delelete Course : " + c.getId() + " Success ");
						}
					}
				} catch (Exception e) {
					System.out.println("Try Catch: " + e.getMessage());
				}
			}
		}

		System.out.println("============= Stop Process Expired =============");
	}
	
	@Scheduled(cron = "0 55 23 ? * *")
	public void reportCurrentTime2() {

		System.out.println("============= Start Process Expired =============");
		String expirationDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		List<PurchaseCart> purchasCart = purchaseCartRepository.findAll();

		for (Iterator<PurchaseCart> it = purchasCart.iterator(); it.hasNext();) {
			PurchaseCart f = it.next();

			if (f.getDateExpired().equals(expirationDate)) {

				System.out.println("==========================");
				System.out.println("Cart getId: " + f.getId());
				System.out.println("Cart getDateExpired: " + f.getDateExpired());
				System.out.println("Cart expirationDate: " + expirationDate);
				System.out.println("Cart Status : " + f.getCartStatus());
				System.out.println("==============================================================================");

				Course course = f.getCourses().iterator().next();
				System.out.println("Show Course ID: " + course.getId());

				UserEntity user = f.getUsers().iterator().next();
				System.out.println("Show Users ID: " + user.getId());

				PurchaseCart getPurchaseCart = purchaseCartService.getPurchaseCartId(f.getId());
				UserEntity getUser = userService.getUserId(user.getId());
				Set<Course> courses = getUser.getCourses();

				try {
					for (Iterator<Course> ic = courses.iterator(); it.hasNext();) {
						Course c = ic.next();
						
						if (c.getId().equals(course.getId())) {
							getUser.getCourses().remove(c);
							userService.deleteUserCourse(getUser, c.getId());
							purchaseCartService.updatePurchaseCart(getPurchaseCart);
							System.out.println(" Delelete Course : " + c.getId() + " Success ");
						}
					}
				} catch (Exception e) {
					System.out.println("Try Catch: " + e.getMessage());
				}
			}
		}

		System.out.println("============= Stop Process Expired =============");
	}
}