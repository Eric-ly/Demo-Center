package demo.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myInterceptor implements HandlerInterceptor
{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("---处理后------afterCompletion-" );

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("---处理后------postHandle-" );

	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse reqs, Object arg2) throws Exception
	{
		String url = req.getRequestURL().toString();
		Object user = req.getSession().getAttribute("sessionUser");
		if (user != null){
			return true;
		}
		reqs.sendRedirect(req.getContextPath()+"/login.do");
		System.out.println("---处理前------preHandle-" + url);
		return false;
	}

}
