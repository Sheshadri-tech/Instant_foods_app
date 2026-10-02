package com.food.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.food.DAO.UserDAO;
import com.food.model.User;
import com.food.util.DBConnection;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean registerUser(User user) {

		String sql =
		"INSERT INTO users(username,email,password) VALUES(?,?,?)";

		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			return ps.executeUpdate() > 0;

		} catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User loginUser(String email, String password) {

		String sql =
		"SELECT * FROM users WHERE email=? AND password=?";

		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {

				User user = new User();

				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));

				return user;
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}