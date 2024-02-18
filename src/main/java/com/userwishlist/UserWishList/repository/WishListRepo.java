package com.userwishlist.UserWishList.repository;

import com.userwishlist.UserWishList.entity.Customer;
import com.userwishlist.UserWishList.entity.WishListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface WishListRepo extends JpaRepository<WishListItem,Integer> {


    Set<WishListItem> findByCustomer(Customer customer);

}
