package cn.ssm.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import cn.ssm.po.Items;

/**
 * 实现HttpRequestHandler的处理器
 * @author gu
 *
 */
public class ItemsController2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		//设置模型数据
		request.setAttribute("itemsList", itemsList);
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
		
//		//使用这种方法可以通过修改response 设置响应的数据格式，比如响应的json格式数据
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		response.getWriter().write("json串");
	}

}
