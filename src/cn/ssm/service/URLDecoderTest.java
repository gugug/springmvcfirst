package cn.ssm.service;

import java.net.URLDecoder;

import java.net.URLEncoder;
 
public class URLDecoderTest {
 
    public static void main(String[] args) throws Exception {
 
       //��application/x-www-form-urlencoded�ַ���
 
       //ת������ͨ�ַ���
 
       //����ǿ�����Ǳ��뷽ʽ������ȷ����baidu����gb2312����google����UTF-8
 
       String keyWord = URLDecoder.decode("%E5%BC%A0%E6%9D%B0", "utf-8");
 
       System.out.println(keyWord);
 
       
 
       //����ͨ�ַ���ת����
 
       //application/x-www-form-urlencoded�ַ���
 
       //����ǿ�����Ǳ��뷽ʽ������ȷ����baidu����gb2312����google����UTF-8
 
       String urlStr = URLEncoder.encode("�Ž�", "utf-8");
 
       System.out.println(urlStr);
 
    }
 
}
