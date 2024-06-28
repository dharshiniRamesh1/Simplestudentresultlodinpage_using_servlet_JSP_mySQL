package studentmarklogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class regserv
 */
@WebServlet("/regserv")
public class regserv extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter(); 
		String E_id = req.getParameter("email");
		String pass = req.getParameter("password");
		
		try {
			
			String str = "select email,password from studentmark where email=? and password = ?";
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement ps = cn.prepareStatement(str);
			ps.setString(1, E_id);
			ps.setString(2, pass);
			
			
           ResultSet rs = ps.executeQuery();
          
			if(rs.next()) {
				
				
				RequestDispatcher r = req.getRequestDispatcher("reg.html");
				try {
					r.include(req, res);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				HttpSession htp = req.getSession();
				htp.setAttribute("un", E_id);
				htp.setAttribute("pa", pass);
				
				pw.println("login success");
				
				
				
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("reg.html");
				try {
					rd.forward(req, res);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}