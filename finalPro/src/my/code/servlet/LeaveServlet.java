package my.code.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.qos.cal10n.LocaleData;
import my.code.implDao.LeaveImpl;
import my.code.object.UserInfo;
import my.code.utils.DataString;

public class LeaveServlet extends HttpServlet{
	private String name;
	private String department;
	private String job;
	private String year;
	private String month;
	private String day;
	private int leaveDay;
	private String type;
	private String reason;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("TAG","leave" );
		getData(req, resp);
		Date date = new Date(Integer.parseInt(year)-1900,
				Integer.parseInt(month)-1,Integer.parseInt(day));
		UserInfo user = new UserInfo(name, job, department);
		LeaveImpl leave = new LeaveImpl();
		try {
			leave.addLeave(user, date, leaveDay, type, reason);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/skip");
		requestDispatcher.forward(req, resp);
		//print();
	}
	private void getData(HttpServletRequest req, HttpServletResponse resp){
		name = req.getParameter("name");
		department = req.getParameter("department");
		job = req.getParameter("job");
		year = req.getParameter("year");
		month = req.getParameter("month");
		day = req.getParameter("day");
		leaveDay = Integer.valueOf(req.getParameter("leaveDays"));
		type = req.getParameter("type");
		reason = req.getParameter("reason");
	}
	private void print(){
		System.out.println("name "+name);
		System.out.println("department "+department);
		System.out.println("job "+job);
		System.out.println("year "+year);
		System.out.println("month "+month);
		System.out.println("day "+day);
		System.out.println("leaveDay "+leaveDay);
		System.out.println("type "+type);
		System.out.println("reason "+reason);
	}
}
