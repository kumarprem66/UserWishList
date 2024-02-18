package com.userwishlist.UserWishList.controller;


import com.userwishlist.UserWishList.entity.Customer;
import com.userwishlist.UserWishList.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class AuthenticationController {

    @Autowired
    private CustomerService userService;




    @GetMapping("/signin")
    public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){


            System.out.println(auth);

            Customer customer= userService.getCustomer(auth.getName());

            return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);



    }











}
