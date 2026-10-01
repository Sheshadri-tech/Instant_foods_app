package com.food.DAOImpl;

import com.food.DAO.RestaurantDAO;
import com.food.model.Restaurant;
import com.food.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class RestaurantDAOImpl implements RestaurantDAO {


// ADD RESTAURANT
	
	
	
	@Override
	public List<Restaurant> getRestaurantsByAdminUserId(int adminUserId) {

	    List<Restaurant> restaurants = new ArrayList<>();

	    String query = "SELECT * FROM restaurant WHERE adminUserId = ?";

	    try {

	        Connection connection =
	                DBConnection.getConnection();

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(query);

	        preparedStatement.setInt(1, adminUserId);

	        ResultSet resultSet =
	                preparedStatement.executeQuery();

	        while (resultSet.next()) {

	            Restaurant restaurant =
	                    new Restaurant();

	            restaurant.setRestaurantId(
	                    resultSet.getInt("restaurantId")
	            );

	            restaurant.setName(
	                    resultSet.getString("name")
	            );

	            restaurant.setCuisineType(
	                    resultSet.getString("cuisineType")
	            );

	            restaurant.setDeliveryTime(
	                    resultSet.getInt("deliveryTime")
	            );

	            restaurant.setAddress(
	                    resultSet.getString("address")
	            );

	            restaurant.setRating(
	                    resultSet.getDouble("rating")
	            );

	            restaurant.setActive(
	                    resultSet.getBoolean("isActive")
	            );

	            restaurant.setImagePath(
	                    resultSet.getString("imagePath")
	            );

	            restaurants.add(restaurant);
	        }

	    }
	    catch (SQLException e) {

	        e.printStackTrace();
	    }

	    return restaurants;
	}
	
	
	

    @Override
    public boolean addRestaurant(Restaurant restaurant) {

        String query =
                "INSERT INTO restaurant " +
                "(name, cuisineType, deliveryTime, address, " +
                "adminUserId, rating, isActive, imagePath) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {

            preparedStatement.setString(
                    1,
                    restaurant.getName()
            );

            preparedStatement.setString(
                    2,
                    restaurant.getCuisineType()
            );

            preparedStatement.setInt(
                    3,
                    restaurant.getDeliveryTime()
            );

            preparedStatement.setString(
                    4,
                    restaurant.getAddress()
            );

            preparedStatement.setInt(
                    5,
                    restaurant.getAdminUserId()
            );

            preparedStatement.setDouble(
                    6,
                    restaurant.getRating()
            );

            preparedStatement.setBoolean(
                    7,
                    restaurant.isActive()
            );

            preparedStatement.setString(
                    8,
                    restaurant.getImagePath()
            );


            int rows =
                    preparedStatement.executeUpdate();


            return rows > 0;

        }
        catch (SQLException e) {

            e.printStackTrace();

        }


        return false;
    }



// GET RESTAURANT BY ID

    @Override
    public Restaurant getRestaurantById(
            int restaurantId
    ) {

        String query =
                "SELECT * FROM restaurant " +
                "WHERE restaurantId = ?";


        Restaurant restaurant =
                null;


        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {

            preparedStatement.setInt(
                    1,
                    restaurantId
            );


            ResultSet resultSet =
                    preparedStatement.executeQuery();


            if (resultSet.next()) {

                restaurant =
                        extractRestaurant(resultSet);
            }

        }
        catch (SQLException e) {

            e.printStackTrace();

        }


        return restaurant;
    }



// GET ALL RESTAURANTS

    @Override
    public List<Restaurant>
    getAllRestaurants() {


        List<Restaurant> restaurants =
                new ArrayList<>();


        String query =
                "SELECT * FROM restaurant";


        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query);

                ResultSet resultSet =
                        preparedStatement.executeQuery()
        ) {


            while (resultSet.next()) {

                Restaurant restaurant =
                        extractRestaurant(resultSet);


                restaurants.add(restaurant);
            }

        }
        catch (SQLException e) {

            e.printStackTrace();

        }


        return restaurants;
    }



