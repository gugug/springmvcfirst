package cn.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.ssm.po.Items;

/**
 * ʵ��ע���Handler
 * 
 * @author gu
 *
 */
// ʹ��@Controller��ʾ����һ��������
@Controller
//Ϊ�˶�url���з���������������ﶨ���·�������շ���url�Ǹ�·��+��·��
//���磺��Ʒ�б� /items/queryItems
@RequestMapping("/items")
public class ItemsController3 {
	//��ѯ����
	//@RequestMappingʵ�ֶ�queryItems������URL����ӳ�䣬һ��������Ӧһ��url
	//����url��queryItems������д��һ��
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,Items items_11) throws Exception {

		System.out.println("��ת���飺"+items_11.getDetail());
		//����forward���Ƿ���Թ���
		System.out.println("��ת:"+request.getParameter("detail"));
//		System.out.println(request.getParameter("id"));
		
		List<Items> itemsList = new ArrayList<Items>();
		// ��侲̬����
		Items items_1 = new Items();
		items_1.setId("1");
		items_1.setName("����ʼǱ�");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad ����ʼǱ�����");

		Items items_2 = new Items();
		items_2.setId("2");
		items_2.setName("��˶�ʼǱ�");
		items_2.setPrice(5000f);
		items_2.setDetail("��˶�ʼǱ�����");

		itemsList.add(items_1);
		itemsList.add(items_2);

		// ����MOdelAndView
		ModelAndView modelAndView = new ModelAndView();

		// �൱��request��setAttribut,��jspҳ����ͨ��itemsListȡ����
		modelAndView.addObject("itemsList", itemsList);

		// ָ����ͼ
		//�±ߵ�·�����������ͼ��������������jsp��ǰ׺�ͺ�׺���޸�Ϊ
//		modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
//		�ϱߵ�·�����Բ��ô�ǰ׺�ͺ�׺���޸�Ϊ�±ߵ�·��
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	//���������ķ���
	
//	//��Ʒ��Ϣ�޸�ҳ��չʾ
////	@RequestMapping("/editItems")
//	//�������󷽷�
//	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editItems() throws Exception{
//		
//		Items items_1 = new Items();
//		items_1.setId("1");
//		items_1.setName("����ʼǱ�");
//		items_1.setPrice(6000f);
//		items_1.setDetail("ThinkPad ����ʼǱ�����");
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("items_1",items_1);
//		modelAndView.setViewName("items/editItems");
//		return modelAndView;
//	}
	
	
	//��Ʒ��Ϣ�޸�ҳ��չʾ
//	@RequestMapping("/editItems")
	//�������󷽷�
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam���ָ��request����������ƺ��βν��а�
	//ͨ��required����ָ�������Ƿ���봫��
	//ͨ��defaultValue����Ĭ��ֵ,���id����û�д��룬��Ĭ��ֵ���βΰ�
	public String editItems(Model model,@RequestParam(value="id",required=true,defaultValue="") Integer items_id) throws Exception{
		System.out.println(items_id);
		Items items_1 = new Items();
		if(items_id.equals(1)){
			items_1.setId("1");
			items_1.setName("����ʼǱ�");
			items_1.setPrice(6000f);
			items_1.setDetail("ThinkPad ����ʼǱ�����");
		}else{
			items_1.setId("2");
			items_1.setName("��˶�ʼǱ�");
			items_1.setPrice(5000f);
			items_1.setDetail("��˶�ʼǱ�����");
		}
	
		//ͨ���β��е�model�����ݴ���ҳ��
		//�൱��modelAndView.addObject����
		model.addAttribute("items_1",items_1);
		return "items/editItems";
	}
	
	
//	//��Ʒ��Ϣ�޸��ύ
//	@RequestMapping("/editItemsSubmit")
//	public ModelAndView editItemsSubmit() throws Exception{
//		//������Ʒ��Ϣ��ҳ���뽫��Ʒ��Ϣ�����˷���
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("success");
//		return modelAndView;
//	}
	
	//��Ʒ��Ϣ�޸��ύ
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Items items_1) throws Exception{
		//������Ʒ��Ϣ��ҳ���뽫��Ʒ��Ϣ�����˷���
		items_1.setDetail("�޸�Ϊ������Ϣ");
		System.out.println(items_1.getDetail());
//		System.out.println("edit"+request.getParameter("id"));
		//�ض�����Ʒ��ѯҳ��
//		return "redirect:queryItems.action";
		//ҳ��ת��
		return "forward:queryItems.action";

//		return "success";
	}
	
}
