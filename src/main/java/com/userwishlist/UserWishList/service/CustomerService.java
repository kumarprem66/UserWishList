package com.userwishlist.UserWishList.service;

import com.userwishlist.UserWishList.entity.Customer;
import com.userwishlist.UserWishList.exception.CustomerExistException;

public interface CustomerService {


    Customer createCustomer(Customer customer) throws CustomerExistException;


    Customer getCustomer(String usernameOrEmail) throws CustomerExistException;
}
