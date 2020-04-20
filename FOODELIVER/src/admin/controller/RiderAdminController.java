package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.action.Action;
import admin.action.AdminInfoAction;
import admin.action.AdminModProAction;
import admin.action.GetRiderList;
import admin.action.LoginAdminAction;
import admin.action.LogoutAdminAction;
import admin.action.PassAdminChange;
import admin.action.RiderDeleteAction;
import admin.action.RiderInfoAction;
import admin.action.RiderModAction;
import admin.action.RiderModProAction;
import admin.action.insertCertifyKey;
import rider.vo.ActionForward;

/**
 * Servlet implementation class RiderAdminController
 */
@WebServlet("*.adm")
public class RiderAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RiderAdminController() {
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
    	
    	if(command.equals("/loginForm.adm")) {
        	forward = new ActionForward("admin/loginForm.jsp", false);
        }else if(command.equals("/logout.adm")) {
        	action=new LogoutAdminAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
        }else if(command.equals("/login.adm")) {
        	action=new LoginAdminAction();
        	try {
        		forward=action.execute(request, response);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }else if(command.equals("/adminInfo.adm")) {
        	action=new AdminInfoAction();
        	try {
        		forward=action.execute(request, response);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }else if(command.equals("/adminModPro.adm")) {
        	action=new AdminModProAction();
        	try {
        		forward=action.execute(request, response);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }else if(command.equals("/getRiderList.adm")) {
        	action=new GetRiderList();
        	try {
        		forward=action.execute(request,response);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }else if(command.equals("/riderInfo.adm")) {
        	action=new RiderInfoAction();
        	try {
        		forward=action.execute(request, response);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }else if(command.equals("/riderMod.adm")) {
        	action=new RiderModAction();
        	try {
        		forward=action.execute(request, response);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }else if(command.equals("/riderModPro.adm")) {
        	action=new RiderModProAction();
        	try {
        		forward=action.execute(request, response);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }else if(command.equals("/riderDelete.adm")) {
        	action=new RiderDeleteAction();
        	try {
        		forward=action.execute(request, response);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }else if(command.equals("/passAdminChange.adm")) {
        	action=new PassAdminChange();
        	try {
        		forward=action.execute(request, response);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        }else if(command.equals("/insertCertifyKey.adm")) {
        	action=new insertCertifyKey();
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
