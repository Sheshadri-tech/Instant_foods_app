package com.food.servlet;

import java.io.IOException;

import com.food.DAO.UserDAO;
import com.food.DAOImpl.UserDAOImpl;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String email =
				request.getParameter("email");

		String password =
				request.getParameter("password");

		UserDAO dao =
				new UserDAOImpl();

		User user =
				dao.loginUser(email,password);

		if(user != null) {

			HttpSession session =
					request.getSession();

			session.setAttribute("user", user);

			response.sendRedirect("RestaurantServlet");

		} else {

			response.sendRedirect("login.jsp");
		}
	}
}