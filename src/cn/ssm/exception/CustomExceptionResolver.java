package cn.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * ȫ���쳣������
 * @author gu
 *
 */

public class CustomExceptionResolver implements HandlerExceptionResolver {

	/**
	 * ex  ϵͳ�׳��쳣
	 */
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//handler���Ǵ�����������Ҫִ��Handler����ֻ��method��
		
		//�������쳣����
		//������쳣������ϵͳ�Զ����쳣��ֱ��ȥ���쳣��Ϣ������ҳ����ʾ
//		String message = null;
//		if(ex instanceof CustomException){
//			message= ((CustomException)ex).getMessage();
//			
//		}else{
//			//������쳣���� �� �� ϵͳ�Զ����쳣������һ���Զ�����쳣���ͣ���ϢΪ��δ֪���󡱣�
//			message = "δ֪����";
//		}
		
		//�ϱߴ���任Ϊ
		CustomException customException = null;
		if (ex instanceof CustomException){
			customException = (CustomException)ex;
		}else{
			 customException = new CustomException("δ֪����");
		}
		//������Ϣ
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
