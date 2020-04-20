package admin.action;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.InsertCertifyKeySVC;
import rider.vo.ActionForward;

public class insertCertifyKey implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");
		Enumeration<String> e=request.getParameterNames();
		String certifykey[] = null;
		String values[] = null;
		HttpSession session=request.getSession();
		while(e.hasMoreElements()) {
			
			String name=(String)e.nextElement();
			values=request.getParameterValues(name);
			certifykey=new String[values.length];
			for(int i=0;i<values.length;i++) {
			
			String certify="";
			
			int lotate=0;
			while(lotate<10) {
				double dValue=Math.random();
				char cValue=(char)((dValue*70)+40);
				certify=certify+cValue+"";
				lotate++;
				certifykey[i]=certify;
				
			}
			}
			System.out.println(certifykey[0]);
		}
		if((String)session.getAttribute("adminid")==null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('로그인을 하세요')");
			out.println("location.href='loginForm.adm';");
			out.println("</script>");
		}else {
			
			InsertCertifyKeySVC keysvc=new InsertCertifyKeySVC();
			boolean result=keysvc.insertKey(values,certifykey);
			if(result) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('회원 인증키 추가가 완료되었습니다');");
				out.println("location.href='getRiderList.adm';");
				out.println("</script>");
			}
			
		}
		
		
		return null;
	}

}
