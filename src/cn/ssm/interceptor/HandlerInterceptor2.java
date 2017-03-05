package cn.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试拦截器1
 * @author gu
 *
 */
public class HandlerInterceptor2 implements HandlerInterceptor{

	//执行时机：进入handler方法之前执行
	//场景：用于身份认证、身份授权
	//比如：身份认证，如果认证不通过表示用户没有登录，需要此方法拦截不在向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("HandlerInterceptor2...preHandle");

		//return false 表示拦截，不向下执行
		//return true 表示放行
		return true;
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
