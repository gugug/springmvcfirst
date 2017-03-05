package cn.ssm.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class URLDecoderEncoder {
//	public static void main(String[] args) {
//		codeConverter("�Ž�");
//		codeConverter("TOM");
//
//	}
	public static String toUTF8(String str) {
		// ����ͨ�ַ���ת����

		// application/x-www-form-urlencoded�ַ���

		// ����ǿ�����Ǳ��뷽ʽ������ȷ����baidu����gb2312����google����UTF-8

		String urlStr = null;
		try {
			urlStr = URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return urlStr;
	}
	
	public static String toCharacter(String str){
	       //��application/x-www-form-urlencoded�ַ���
		 
	       //ת������ͨ�ַ���
	 
	       //����ǿ�����Ǳ��뷽ʽ������ȷ����baidu����gb2312����google����UTF-8
	 
	       String keyWord = null;
		try {
			keyWord = URLDecoder.decode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	 
	       return keyWord;
	}
	

}
