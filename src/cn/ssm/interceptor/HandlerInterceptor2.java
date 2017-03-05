package cn.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����������1
 * @author gu
 *
 */
public class HandlerInterceptor2 implements HandlerInterceptor{

	//ִ��ʱ��������handler����֮ǰִ��
	//���������������֤�������Ȩ
	//���磺�����֤�������֤��ͨ����ʾ�û�û�е�¼����Ҫ�˷������ز�������ִ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("HandlerInterceptor2...preHandle");

		//return false ��ʾ���أ�������ִ��
		//return true ��ʾ����
		return true;
	}

	//����handler֮���ٷ���modelAndView֮ǰִ��
	//modelAndView�����������õ�ģ�����������ﴫ����ͼ��Ҳ����������ͳһָ����ͼ������˵�������
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor2...postHandle");

	}

	//ִ��handler���ִ�д˷���
	//ͳһ���쳣����ͳһ��־����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptor2...afterCompletion");

	}

}
