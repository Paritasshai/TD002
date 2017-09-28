package com.tamdai.model.purchaseCart.controller;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.service.CourseService;
import com.tamdai.model.payment.entity.PaymentTransaction;
import com.tamdai.model.payment.repository.PaymentTransactionRepository;
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
                                 @RequestParam("courseId") Long courseId,
                                 @RequestParam("transAmount") String transAmount,
                                 @RequestParam("Balance") String balance, BindingResult bindingResult) {
        UserEntity userEntity = userService.getUserId(userId);
        Course course = courseService.getCourseId(courseId);

        try {

            userEntity.setBalance(balance);
            userRepository.save(userEntity);

            PaymentTransaction paymentTransaction = new PaymentTransaction();

            //CreateDate
            String transDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            paymentTransaction.setCreateDate(transDate);

            //CreateTime
            String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
            paymentTransaction.setCreateTime(timeStamp);

            String transA = new String(transAmount);
            paymentTransaction.setTransAmount(transA);

            String transRe = new String(balance);
            paymentTransaction.setTransRemark(transRe);

            paymentTransactionService.createPaymentTransactionPurchase(userEntity, paymentTransaction);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return purchaseCartService.saveCart(userEntity, course, purchaseCart);
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
