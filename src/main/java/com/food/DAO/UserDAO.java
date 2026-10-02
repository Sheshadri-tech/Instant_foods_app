package com.food.DAO;

import com.food.model.User;

public interface UserDAO {

	boolean registerUser(User user);

	User loginUser(String email, String password);
}