package cn.ssm.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ssm.po.Shop;

/**
 * �������key/value ���json
 * @author gu
 *
 */

@Controller  
@RequestMapping(value="/shop")
public class JSONController {  
  
    @RequestMapping(value="getShopInJSON", method = RequestMethod.GET)  
    public @ResponseBody Shop getShopInJSON() {  
  
        //��������  
        Shop shop = new Shop();  
        System.out.println("Shop");  
        shop.setName("Eric");  
        shop.setStaffName(new String[]{"mkyong1", "mkyong2"});  
        return shop;  
    }  
	@RequestMapping(value="showJsonJsp")  
    public String showJsonJsp() throws IOException{  
       return "shop/testJson";
    }  
}  