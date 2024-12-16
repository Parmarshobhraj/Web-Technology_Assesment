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

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
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

		        String password = request.getParameter("password");
		        String confirmPassword = request.getParameter("confirmPassword");

		        if (!password.equals(confirmPassword)) {
		            response.sendRedirect("resetpassword.jsp?error=Passwords do not match");
		            return;
		        }

		        HttpSession session = request.getSession();
		        String email = (String) session.getAttribute("email");

		        if (UserDao.UpdatePassword(email, password)) {
		            session.invalidate();
		            response.sendRedirect("login.jsp?message=Password reset successful");
		        } else {
		            response.sendRedirect("resetpassword.jsp?error=Failed to reset password");
		        }
		    }
		
	}


