package delivery_member.controller.deliverycontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delivery_member.action.Action;
import delivery_member.action.CompanyListAction;
import delivery_member.action.MenuBackAction;
import delivery_member.action.OrderAction;
import delivery_member.action.OrderCartAddAction;
import delivery_member.action.OrderCartListRemoveAction;
import delivery_member.action.OrderCartQuantityDownAction;
import delivery_member.action.OrderCartQuantityUpAction;
import delivery_member.action.OrderListAction;
import delivery_member.action.OrderListComAction;
import delivery_member.action.OrderMenuAction;
import delivery_member.action.OrderReviewAction;
import delivery_member.action.OrderSaveAction;
import delivery_member.action.SearchAction;
import delivery_member.action.changeAction;
import delivery_member.action.order_deleteAction;
import delivery_member.vo.ActionForward;


/**
 * Servlet implementation class DogFrontController
 */
@WebServlet("*.main")
public class DeliveryController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
	
		System.out.println(command);
		if(command.equals("/company.main")) {
			
			action=new CompanyListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/main.main")) {
			forward=new ActionForward("main.jsp", true);
			
		}else if(command.equals("/ordermenu.main")) {
			action=new OrderMenuAction();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/orderreview.main")) {
			action=new OrderReviewAction();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/ordercartadd.main")) {
			action=new OrderCartAddAction();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/ordercartquantityup.main")) {
			action=new OrderCartQuantityUpAction();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/ordercartquantitydown.main")) {
			action=new OrderCartQuantityDownAction();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/orderlistremove.main")) {
			action=new OrderCartListRemoveAction();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/menuback.main")) {
			action=new MenuBackAction();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/search.main")) {
			action=new SearchAction();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/order.main")) {
			action=new OrderAction();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/ordersave.main")) {
			action=new OrderSaveAction();
			
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/order_list.main")) {
			action=new OrderListAction();
			
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/order_list_com.main")) {
			action=new OrderListComAction();
			
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/order_delete.main")) {
			action=new order_deleteAction();
			
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/change.main")) {
			action=new changeAction();
			
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
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
