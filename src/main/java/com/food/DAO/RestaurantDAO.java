package com.food.DAO;

import java.util.List;

import com.food.model.Restaurant;

public interface RestaurantDAO {

    // Add Restaurant
    boolean addRestaurant(Restaurant restaurant);


    // Get Restaurant by ID
    Restaurant getRestaurantById(int restaurantId);


    // Get All Restaurants
    List<Restaurant> getAllRestaurants();


    // Update Restaurant
    boolean updateRestaurant(Restaurant restaurant);


    // Delete Restaurant
    boolean deleteRestaurant(int restaurantId);


    // Get Active Restaurants
    List<Restaurant> getActiveRestaurants();


    // Get Restaurants by Cuisine
    List<Restaurant> getRestaurantsByCuisine(String cuisineType);

    
    List<Restaurant> getRestaurantsByAdminUserId(int adminUserId);


    // Update Active Status
    boolean updateRestaurantStatus(int restaurantId, boolean isActive);

}