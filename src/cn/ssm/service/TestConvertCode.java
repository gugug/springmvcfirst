package cn.ssm.service;
import java.io.UnsupportedEncodingException;

public class TestConvertCode
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        String word = "�Ž�";
        String encoding = "utf-8";//����ǿ�����Ǳ��뷽ʽ������ȷ����baidu����gb2312����google����UTF-8
        String retValue = CodeConverter.toBrowserCode(word, encoding);
        System.out.print(retValue);
    }
    
}
class CodeConverter
{
    // �������ַ�ת��Ϊ���ٷֺŵ����������
    // @param word �����ַ�
    // @param encoding �ַ�����
    public static String toBrowserCode(String word, String encoding)
            throws UnsupportedEncodingException
    {
        byte[] textByte = word.getBytes(encoding);
        StringBuilder strBuilder = new StringBuilder();
       
        for (int j = 0; j < textByte.length; j++)
        {
            // ת��Ϊ16�����ַ�
            String hexStr = Integer.toHexString(textByte[j] & 0xff);
            strBuilder.append("%" + hexStr.toUpperCase());
        }
       
        return strBuilder.toString();
    }
}