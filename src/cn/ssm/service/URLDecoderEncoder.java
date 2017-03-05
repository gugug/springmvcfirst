package cn.ssm.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class URLDecoderEncoder {
//	public static void main(String[] args) {
//		codeConverter("张杰");
//		codeConverter("TOM");
//
//	}
	public static String toUTF8(String str) {
		// 将普通字符串转换成

		// application/x-www-form-urlencoded字符串

		// 必须强调的是编码方式必须正确，如baidu的是gb2312，而google的是UTF-8

		String urlStr = null;
		try {
			urlStr = URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return urlStr;
	}
	
	public static String toCharacter(String str){
	       //将application/x-www-form-urlencoded字符串
		 
	       //转换成普通字符串
	 
	       //必须强调的是编码方式必须正确，如baidu的是gb2312，而google的是UTF-8
	 
	       String keyWord = null;
		try {
			keyWord = URLDecoder.decode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	 
	       return keyWord;
	}
	

}
