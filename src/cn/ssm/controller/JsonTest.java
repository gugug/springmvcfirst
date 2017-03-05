package cn.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ssm.po.AlbumCustom;

/**
 * json ��������
 * @author gu
 *
 */
@Controller
public class JsonTest {
	
	//����json��ר����Ϣ�� ���json��ר����Ϣ��
	//@RequestBody�������ר����Ϣjson��ת��albumCustom����
	//@ResponseBody��albumCustom����ת��json���
	@RequestMapping("/requestJson")
	public @ResponseBody AlbumCustom requestJson(@RequestBody AlbumCustom albumCustom){
		return albumCustom;
	}
	
	//����key/value ���json
	//@ResponseBody��albumCustom����ת��json���
	@RequestMapping("/responseJson")
	public @ResponseBody AlbumCustom responseJson(AlbumCustom albumCustom){
		return albumCustom;
	}

}
