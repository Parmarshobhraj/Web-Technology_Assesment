package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

import java.io.*;
/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		        String firstName = request.getParameter("firstName");
		        String lastName = request.getParameter("lastName");
		        String email = request.getParameter("email");
		        String password = request.getParameter("password");
		        String confirmPassword = request.getParameter("confirmPassword");

		        if (!password.equals(confirmPassword)) {
		            response.sendRedirect("signup.jsp?error=Passwords do not match");
		            return;
		        }

		        if (UserDao.isEmailRegistered(email)) {
		            response.sendRedirect("signup.jsp?error=Email already registered");
		        } else {
		            User user = new User();
		            user.setFirstName(firstName);
		            user.setLastName(lastName);
		            user.setEmail(email);
		            user.setPassword(password);

		            boolean isRegistered = UserDao.registerUser(user);
		            response.sendRedirect(isRegistered ? "login.jsp" : "signup.jsp?error=Registration failed");
		        }
		    }
		
	}


