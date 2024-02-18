package com.userwishlist.UserWishList.service;

import com.userwishlist.UserWishList.entity.WishListItem;
import com.userwishlist.UserWishList.utility.Response;

import java.util.Set;

public interface WIshListService {
    
     WishListItem createWishListItem(WishListItem wishListItem,String usernameOrEmail);

     Set<WishListItem> getAllWishListByCus(String usernameOrEmail);

    Response deleteWishList(Integer id);

    
    
}
