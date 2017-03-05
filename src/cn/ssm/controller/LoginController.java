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
	  //此注解不能省略 否则ajax无法接受返回值  ,将json对象转成java对象  //@ResponseBody 表示返回的是json对象
    public @ResponseBody Map<String,String> login(HttpServletRequest request,HttpServletResponse response,String name) throws IOException{  
        System.out.println("getParameter "+request.getParameter("name"));  
        System.out.println("String name "+name);
        Map<String,String> map = new HashMap<String,String>();  
        if(request.getParameter("name").equals("123")){  
            System.out.println("城东");  
            map.put("msg", "成功");  
        }else{  
            System.out.println("失败");  
            map.put("msg", "失败");  
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
            System.out.println("城东");
            return msg1;
        }else{  
            System.out.println("失败");
            return msg2;
        }
	}
	
	
	//登录
	@RequestMapping("/albumLogin")
	public String albumLogin(HttpSession session, String username,String password)throws Exception{
		System.out.println(username);
		//调用service进行用户身份的验证
		//...
		
		//在session保存用户身份的信息
		session.setAttribute("username", username);
		session.setAttribute("test", "TEST");

		
		//重定向到商品的列表页面
		return "redirect:/items/queryAlbum.action";
	}
	
	//退出
	@RequestMapping("/albumLogout")
	public String albumLogout(HttpSession session) throws Exception{
		
		//清除session
		session.invalidate();
		
		//重定向到商品的列表页面
		return "redirect:/items/queryAlbum.action";
	}
}
