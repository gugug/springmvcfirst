package cn.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginInterceptor ��¼��֤��������
 * @author gu
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	//ִ��ʱ��������handler����֮ǰִ��
	//���������������֤�������Ȩ
	//���磺�����֤�������֤��ͨ����ʾ�û�û�е�¼����Ҫ�˷������ز�������ִ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//��ȡ�����url,a)��������url�ǹ�����ַ�������¼���ɷ��ʵ�url��,����
		String url = request.getRequestURI();
		//�ж��Ƿ�Ϊurl�ǹ�����ַ�������¼���ɷ��ʵ�url����ʵ��ʹ��ʱ�����������ļ���
		
		if (url.indexOf("albumLogin.action")>=0){
			//������е�¼�ύ������
			return true;
		}
		
//		�ж�session
//		����û�session��������ת����¼ҳ��
//		����û�session���� ���У���������
		HttpSession session = request.getSession();
		//��sessionȡ���û�����Ϣ
		String username = (String)session.getAttribute("username");
		
		if(username != null){
			//�����Ϣ���ڣ�����
			return true;
		}
		
		//ִ�е������ʾ�û���Ҫ��֤����ת����¼ҳ��
		request.getRequestDispatcher("/WEB-INF/jsp/user/albumLogin.jsp").forward(request, response);
		
		
		//return false ��ʾ���أ�������ִ��
		//return true ��ʾ����
		return false;
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
