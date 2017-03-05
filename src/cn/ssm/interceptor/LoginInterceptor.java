package cn.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginInterceptor 登录认证的拦截器
 * @author gu
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	//执行时机：进入handler方法之前执行
	//场景：用于身份认证、身份授权
	//比如：身份认证，如果认证不通过表示用户没有登录，需要此方法拦截不在向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//获取请求的url,a)如果请求的url是公开地址（无需登录即可访问的url）,放行
		String url = request.getRequestURI();
		//判断是否为url是公开地址（无需登录即可访问的url），实际使用时配置在配置文件中
		
		if (url.indexOf("albumLogin.action")>=0){
			//如果进行登录提交，放行
			return true;
		}
		
//		判断session
//		如果用户session不存在跳转到登录页面
//		如果用户session存在 放行，继续操作
		HttpSession session = request.getSession();
		//从session取出用户的信息
		String username = (String)session.getAttribute("username");
		
		if(username != null){
			//身份信息存在，放行
			return true;
		}
		
		//执行到这里表示用户需要认证，跳转到登录页面
		request.getRequestDispatcher("/WEB-INF/jsp/user/albumLogin.jsp").forward(request, response);
		
		
		//return false 表示拦截，不向下执行
		//return true 表示放行
		return false;
	}

	//进入handler之后，再返回modelAndView之前执行
	//modelAndView出发，将共用的模型数据在这里传到视图，也可以在这里统一指定视图，比如菜单导航条
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor2...postHandle");

	}

	//执行handler完成执行此方法
	//统一的异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptor2...afterCompletion");

	}

}
