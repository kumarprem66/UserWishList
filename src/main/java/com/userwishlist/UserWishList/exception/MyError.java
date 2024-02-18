package com.userwishlist.UserWishList.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyError {

	private LocalDateTime localDateTime;
	private String message;
	private String details;

}
