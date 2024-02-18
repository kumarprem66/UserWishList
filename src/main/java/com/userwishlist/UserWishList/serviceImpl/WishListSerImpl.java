package com.userwishlist.UserWishList.serviceImpl;

import com.userwishlist.UserWishList.entity.Customer;
import com.userwishlist.UserWishList.entity.WishListItem;
import com.userwishlist.UserWishList.exception.CustomerExistException;
import com.userwishlist.UserWishList.exception.WishListException;
import com.userwishlist.UserWishList.repository.CustomerRepo;
import com.userwishlist.UserWishList.repository.WishListRepo;
import com.userwishlist.UserWishList.service.WIshListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.userwishlist.UserWishList.utility.Response;

import java.util.Optional;
import java.util.Set;

@Service
public class WishListSerImpl implements WIshListService {

    @Autowired
    private WishListRepo wishListRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public WishListItem createWishListItem(WishListItem wishListItem,String usernameOrEmail) {

        Optional<WishListItem> optionalWishListItem = wishListRepo.findById(wishListItem.getId());
        Optional<Customer> optionalCustomer = customerRepo.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail);
        if(optionalWishListItem.isPresent()){

            throw new WishListException("WishListItem is already exist");
        }else{
            if(optionalCustomer.isPresent()){
                wishListItem.setCustomer(optionalCustomer.get());
                return wishListRepo.save(wishListItem);
            }else{
                throw new CustomerExistException("Customer with this userName does not exist");
            }

        }

    }



    @Override
    public Set<WishListItem> getAllWishListByCus(String userNameOrEmail) {
        Optional<Customer> customerOptional = customerRepo.findByUsernameOrEmail(userNameOrEmail,userNameOrEmail);
        if(customerOptional.isPresent()){
            return wishListRepo.findByCustomer(customerOptional.get());
        }else {
            throw new CustomerExistException("Customer with given username or email does not exist");
        }

    }

    @Override
    public Response deleteWishList(Integer id) {
        Optional<WishListItem> wishListItemOptional = wishListRepo.findById(id);
        if(wishListItemOptional.isPresent()){
             wishListRepo.delete(wishListItemOptional.get());
             return new Response("WishListItem deleted Successfully");
        }else{
            throw new WishListException("WishListItem does not exist..");
        }

    }


}
