package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.Query;

import connectivity.DbConnection;
import model.User;

public class UserDao {

	    public static boolean isEmailRegistered(String email) {
	        try (Connection conn = DbConnection.getConnection()) {
	            String query = "SELECT * FROM student WHERE email=?";
	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();
	            return rs.next();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public static boolean registerUser(User user) {
	        try (Connection conn = DbConnection.getConnection()) {
	            String query = "INSERT INTO student (first_name, last_name, email, mobile, address, gender, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setString(1, user.getFirstName());
	            ps.setString(2, user.getLastName());
	            ps.setString(3, user.getEmail());
	            ps.setString(4, user.getMobile());
	            ps.setString(5, user.getAddress());
	            ps.setString(6, user.getGender());
	            ps.setString(7, user.getPassword());
	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public static boolean validateLogin(String email, String password) {
	        try (Connection conn = DbConnection.getConnection()) {
	            String query = "SELECT * FROM student WHERE email=? AND password=?";
	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setString(1, email);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            return rs.next();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	        public static boolean UpdatePassword(String email, String password) {
	        	try (Connection conn = DbConnection.getConnection()) {
	                String quary = "UPDATE student SET password = ? WHERE email = ?";
	                PreparedStatement ps = conn.prepareStatement(quary);
	                ps.setString(1, email);
		            ps.setString(2, password);
		            ResultSet rs = ps.executeQuery();
		            return rs.next();
	        	} catch(Exception e) {
	        		e.printStackTrace();
	        		return false;
	        	}
	    }
	    
}



