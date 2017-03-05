package cn.ssm.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.ssm.po.Items;

/**
 * ʵ��controller�Ĵ�����
 * @author gu
 *
 */
public class ItemsController1 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//������þ�̬����
		List<Items> itemsList = new ArrayList<Items>();
		//��侲̬����
		Items items_1 = new Items();
		items_1.setName("����ʼǱ�");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad ����ʼǱ�����");
		
		Items items_2 = new Items();
		items_2.setName("��˶�ʼǱ�");
		items_2.setPrice(5000f);
		items_2.setDetail("��˶�ʼǱ�����");
		
		itemsList.add(items_1);
		itemsList.add(items_2);
		
		//����MOdelAndView
		ModelAndView modelAndView = new ModelAndView();
		
		//�൱��request��setAttribut,��jspҳ����ͨ��itemsListȡ����
		modelAndView.addObject("itemsList", itemsList);
		
		//ָ����ͼ
		modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		
		return modelAndView;
	}

}
