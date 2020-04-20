package delivery_member.admincontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.adminaction.Action;
import delivery_member.adminaction.Member_admin_ListAction;
import delivery_member.adminaction.Member_admin_delAction;
import delivery_member.adminaction.Member_admin_infoAction;
import delivery_member.adminaction.Member_admin_modAction;
import delivery_member.adminaction.Member_admin_modformAction;
import delivery_member.vo.ActionForward;



/**
 * Servlet implementation class DogFrontController
 */
@WebServlet("*.mem_admin")
public class Member_admin_controller extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
	
		System.out.println(command);
		if(command.equals("/member_admin_main.mem_admin")) {
			forward=new ActionForward("member_admin_main.jsp", true);
		}
		else if(command.equals("/member_admin_list.mem_admin")) {
			action=new Member_admin_ListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member_admin_info.mem_admin")) {
			action=new Member_admin_infoAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member_admin_modform.mem_admin")) {
			action=new Member_admin_modformAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member_admin_mod.mem_admin")) {
			action=new Member_admin_modAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member_admin_del.mem_admin")) {
			action=new Member_admin_delAction();
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
