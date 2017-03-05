package cn.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ssm.service.SpiderPic;
import cn.ssm.service.URLDecoderEncoder;

@Controller
@RequestMapping(value="/items")
public class AddSingerController {
	
	@RequestMapping(value="/addSinger",method={RequestMethod.POST,RequestMethod.GET})
	public String addSinger(){
		return "items/addSinger";
	}
	
	@RequestMapping(value="/addSingerSubmit",method={RequestMethod.POST,RequestMethod.GET})
	public String addSingerSubmit(HttpServletRequest request,Model model,String singerName,@RequestParam(value="singerName") String sname){
		new SpiderPic().saveAlbumPic(URLDecoderEncoder.toUTF8(singerName));
//		new SpiderPic().saveAlbumPic(singerName);
//		System.out.println("1 "+new SpiderPic().getContent("https://baike.baidu.com/"));
//		System.out.println("22 "+new SpiderPic().getContent("http://baike.baidu.com/item/%E5%BC%A0%E6%9D%B0"));

		System.out.println("1 "+singerName);
		System.out.println("2 "+sname);
		System.out.println("3 "+request.getParameter("singerName"));
		
		return "forward:queryAlbum.action";
	}
	
	

}
