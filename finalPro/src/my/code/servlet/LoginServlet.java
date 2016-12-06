package my.code.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.jms.Session;
import javax.print.DocFlavor.STRING;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.code.implDao.CheckUserHelper;
import my.code.utils.MD5;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("TAG", "login");
		String name = req.getParameter("name");
		String password = MD5.getMD5(req.getParameter("password"));
		System.out.println(name+""+password);
		
		CheckUserHelper check = new CheckUserHelper();
		ServletContext context=getServletContext();
		RequestDispatcher requestDispatcher;
		try {
			if(check.isRight(name, password))
			{
				System.out.println("登录成功");
				HttpSession session = req.getSession();
				session.setAttribute("name", name);
				System.out.println(session.getId()+" "+session.isNew());
				req.setAttribute("msg", "loginSuccess");
			}else{
				System.out.println("用户名或密码错误");
//				resp.sendRedirect("front/login.html");
				req.setAttribute("msg", "loginFail");
			}
			requestDispatcher = context.getRequestDispatcher("/skip");
			requestDispatcher.forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
