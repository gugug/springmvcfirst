package cn.ssm.service;

public class UnicodeCode {
	
	public static void main(String[] args) {
		System.out.println(string2Unicode("�Ž�"));
	}
	/**
	 * �ַ���ת��unicode
	 */
	public static String string2Unicode(String string) {
	 
	    StringBuffer unicode = new StringBuffer();
	 
	    for (int i = 0; i < string.length(); i++) {
	 
	        // ȡ��ÿһ���ַ�
	        char c = string.charAt(i);
	 
	        // ת��Ϊunicode
	        unicode.append("\\u" + Integer.toHexString(c));
	    }
	 
	    return unicode.toString();
	}

}