// UPDATE RESTAURANT

    @Override
    public boolean updateRestaurant(
            Restaurant restaurant
    ) {


        String query =
                "UPDATE restaurant SET " +

                "name = ?, " +

                "cuisineType = ?, " +

                "deliveryTime = ?, " +

                "address = ?, " +

                "adminUserId = ?, " +

                "rating = ?, " +

                "isActive = ?, " +

                "imagePath = ? " +

                "WHERE restaurantId = ?";


        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {


            preparedStatement.setString(
                    1,
                    restaurant.getName()
            );


            preparedStatement.setString(
                    2,
                    restaurant.getCuisineType()
            );


            preparedStatement.setInt(
                    3,
                    restaurant.getDeliveryTime()
            );


            preparedStatement.setString(
                    4,
                    restaurant.getAddress()
            );


            preparedStatement.setInt(
                    5,
                    restaurant.getAdminUserId()
            );


            preparedStatement.setDouble(
                    6,
                    restaurant.getRating()
            );


            preparedStatement.setBoolean(
                    7,
                    restaurant.isActive()
            );


            preparedStatement.setString(
                    8,
                    restaurant.getImagePath()
            );


            preparedStatement.setInt(
                    9,
                    restaurant.getRestaurantId()
            );


            int rows =
                    preparedStatement.executeUpdate();


            return rows > 0;

        }
        catch (SQLException e) {

            e.printStackTrace();

        }


        return false;
    }



// DELETE RESTAURANT

    @Override
    public boolean deleteRestaurant(
            int restaurantId
    ) {


        String query =
                "DELETE FROM restaurant " +
                "WHERE restaurantId = ?";


        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {


            preparedStatement.setInt(
                    1,
                    restaurantId
            );


            int rows =
                    preparedStatement.executeUpdate();


            return rows > 0;

        }
        catch (SQLException e) {

            e.printStackTrace();

        }


        return false;
    }



// GET ACTIVE RESTAURANTS

    @Override
    public List<Restaurant>
    getActiveRestaurants() {


        List<Restaurant> restaurants =
                new ArrayList<>();


        String query =
                "SELECT * FROM restaurant " +
                "WHERE isActive = true";


        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query);

                ResultSet resultSet =
                        preparedStatement.executeQuery()
        ) {


            while (resultSet.next()) {


                Restaurant restaurant =
                        extractRestaurant(resultSet);


                restaurants.add(restaurant);

            }

        }
        catch (SQLException e) {

            e.printStackTrace();

        }


        return restaurants;
    }


// GET RESTAURANTS BY CUISINE

    @Override
    public List<Restaurant>
    getRestaurantsByCuisine(
            String cuisineType
    ) {


        List<Restaurant> restaurants =
                new ArrayList<>();


        String query =
                "SELECT * FROM restaurant " +
                "WHERE cuisineType LIKE ?";


        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {


            preparedStatement.setString(
                    1,
                    "%" + cuisineType + "%"
            );


            ResultSet resultSet =
                    preparedStatement.executeQuery();


            while (resultSet.next()) {


                Restaurant restaurant =
                        extractRestaurant(resultSet);


                restaurants.add(restaurant);

            }

        }
        catch (SQLException e) {

            e.printStackTrace();

        }


        return restaurants;
    }



// UPDATE RESTAURANT STATUS

    public boolean updateRestaurantStatus(
            int restaurantId,
            boolean isActive
    ) {


        String query =
                "UPDATE restaurant " +
                "SET isActive = ? " +
                "WHERE restaurantId = ?";


        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {


            preparedStatement.setBoolean(
                    1,
                    isActive
            );


            preparedStatement.setInt(
                    2,
                    restaurantId
            );


            int rows =
                    preparedStatement.executeUpdate();


            return rows > 0;

        }
        catch (SQLException e) {

            e.printStackTrace();

        }


        return false;
    }



// RESULTSET TO RESTAURANT OBJECT

    private Restaurant extractRestaurant(
            ResultSet resultSet
    )
            throws SQLException {


        Restaurant restaurant =
                new Restaurant();


        restaurant.setRestaurantId(

                resultSet.getInt(
                        "restaurantId"
                )
        );


        restaurant.setName(

                resultSet.getString(
                        "name"
                )
        );


        restaurant.setCuisineType(

                resultSet.getString(
                        "cuisineType"
                )
        );


        restaurant.setDeliveryTime(

                resultSet.getInt(
                        "deliveryTime"
                )
        );


        restaurant.setAddress(

                resultSet.getString(
                        "address"
                )
        );


        restaurant.setAdminUserId(

                resultSet.getInt(
                        "adminUserId"
                )
        );


        restaurant.setRating(

                resultSet.getDouble(
                        "rating"
                )
        );


        restaurant.setActive(

                resultSet.getBoolean(
                        "isActive"
                )
        );


        restaurant.setImagePath(

                resultSet.getString(
                        "imagePath"
                )
        );


        return restaurant;
    }



}