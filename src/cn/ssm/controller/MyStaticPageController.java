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
	     
	      return "forward:/WEB-INF/htmlpages/final.html"; //测试ok
//	      return "redirect:/WEB-INF/htmlpages/final.html"; //测试失败,因为浏览器会再次请求/WEB-INF/htmlpages/final.html，而这个是要用控制器才能请求到
//	      return "redirect:/views_html/index.html";//重定向到外面的html文件,测试ok
//		  return "forward:/views_html/index.html";//转发到外面的html文件,测试ok

	   }

}
