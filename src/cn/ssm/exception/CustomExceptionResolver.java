package cn.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * @author gu
 *
 */

public class CustomExceptionResolver implements HandlerExceptionResolver {

	/**
	 * ex  系统抛出异常
	 */
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//handler就是处理器适配器要执行Handler对象（只有method）
		
		//解析出异常类型
		//如果该异常类型是系统自定义异常，直接去除异常信息，错误页面显示
//		String message = null;
//		if(ex instanceof CustomException){
//			message= ((CustomException)ex).getMessage();
//			
//		}else{
//			//如果该异常类型 不 是 系统自定义异常，构造一个自定义的异常类型（信息为“未知错误”）
//			message = "未知错误";
//		}
		
		//上边代码变换为
		CustomException customException = null;
		if (ex instanceof CustomException){
			customException = (CustomException)ex;
		}else{
			 customException = new CustomException("未知错误");
		}
		//错误信息
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
