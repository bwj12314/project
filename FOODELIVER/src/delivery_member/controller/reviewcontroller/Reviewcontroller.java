package delivery_member.controller.reviewcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.action.Action;
import delivery_member.action.reviewwriteAction;
import delivery_member.vo.ActionForward;




@WebServlet("*.review")
public class Reviewcontroller extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
	
		System.out.println(command);
		if(command.equals("/reviewform.review")) {
			String company_id=request.getParameter("company_id");
			String company_name=request.getParameter("company_name");
			String member_id=request.getParameter("member_id");
			String menu=request.getParameter("menu");
			
			
			request.setAttribute("company_id", company_id);
			request.setAttribute("company_name", company_name);
			request.setAttribute("member_id", member_id);
			request.setAttribute("menu", menu);
	
			forward = new ActionForward("review/review_writeform.jsp",false);
		}
		else if(command.equals("/reviewwrite.review")) {
			action=new reviewwriteAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		if (forward != null) {

			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
