package cn.ssm.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.ssm.po.Items;

/**
 * 实现controller的处理器
 * @author gu
 *
 */
public class ItemsController1 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//这里采用静态数据
		List<Items> itemsList = new ArrayList<Items>();
		//填充静态数据
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad 联想笔记本电脑");
		
		Items items_2 = new Items();
		items_2.setName("华硕笔记本");
		items_2.setPrice(5000f);
		items_2.setDetail("华硕笔记本电脑");
		
		itemsList.add(items_1);
		itemsList.add(items_2);
		
		//返回MOdelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		//相当于request的setAttribut,在jsp页面上通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);
		
		//指定视图
		modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		
		return modelAndView;
	}

}
