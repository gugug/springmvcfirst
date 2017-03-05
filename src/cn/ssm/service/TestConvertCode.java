package cn.ssm.service;
import java.io.UnsupportedEncodingException;

public class TestConvertCode
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        String word = "张杰";
        String encoding = "utf-8";//必须强调的是编码方式必须正确，如baidu的是gb2312，而google的是UTF-8
        String retValue = CodeConverter.toBrowserCode(word, encoding);
        System.out.print(retValue);
    }
    
}
class CodeConverter
{
    // 把中文字符转换为带百分号的浏览器编码
    // @param word 中文字符
    // @param encoding 字符编码
    public static String toBrowserCode(String word, String encoding)
            throws UnsupportedEncodingException
    {
        byte[] textByte = word.getBytes(encoding);
        StringBuilder strBuilder = new StringBuilder();
       
        for (int j = 0; j < textByte.length; j++)
        {
            // 转换为16进制字符
            String hexStr = Integer.toHexString(textByte[j] & 0xff);
            strBuilder.append("%" + hexStr.toUpperCase());
        }
       
        return strBuilder.toString();
    }
}