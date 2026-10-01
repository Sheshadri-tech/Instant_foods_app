package com.food.util;

import com.food.DAOImpl.RestaurantDAOImpl;
import com.food.model.Restaurant;
import java.util.List;

public class UpdateRestaurantImages {

    public static void main(String[] args) {
        RestaurantDAOImpl dao = new RestaurantDAOImpl();
        List<Restaurant> restaurants = dao.getAllRestaurants();
        
        // A list of high-quality Unsplash images for various foods
        String[] imageUrls = {
            "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?q=80&w=2070&auto=format&fit=crop", // Fine Dining
            "https://images.unsplash.com/photo-1555396273-367ea4eb4db5?q=80&w=1974&auto=format&fit=crop", // Cafe/Bistro
            "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?q=80&w=1981&auto=format&fit=crop", // Pizza
            "https://images.unsplash.com/photo-1585937421612-70a008356fbe?q=80&w=2036&auto=format&fit=crop", // Sushi/Asian
            "https://images.unsplash.com/photo-1564834724105-918b73d1b9e0?q=80&w=1976&auto=format&fit=crop", // South Indian / Spices
            "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?q=80&w=1980&auto=format&fit=crop", // Tacos/Mexican
            "https://images.unsplash.com/photo-1414235077428-338989a2e8c0?q=80&w=2070&auto=format&fit=crop"  // Gourmet
        };

        if (restaurants.isEmpty()) {
            System.out.println("No restaurants found in the database to update.");
            return;
        }

        int count = 0;
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant r = restaurants.get(i);
            
            // Cycle through the image list so every restaurant gets a nice image
            String newImage = imageUrls[i % imageUrls.length]; 
            r.setImagePath(newImage);
            
            boolean success = dao.updateRestaurant(r);
            if(success) {
                System.out.println("Updated Image for: " + r.getName());
                count++;
            }
        }
        
        System.out.println("Successfully updated " + count + " restaurants!");
    }
}
