package cn.ssm.exception;
/**
 * 系统自定义异常类，针对预期的异常错误，需要在程序中抛出此类异常
 * @author gu
 *
 */
public class CustomException extends Exception{
	
	//异常信息
	public String message;
	
	public CustomException(String message){
		super(message);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
