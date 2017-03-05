package cn.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ssm.po.AlbumCustom;

/**
 * json 交互测试
 * @author gu
 *
 */
@Controller
public class JsonTest {
	
	//请求json（专辑信息） 输出json（专辑信息）
	//@RequestBody将请求的专辑信息json串转成albumCustom对象
	//@ResponseBody将albumCustom对象转成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody AlbumCustom requestJson(@RequestBody AlbumCustom albumCustom){
		return albumCustom;
	}
	
	//请求key/value 输出json
	//@ResponseBody将albumCustom对象转成json输出
	@RequestMapping("/responseJson")
	public @ResponseBody AlbumCustom responseJson(AlbumCustom albumCustom){
		return albumCustom;
	}

}
