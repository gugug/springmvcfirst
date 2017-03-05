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
 * 实现注解的Handler
 * 
 * @author gu
 *
 */
// 使用@Controller标示他是一个控制器
@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：商品列表： /items/queryItems
@RequestMapping("/items")
public class ItemsController3 {
	//查询数据
	//@RequestMapping实现对queryItems方法和URL进行映射，一个方法对应一个url
	//建议url和queryItems方法名写成一样
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,Items items_11) throws Exception {

		System.out.println("跳转详情："+items_11.getDetail());
		//测试forward后是否可以共享
		System.out.println("跳转:"+request.getParameter("detail"));
//		System.out.println(request.getParameter("id"));
		
		List<Items> itemsList = new ArrayList<Items>();
		// 填充静态数据
		Items items_1 = new Items();
		items_1.setId("1");
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad 联想笔记本电脑");

		Items items_2 = new Items();
		items_2.setId("2");
		items_2.setName("华硕笔记本");
		items_2.setPrice(5000f);
		items_2.setDetail("华硕笔记本电脑");

		itemsList.add(items_1);
		itemsList.add(items_2);

		// 返回MOdelAndView
		ModelAndView modelAndView = new ModelAndView();

		// 相当于request的setAttribut,在jsp页面上通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		//下边的路径，如果在视图解析器中配置了jsp的前缀和后缀，修改为
//		modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
//		上边的路径可以不用带前缀和后缀，修改为下边的路径
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	//定义其他的方法
	
//	//商品信息修改页面展示
////	@RequestMapping("/editItems")
//	//限制请求方法
//	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editItems() throws Exception{
//		
//		Items items_1 = new Items();
//		items_1.setId("1");
//		items_1.setName("联想笔记本");
//		items_1.setPrice(6000f);
//		items_1.setDetail("ThinkPad 联想笔记本电脑");
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("items_1",items_1);
//		modelAndView.setViewName("items/editItems");
//		return modelAndView;
//	}
	
	
	//商品信息修改页面展示
//	@RequestMapping("/editItems")
	//限制请求方法
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定
	//通过required属性指定参数是否必须传入
	//通过defaultValue设置默认值,如果id参数没有传入，将默认值和形参绑定
	public String editItems(Model model,@RequestParam(value="id",required=true,defaultValue="") Integer items_id) throws Exception{
		System.out.println(items_id);
		Items items_1 = new Items();
		if(items_id.equals(1)){
			items_1.setId("1");
			items_1.setName("联想笔记本");
			items_1.setPrice(6000f);
			items_1.setDetail("ThinkPad 联想笔记本电脑");
		}else{
			items_1.setId("2");
			items_1.setName("华硕笔记本");
			items_1.setPrice(5000f);
			items_1.setDetail("华硕笔记本电脑");
		}
	
		//通过形参中的model将数据传到页面
		//相当于modelAndView.addObject方法
		model.addAttribute("items_1",items_1);
		return "items/editItems";
	}
	
	
//	//商品信息修改提交
//	@RequestMapping("/editItemsSubmit")
//	public ModelAndView editItemsSubmit() throws Exception{
//		//更新商品信息，页面须将商品信息传到此方法
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("success");
//		return modelAndView;
//	}
	
	//商品信息修改提交
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Items items_1) throws Exception{
		//更新商品信息，页面须将商品信息传到此方法
		items_1.setDetail("修改为最新信息");
		System.out.println(items_1.getDetail());
//		System.out.println("edit"+request.getParameter("id"));
		//重定向商品查询页面
//		return "redirect:queryItems.action";
		//页面转发
		return "forward:queryItems.action";

//		return "success";
	}
	
}
