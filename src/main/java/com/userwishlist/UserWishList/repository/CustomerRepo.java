package com.userwishlist.UserWishList.repository;

import com.userwishlist.UserWishList.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByUsername(String username);

    Optional<Customer> findByUsernameOrEmail(String username,String email);
    Optional<Customer> findByEmail(String email);

}
