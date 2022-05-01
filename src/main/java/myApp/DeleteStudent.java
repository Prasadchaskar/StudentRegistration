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

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost/StudDetails";
		String user = "root";
		String password = "Your DataBase Password";
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			int rollno = Integer.parseInt(request.getParameter("rollno"));
			String query = "Delete From Student WHERE RollNo=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, rollno);
			ps.execute();
			response.sendRedirect("success.html");
		} catch (Exception e) {
			System.out.println("Exception Occured");
			response.sendRedirect("error.html");
		}
	}


}
