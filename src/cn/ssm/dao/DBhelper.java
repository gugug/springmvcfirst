package cn.ssm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBhelper {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/music?characterEncoding=UTF-8"; // 127.0.0.1//localhost//193.168.235.15

	static final String USER = "root";
	static final String PASS = "";
	private Connection conn;
	
    public DBhelper(){
    } 
    
	 /** 
     * 获取数据库连接 
     * @return 
     */  
    public Connection getConnection(){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("正在连接...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
    }
	
	 /** 
     * 关闭数据库 
     * @param con 
     * @param pst 
     * @param rst 
     */  
    public void closeAll(Connection con,PreparedStatement pst,ResultSet rst){  
        if(rst!=null){  
            try {  
                rst.close();  
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
          
        if(pst!=null){  
            try {  
                pst.close();  
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
          
        if(con!=null){  
            try {  
                con.close();  
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        System.out.println("关闭完毕");
          
    }  

}
