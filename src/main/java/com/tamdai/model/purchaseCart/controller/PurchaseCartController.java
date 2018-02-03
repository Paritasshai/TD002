package com.tamdai.model.purchaseCart.controller;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.service.CourseService;
import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.payment.service.PaymentTransactionService;
import com.tamdai.model.purchaseCart.entity.PurchaseCart;
import com.tamdai.model.purchaseCart.service.PurchaseCartService;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.repository.UserRepository;
import com.tamdai.model.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */

@CrossOrigin
@RestController
@RequestMapping("/")
public class PurchaseCartController {

    @Autowired
    PurchaseCartService purchaseCartService;

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @Autowired
    PaymentTransactionService paymentTransactionService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "saveCart", method = RequestMethod.POST)
    public PurchaseCart saveCart(@RequestBody PurchaseCart purchaseCart,
                                 @RequestParam("userId") Long userId,
                                 @RequestParam("countPurchase") Long countPurchase,
                                 @RequestParam("courseId") Long courseId,
                                 @RequestParam("courseName") String courseName,
                                 @RequestParam("transAmount") Long transAmount,
                                 @RequestParam("userBalance") Long userBalance, BindingResult bindingResult) {
        UserEntity userEntity = userService.getUserId(userId);
        Course course = courseService.getCourseId(courseId);

        long a = userBalance;
        long b = transAmount;
        System.out.println(countPurchase);
        
        
        
        if (a >= b) {
            long c = a - b;
            System.out.println("User Balance: "+ c);
            
            int count = countPurchase.intValue();
            count = count + 1;
            System.out.println("=============================================");
            System.out.println("Count : "+ count);
            System.out.println("course ID : "+ courseId);
            System.out.println("=============================================");
            
            try {
           
//            	Long count = countPurchase;
//                System.out.println("=============================================");
//            	System.out.println("Count : " + count++);
//                System.out.println("=============================================");
            	
            	course.setCountPurchase(count);
        	
                String balance = new String(String.valueOf(c));
                userEntity.setBalance(balance);
                userRepository.save(userEntity);

                PaymentTransaction paymentTransaction = new PaymentTransaction();

                //CreateDate
                String transDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                paymentTransaction.setCreateDate(transDate);

                //CreateTime
                String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
                paymentTransaction.setCreateTime(timeStamp);

                String transA = new String(String.valueOf(transAmount));
                paymentTransaction.setTransAmount(transA);

                String balanceRef = new String(String.valueOf(c));
                paymentTransaction.setTransRemark(balanceRef);

                //paymentTransaction.setTransRef(String.valueOf(courseId));
                paymentTransaction.setTransRef(courseName);

                paymentTransactionService.createPaymentTransactionPurchase(userEntity, paymentTransaction);
                purchaseCartService.saveCart(userEntity, course, purchaseCart);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed");
        }
        return purchaseCart;
    }

    @RequestMapping(value = "getPurchaseCart/{id}", method = RequestMethod.GET)
    public PurchaseCart getPurchaseCartId(@PathVariable("id") Long id) {
        return purchaseCartService.getPurchaseCartId(id);
    }

    @RequestMapping(value = "getPurchaseCartList", method = RequestMethod.GET)
    public List<PurchaseCart> getPurchaseCartList() {
        return purchaseCartService.getPurchaseCartList();
    }

}