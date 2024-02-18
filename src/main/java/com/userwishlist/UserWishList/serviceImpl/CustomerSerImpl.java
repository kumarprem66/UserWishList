package com.userwishlist.UserWishList.serviceImpl;

import com.userwishlist.UserWishList.entity.Customer;
import com.userwishlist.UserWishList.exception.CustomerExistException;
import com.userwishlist.UserWishList.repository.CustomerRepo;
import com.userwishlist.UserWishList.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerSerImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer createCustomer(Customer customer) throws CustomerExistException {

        Optional<Customer> optionalCustomer = customerRepo.findByUsernameOrEmail(customer.getUsername(),customer.getEmail());
        if (optionalCustomer.isPresent()){
            throw new CustomerExistException("Customer with username or email already exist..");
        }else{

            return customerRepo.save(customer);
        }
    }

    @Override
    public Customer getCustomer(String usernameOrEmail) throws CustomerExistException {
        Optional<Customer> optionalCustomer = customerRepo.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail);
        if (optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }else{

            throw new CustomerExistException("Customer with username or email already exist..");

        }
    }
}
