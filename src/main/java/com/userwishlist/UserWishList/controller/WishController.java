package com.userwishlist.UserWishList.controller;

import com.userwishlist.UserWishList.entity.Customer;
import com.userwishlist.UserWishList.entity.WishListItem;
import com.userwishlist.UserWishList.security.JwtTokenProvider;
import com.userwishlist.UserWishList.service.CustomerService;
import com.userwishlist.UserWishList.service.WIshListService;
import com.userwishlist.UserWishList.utility.Common;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.userwishlist.UserWishList.utility.Response;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wish")
@Validated
public class WishController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private WIshListService wIshListService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/create-customer")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){



        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/get-customer/{usernameOrEmail}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String usernameOrEmail, HttpServletRequest request){

        String username = Common.getUserNameFromRequest(request,jwtTokenProvider);
        Customer customer = customerService.getCustomer(usernameOrEmail);
        if(customer.getEmail().equals(username) || customer.getUsername().equals(username)){
            return new ResponseEntity<>(customerService.getCustomer(usernameOrEmail), HttpStatus.ACCEPTED);
        }else {
            throw new AuthorizationServiceException("You cannot fetch details of other customer");
        }


    }

    @PostMapping("/create-wishlist/{usernameOrEmail}")
    public ResponseEntity<WishListItem> createWishList(@RequestBody WishListItem wishListItem,
                                                       @PathVariable String usernameOrEmail,HttpServletRequest request){

        String username = Common.getUserNameFromRequest(request,jwtTokenProvider);
        Customer customer = customerService.getCustomer(usernameOrEmail);
        if(customer.getEmail().equals(username) || customer.getUsername().equals(username)){
            return new ResponseEntity<>(wIshListService.createWishListItem(wishListItem,usernameOrEmail), HttpStatus.CREATED);
        }else {
            throw new AuthorizationServiceException("You cannot create wishListItem of other customer");
        }

    }

    @GetMapping("/get-wishList/{usernameOrEmail}")
    public ResponseEntity<Set<WishListItem>> getWishList(@PathVariable String usernameOrEmail,HttpServletRequest request){

        String username = Common.getUserNameFromRequest(request,jwtTokenProvider);
        Customer customer = customerService.getCustomer(usernameOrEmail);
        if(customer.getEmail().equals(username) || customer.getUsername().equals(username)){
            return new ResponseEntity<>(wIshListService.getAllWishListByCus(usernameOrEmail), HttpStatus.ACCEPTED);
        }else {
            throw new AuthorizationServiceException("You cannot fetch wishList of other customer");
        }

    }

    @DeleteMapping("/delete-wishlistItem/{usernameOrEmail}/{wishId}")
    public ResponseEntity<Response> deleteWishList(@PathVariable Integer wishId,@PathVariable String usernameOrEmail,HttpServletRequest request){

        String username = Common.getUserNameFromRequest(request,jwtTokenProvider);
        Customer customer = customerService.getCustomer(usernameOrEmail);
        if(customer.getEmail().equals(username) || customer.getUsername().equals(username)){
            return new ResponseEntity<>(wIshListService.deleteWishList(wishId), HttpStatus.OK);
        }else {
            throw new AuthorizationServiceException("You cannot fetch wishList of other customer");
        }

    }
}
