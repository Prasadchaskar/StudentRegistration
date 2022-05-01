package myApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost/StudDetails";
		String user = "root";
		String password = "Your DataBase Password";
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			String phone = request.getParameter("phone");
			String name = request.getParameter("name");
			String query = "UPDATE Student SET Phone=? WHERE Name=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, phone);
			ps.setString(2, name);
			ps.execute();
			response.sendRedirect("success.html");
		} catch (Exception e) {
			System.out.println("Exception Occured");
			response.sendRedirect("error.html");
		}
	}


}
