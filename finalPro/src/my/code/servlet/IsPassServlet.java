package my.code.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.code.dao.Update;
import my.code.implDao.UpdateImpl;

public class IsPassServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		UpdateImpl update = new UpdateImpl();
		String id = req.getParameter("id");
		System.out.println(id);
		String isPass = req.getParameter("isPass");
		if(isPass.equals("pass")){
			try {
				update.pass(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(isPass.equals("depass")){
			String reReason = req.getParameter("reReason");
			if(reReason==null) reReason="";
			try {
				update.depass(id, reReason);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		getServletContext().getRequestDispatcher("/admin/isDo.jsp").forward(req, resp);

	}

}
