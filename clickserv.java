package studentmarklogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/clickserv")
public class clickserv extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw  = res.getWriter();

		RequestDispatcher re = req.getRequestDispatcher("regis.html");
		re.include(req, res);
		
		HttpSession hst = req.getSession();
		
		String s = (String) hst.getAttribute("un");
		String s1 = (String) hst.getAttribute("pa");
		pw.println("welcome" + " " + s);
		
		HttpSession ht = req.getSession();
		ht.setAttribute("na", s);
		ht.setAttribute("an", s1);
//		

	}

}
