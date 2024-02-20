package com.userwishlist.UserWishList.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class WishControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateCustomer() throws Exception {
        // Valid customer object
        String validCustomerJson = "{\"name\":\"Prem Kumar\",\"username\":\"premkumar\",\"email\":\"premkumar@example.com\",\"password\":\"testpass\"}";
        mockMvc.perform(post("/create-customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validCustomerJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("premkumar"))
                .andExpect(jsonPath("$.email").value("john@example.com"));

        // Edge case: Empty customer object
        mockMvc.perform(post("/create-customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());

        // Error handling: Unauthorized access (missing authentication token)
        mockMvc.perform(post("/create-customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validCustomerJson))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testGetCustomer() throws Exception {
        // Existing customer with valid username
        String existingUsername = "existingUser";
        mockMvc.perform(get("/get-customer/{usernameOrEmail}", existingUsername))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(existingUsername));

        // Edge case: Non-existing customer
        String nonExistingUsername = "nonExistingUser";
        mockMvc.perform(get("/get-customer/{usernameOrEmail}", nonExistingUsername))
                .andExpect(status().isNotFound());

        // Error handling: Invalid username (null)
        mockMvc.perform(get("/get-customer/null"))
                .andExpect(status().isBadRequest());

        // Error handling: Unauthorized access (missing authentication token)
        mockMvc.perform(get("/get-customer/{usernameOrEmail}", existingUsername))
                .andExpect(status().isUnauthorized());
    }



    @Test
    public void testGetWishList() throws Exception {
        // Existing customer with valid username
        String existingUsername = "existingUser";
        mockMvc.perform(get("/get-wishList/{usernameOrEmail}", existingUsername))
                .andExpect(status().isOk());

        // Error handling: Non-existing username
        String nonExistingUsername = "nonExistingUser";
        mockMvc.perform(get("/get-wishList/{usernameOrEmail}", nonExistingUsername))
                .andExpect(status().isNotFound());

        // Error handling: Unauthorized access (missing authentication token)
        mockMvc.perform(get("/get-wishList/{usernameOrEmail}", existingUsername))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testCreateWishList() throws Exception {
        // Valid wish list item and existing username
        String validWishListItemJson = "{\"name\":\"iPhone\",\"description\":\"Latest iPhone model\",\"price\":1000}";
        String existingUsername = "existingUser";
        mockMvc.perform(post("/create-wishlist/{usernameOrEmail}", existingUsername)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validWishListItemJson))
                .andExpect(status().isCreated());

        // Edge case: Empty wish list item
        mockMvc.perform(post("/create-wishlist/{usernameOrEmail}", existingUsername)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());

        // Error handling: Non-existing username
        String nonExistingUsername = "nonExistingUser";
        mockMvc.perform(post("/create-wishlist/{usernameOrEmail}", nonExistingUsername)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validWishListItemJson))
                .andExpect(status().isNotFound());

        // Error handling: Unauthorized access (missing authentication token)
        mockMvc.perform(post("/create-wishlist/{usernameOrEmail}", existingUsername)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validWishListItemJson))
                .andExpect(status().isUnauthorized());
    }


    @Test
    public void testDeleteWishList() throws Exception {
        // Existing customer with valid username and wish ID
        String existingUsername = "existingUser";
        Integer existingWishId = 1;
        mockMvc.perform(delete("/delete-wishlistItem/{usernameOrEmail}/{wishId}", existingUsername, existingWishId))
                .andExpect(status().isOk());

        // Error handling: Non-existing username
        String nonExistingUsername = "nonExistingUser";
        mockMvc.perform(delete("/delete-wishlistItem/{usernameOrEmail}/{wishId}", nonExistingUsername, existingWishId))
                .andExpect(status().isNotFound());

        // Error handling: Unauthorized access (missing authentication token)
        mockMvc.perform(delete("/delete-wishlistItem/{usernameOrEmail}/{wishId}", existingUsername, existingWishId))
                .andExpect(status().isUnauthorized());
    }

    }
