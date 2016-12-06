package my.code.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SkipServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String tag = (String) req.getAttribute("TAG");
		if(tag.equals("login")){
			login(req, resp);
		}else if(tag.equals("register")){
			register(req, resp);
		}else if(tag.equals("logout")){
			logout(req, resp);
		}else if(tag.equals("leave")){
			leave(req, resp);
		}else if(tag.equals("changePwd")){
			changePwd(req, resp);
		}
	}
	private void changePwd(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		Boolean bl = (Boolean)req.getAttribute("isTrue");
		
		if(bl.equals(true)){
			req.setAttribute("target", "/finalPro/front/login.html");
			req.setAttribute("pic", "ok");
			req.setAttribute("info", "修改密码成功，请重新登录");
			getServletContext().getRequestDispatcher("/front/skip.jsp").forward(req, resp);
		
		}else{
			req.setAttribute("target", "/finalPro/front/changePwd.jsp");
			req.setAttribute("pic", "error");
			req.setAttribute("info", "密码输入错误，请重新输入!");
			getServletContext().getRequestDispatcher("/front/skip.jsp").forward(req, resp);
		}
	}
	private void leave(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		req.setAttribute("target", "/finalPro/front/leave.jsp");
		req.setAttribute("pic", "ok");
		req.setAttribute("info", "提交申请成功，请等待审核!");
		getServletContext().getRequestDispatcher("/front/skip.jsp").forward(req, resp);
	
		
	}
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setAttribute("target", "/finalPro/front/login.html");
		req.setAttribute("pic", "ok");
		req.setAttribute("info", "注销成功");
		getServletContext().getRequestDispatcher("/front/skip.jsp").forward(req, resp);
	}
	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String string = (String) req.getAttribute("msg");
		if(string.equals("success")){
			//resp.sendRedirect("/finalPro/front/leave.jsp");
			req.setAttribute("target", "/finalPro/front/login.html");
			req.setAttribute("pic", "ok");
			req.setAttribute("info", "注册成功");
		}else{
			//resp.sendRedirect("/finalPro/front/login.html");
			req.setAttribute("pic", "error");
			req.setAttribute("info", "该用户已存在");
			req.setAttribute("target", "/finalPro/front/register.jsp");
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/front/skip.jsp");
		dispatcher.forward(req, resp);
	}
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String string = (String) req.getAttribute("msg");
		if(string.equals("loginSuccess")){
			String isAdmin = (String)req.getAttribute("admin");
			if(isAdmin!=null){
				req.setAttribute("target", "/finalPro/admin/allRecord.jsp");
				req.setAttribute("pic", "ok");
				req.setAttribute("info", "登录成功");
			}else{
				req.setAttribute("target", "/finalPro/front/record.jsp");
				req.setAttribute("pic", "ok");
				req.setAttribute("info", "登录成功");
			}
		}else{
			req.setAttribute("pic", "error");
			req.setAttribute("info", "登录失败");
			req.setAttribute("target", "/finalPro/front/login.html");
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/front/skip.jsp");
		dispatcher.forward(req, resp);
	}
}

