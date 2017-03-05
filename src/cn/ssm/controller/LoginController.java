package cn.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
public class LoginController {
	@RequestMapping(value="login",produces="application/json;charset=UTF-8")  
	  //��ע�ⲻ��ʡ�� ����ajax�޷����ܷ���ֵ  ,��json����ת��java����  //@ResponseBody ��ʾ���ص���json����
    public @ResponseBody Map<String,String> login(HttpServletRequest request,HttpServletResponse response,String name) throws IOException{  
        System.out.println("getParameter "+request.getParameter("name"));  
        System.out.println("String name "+name);
        Map<String,String> map = new HashMap<String,String>();  
        if(request.getParameter("name").equals("123")){  
            System.out.println("�Ƕ�");  
            map.put("msg", "�ɹ�");  
        }else{  
            System.out.println("ʧ��");  
            map.put("msg", "ʧ��");  
        }  
        return map;  
    }  

	@RequestMapping(value="showLogin")  
    public String showLogin() throws IOException{  
       return "user/login";
    }
	@RequestMapping(value="test")
	public @ResponseBody String test(HttpServletRequest request,HttpServletResponse response){
		String msg1 = "{\"msg\":\"success\"}";
		String msg2 = "{\"msg\":\"error\"}";
		if(request.getParameter("name").equals("123")){  
            System.out.println("�Ƕ�");
            return msg1;
        }else{  
            System.out.println("ʧ��");
            return msg2;
        }
	}
	
	
	//��¼
	@RequestMapping("/albumLogin")
	public String albumLogin(HttpSession session, String username,String password)throws Exception{
		System.out.println(username);
		//����service�����û���ݵ���֤
		//...
		
		//��session�����û���ݵ���Ϣ
		session.setAttribute("username", username);
		session.setAttribute("test", "TEST");

		
		//�ض�����Ʒ���б�ҳ��
		return "redirect:/items/queryAlbum.action";
	}
	
	//�˳�
	@RequestMapping("/albumLogout")
	public String albumLogout(HttpSession session) throws Exception{
		
		//���session
		session.invalidate();
		
		//�ض�����Ʒ���б�ҳ��
		return "redirect:/items/queryAlbum.action";
	}
}
