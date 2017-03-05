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
 * ʵ��HttpRequestHandler�Ĵ�����
 * @author gu
 *
 */
public class ItemsController2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		//����ģ������
		request.setAttribute("itemsList", itemsList);
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
		
//		//ʹ�����ַ�������ͨ���޸�response ������Ӧ�����ݸ�ʽ��������Ӧ��json��ʽ����
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=utf-8");
//		response.getWriter().write("json��");
	}

}
