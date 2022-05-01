package myApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SaveDetails
 */
@WebServlet("/SaveDetails")
public class SaveDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost/StudDetails";
		String user = "root";
		String password = "Your DataBase Password";
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			String query = "INSERT INTO Student(RollNo,Name,Phone)"+" values(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			
			String name = request.getParameter("name");
			int rollNo = Integer.parseInt(request.getParameter("RollNo"));
			String phone = request.getParameter("phone");
			ps.setInt(1, rollNo);
			ps.setString(2, name);
			ps.setString(3, phone);
			PreparedStatement ps2 = connection.prepareStatement("select RollNo,Name,Phone from Student where RollNo=? and Name =? and Phone=?");
			ps2.setInt(1, rollNo);
			ps2.setString(2, name);
			ps2.setString(3, phone);
			ResultSet resultSet = ps2.executeQuery();
			if(resultSet.next()) {
				response.sendRedirect("error.html");
			}
			else {
				ps.execute();
				response.sendRedirect("success.html");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occurred......");
		}
	}




}
