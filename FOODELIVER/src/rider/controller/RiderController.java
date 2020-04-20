package rider.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.action.Action;
import rider.action.DeliveryInfo;
import rider.action.DeliveryInfoDetail;
import rider.action.DeliverySuccess;
import rider.action.DeliverySuccessDetail;
import rider.action.DeliverySuccessInfo;
import rider.action.OrderFinalAction;
import rider.action.RiderCheckId;

import rider.action.RiderInfo;
import rider.action.RiderJoinPro;
import rider.action.RiderModProAction;
import rider.action.RiderModify;
import rider.vo.ActionForward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.ridermem")
public class RiderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RiderController() {
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
    	
    	if(command.equals("/joinForm.ridermem")) {
    		forward=new ActionForward("/rider/joinForm.jsp",false);
    		 
    	}else if(command.equals("/riderJoinProcess.ridermem")){
    		action=new RiderJoinPro();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/riderInfo.ridermem")) {
    		action=new RiderInfo();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/riderMod.ridermem")) {
    		action=new RiderModify();
    		try {
    			forward=action.execute(request,response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/riderModPro.ridermem")) {
    		action=new RiderModProAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/riderlogincheck.ridermem")) {
    		action=new RiderCheckId();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/deliveryInfo.ridermem")) {
    		action=new DeliveryInfo();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	else if(command.equals("/deliveryInfoDetail.ridermem")) {
    		action=new DeliveryInfoDetail();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/orderFinal.ridermem")) {
    		action=new OrderFinalAction();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/deliverySuccess.ridermem")) {
    		action=new DeliverySuccess();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/deliverySuccessInfo.ridermem")) {
    		action=new DeliverySuccessInfo();
    		try {
    			forward=action.execute(request, response);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command.equals("/deliverySuccessDetail.ridermem")) {
    		action=new DeliverySuccessDetail();
    		try {
    			forward=action.execute(request,response);
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
