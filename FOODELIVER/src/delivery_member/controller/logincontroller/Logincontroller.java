package delivery_member.controller.logincontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.action.Action;
import delivery_member.action.CheckEmailAction;
import delivery_member.action.CheckEmailSuccess;
import delivery_member.action.CheckidAction;
import delivery_member.action.CheckidSuccess;
import delivery_member.action.CheckpassAction;
import delivery_member.action.LoginAction;
import delivery_member.action.LogoutAction;
import delivery_member.vo.ActionForward;



/**
 * Servlet implementation class DogFrontController
 */
@WebServlet("*.mlog")
public class Logincontroller extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
	
		System.out.println(command);
		if(command.equals("/loginform.mlog")) {
			
			forward = new ActionForward("login/loginForm.jsp",true);
		}
		else if(command.equals("/login.mlog")) {
			action=new LoginAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/logout.mlog")) {
			action=new LogoutAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/checkid.mlog")) {
    		action=new CheckidAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/checkidsuccess.mlog")) {
    		action=new CheckidSuccess();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/checkpass.mlog")) {
    		action=new CheckpassAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/checkemail2.mlog")) {
    		action=new CheckEmailAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/checkemailsuccess2.mlog")) {
    		action=new CheckEmailSuccess();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
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
