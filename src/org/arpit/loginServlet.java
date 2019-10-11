package org.arpit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.getData;

@WebServlet("/log_him_in")
public class loginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			String uname = req.getParameter("uname");
			String pass = req.getParameter("pass");
			getData gd = new getData();
			ResultSet rs = gd.giveme(uname, pass);
			rs.next();
			PrintWriter out = res.getWriter();
			if (rs.getString("pass").equals(pass)) {
				out.println("ok");
			} else {
				out.println("try again");
			}

		} catch (Exception e) {
			System.out.println(e);
			PrintWriter out = res.getWriter();
			out.println("try again");
		}
	}
}
