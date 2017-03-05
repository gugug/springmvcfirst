package cn.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/testStatic")
public class MyStaticPageController {
	 @RequestMapping(value = "/index", method = RequestMethod.GET)
	   public String index() {
		   return "testStatic/index";
	   }
	   
	   @RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	   public String staticPage() {
	     
	      return "forward:/WEB-INF/htmlpages/final.html"; //����ok
//	      return "redirect:/WEB-INF/htmlpages/final.html"; //����ʧ��,��Ϊ��������ٴ�����/WEB-INF/htmlpages/final.html���������Ҫ�ÿ�������������
//	      return "redirect:/views_html/index.html";//�ض��������html�ļ�,����ok
//		  return "forward:/views_html/index.html";//ת���������html�ļ�,����ok

	   }

}
