package studentmarklogin;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class boardserv
 */
@WebServlet("/boardserv")
public class boardserv extends HttpServlet {
 
		
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			PrintWriter pw  = res.getWriter();
			
				HttpSession hst = req.getSession();
			
			String s = (String) hst.getAttribute("na");
			String s1 = (String) hst.getAttribute("an");
			
			pw.println("welcome to dahboard");
			try {
				String str = "select mark1,mark2 from studentmark where email=? and password = ?";
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
				PreparedStatement ps = cn.prepareStatement(str);
				
				ps.setString(1, s);
				ps.setString(2, s1);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int m1 = rs.getInt("mark1");
					int m2 = rs.getInt("mark2");
					//String stat = rs.getString("status");
					
					pw.print(" Mark1 " + m1 + " Mark2 " + m2 );
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
