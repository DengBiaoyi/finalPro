package my.code.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.print.DocFlavor.STRING;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.code.implDao.ChangePwdImpl;
import my.code.utils.MD5;

public class ChangePwdServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		req.setAttribute("TAG", "changePwd");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String newPassword = req.getParameter("newPassword");
		System.out.println(name+" "+password+" "+newPassword);
		ChangePwdImpl change = new ChangePwdImpl();
		
		boolean bl;
		try {
			bl = change.changePwd(name, MD5.getMD5(password), MD5.getMD5(newPassword));
		} catch (SQLException e) {
			System.err.println(e);
			bl=false;
		}
		System.out.println(bl);
		req.setAttribute("isTrue", bl);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/skip");
		requestDispatcher.forward(req, resp);
	}

}
