package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

import java.io.*;
import java.util.Random;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		        String email = request.getParameter("email");

		        if (!UserDao.isEmailRegistered(email)) {
		            response.sendRedirect("forgotpassword.jsp?error=Email not registered");
		            return;
		        }

		        // Generate OTP
		        String otp = String.valueOf(new Random().nextInt(999999));

		        // Save OTP in session (or database for more robust implementation)
		        HttpSession session = request.getSession();
		        session.setAttribute("otp", otp);
		        session.setAttribute("email", email);

		        // Send OTP to email (Dummy for demo purposes)
		        System.out.println("OTP sent to " + email + ": " + otp);

		        response.sendRedirect("verifyotp.jsp");
		    }
		
	}


