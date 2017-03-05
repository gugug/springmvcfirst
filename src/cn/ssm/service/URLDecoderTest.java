package cn.ssm.service;

import java.net.URLDecoder;

import java.net.URLEncoder;
 
public class URLDecoderTest {
 
    public static void main(String[] args) throws Exception {
 
       //将application/x-www-form-urlencoded字符串
 
       //转换成普通字符串
 
       //必须强调的是编码方式必须正确，如baidu的是gb2312，而google的是UTF-8
 
       String keyWord = URLDecoder.decode("%E5%BC%A0%E6%9D%B0", "utf-8");
 
       System.out.println(keyWord);
 
       
 
       //将普通字符串转换成
 
       //application/x-www-form-urlencoded字符串
 
       //必须强调的是编码方式必须正确，如baidu的是gb2312，而google的是UTF-8
 
       String urlStr = URLEncoder.encode("张杰", "utf-8");
 
       System.out.println(urlStr);
 
    }
 
}
