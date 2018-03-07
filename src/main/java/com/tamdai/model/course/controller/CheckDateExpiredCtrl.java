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

	@Scheduled(cron = "0 55 23 ? * *")
	public void reportCurrentTime() {

		System.out.println("============= Checking Course Expired =============");
		String expirationDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		try {
			List<PurchaseCart> purchasCart = purchaseCartRepository.findAll();

			for (Iterator<PurchaseCart> it = purchasCart.iterator(); it.hasNext();) {
				PurchaseCart f = it.next();
				if (f.getCartStatus() != "null") {
					if (f.getDateExpired().equals(expirationDate)) {
						System.out.println("Cart ID: " + f.getId());
						System.out.println("Current Date: " + expirationDate);
						System.out.println("Cart DateExpired: " + f.getDateExpired());
						// System.out.println("Show Course Course: " +
						// f.getCourses().iterator().next().toString());
						// System.out.println("Show Course Course: " +
						// f.getUsers().iterator().next().toString());

						Course course = f.getCourses().iterator().next();
						course.getId();
						System.out.println("Show Course ID: " + course.getId());

						UserEntity user = f.getUsers().iterator().next();
						user.getId();
						System.out.println("Show Users ID: " + user.getId());

						// Delete Course From User
						PurchaseCart getPurchaseCart = purchaseCartService.getPurchaseCartId(f.getId());
						Course getCourse = courseService.getCourseId(course.getId());
						UserEntity getUser = userService.getUserId(user.getId());

						try {
							System.out.println("============= Delete Processing =============");
							Set<Course> courses = getUser.getCourses();

							for (Iterator<Course> ic = courses.iterator(); it.hasNext();) {
								Course c = ic.next();
								if (c.getId().equals(course.getId())) {
									getUser.getCourses().remove(c);
								}
								userDao.updateUser(getUser);
							}
						} catch (Exception e) {
							System.out.println("try catch" + e.getMessage());
						}
						purchaseCartService.updatePurchaseCart(getPurchaseCart);
					}
				}
			}

			System.out.println("============= Complete =============");
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

}