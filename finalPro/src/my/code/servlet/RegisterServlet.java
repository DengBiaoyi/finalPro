package my.code.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.code.implDao.CheckUserHelper;
import my.code.implDao.RegisterUserImpl;
import my.code.object.User;
import my.code.object.UserInfo;
import my.code.utils.MD5;

public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("TAG", "register");
		String name = req.getParameter("name");
		String department = req.getParameter("department");
		String job = req.getParameter("job");
		String password = MD5.getMD5(req.getParameter("password"));
		UserInfo userInfo = new UserInfo(name, job, department);
		User user = new User(userInfo, password);
		CheckUserHelper helper = new CheckUserHelper();
		try {
			if(helper.isExist(name)){
				req.setAttribute("msg", "userExist");
			}else{
				RegisterUserImpl register = new RegisterUserImpl();
				if(register.register(user)){
					req.setAttribute("msg", "success");
				}else{
					req.setAttribute("msg", "userExist");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ServletContext context=getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/skip");
		dispatcher.forward(req, resp);
	}

}
