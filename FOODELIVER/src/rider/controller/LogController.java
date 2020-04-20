package rider.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.action.Action;
import rider.log.action.CheckEmailAction;
import rider.log.action.CheckEmailSuccess;
import rider.log.action.CheckKeySuccess;
import rider.log.action.CheckidAction;
import rider.log.action.CheckidSuccess;
import rider.log.action.CheckpassAction;
import rider.log.action.LoginAction;
import rider.log.action.LogoutAction;
import rider.log.action.PassChange;
import rider.log.action.PassRecheck;
import rider.vo.ActionForward;

/**
 * Servlet implementation class LogController
 */
@WebServlet("*.riderlog")
public class LogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doProcess(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	request.setCharacterEncoding("utf-8");
    	String RequestURI=request.getRequestURI();
    	String contextPath=request.getContextPath();
    	String command=RequestURI.substring(contextPath.length());
    	ActionForward forward=null;
    	Action action=null;
    	System.out.println(command);
    	if(command.equals("/loginForm.riderlog")) {
    		forward = new ActionForward("rider/loginForm.jsp", false);
    		 
    	}else if(command.equals("/login.riderlog")){
    		action=new LoginAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/logout.riderlog")) {
    		action=new LogoutAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/checkpass.riderlog")) {
    		action=new CheckpassAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/checkid.riderlog")) {
    		action=new CheckidAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/checkidsuccess.riderlog")) {
    		action=new CheckidSuccess();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/checkemail.riderlog")) {
    		action=new CheckEmailAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/checkemailsuccess.riderlog")) {
    		action=new CheckEmailSuccess();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/checkkeysuccess.riderlog")) {
    		action=new CheckKeySuccess();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/passRecheck.riderlog")) {
    		action=new PassRecheck();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/passchange.riderlog")) {
    		action=new PassChange();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	
    	if(forward!=null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

}
