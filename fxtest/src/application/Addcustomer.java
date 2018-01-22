package application;

import java.io.IOException;
import java.sql.*;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class Addcustomer extends AnchorPane{     //添加客户信息类
	@FXML  
	private TextField add_cid;
	@FXML  
	private TextField add_cname;
	@FXML  
	private TextField add_cleveal;
	@FXML  
	private TextField add_cnumber;
	@FXML  
	private TextField add_caddress;
	@FXML  
	private TextField add_citem;
	private static Addcustomer addcustomer ;
	private static Stage newAlertDialog ;
	Addcustomer()//构造函数
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Add_customer.fxml"));  //载入UI
	     fXMLLoader.setRoot(Addcustomer.this);  
	     fXMLLoader.setController(Addcustomer.this); 
	     try {  
	            fXMLLoader.load();
	     
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_addcustomer_window() {  	//显示UI
	        newAlertDialog = new Stage(StageStyle.DECORATED);
	        newAlertDialog.setTitle("添加客户");
	        newAlertDialog.setResizable(false);  
	        addcustomer= new Addcustomer();  
	        newAlertDialog.setScene(new Scene(addcustomer));  
	        newAlertDialog.showAndWait();
	    } 
     public void add_customer_button() throws Exception{
    	    Connection DB_Connection=null;
			PreparedStatement SQL_Prepared=null;
			ResultSet result = null;
			String acid=add_cid.getText();
 	        String acname=add_cname.getText();
 	        String acleveal=add_cleveal.getText();
 	        String acnumber=add_cnumber.getText();
 	        String acaddress=add_caddress.getText();
 	        String acitem=add_citem.getText();
    	 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");	// 加载Oracle驱动程序
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// 获取连接		        
			 String SQL="SELECT 客户编号 FROM 客户信息表 WHERE 客户编号='"+acid+"'";
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     if(result.next()!=false){
			    	 Alert alert=new Alert(AlertType.WARNING);
					 alert.setTitle("Error");
					 alert.setHeaderText("客户编号已存在！");
					 alert.showAndWait();
				 }else
				 {
					System.out.println("开始");
				    String SQL2="INSERT INTO 客户信息表  VALUES('"+acid+"','"+acname+"','"+acleveal+"','"+acnumber+"','"+acaddress+"','"+acitem+"')";
					SQL_Prepared=DB_Connection.prepareStatement(SQL2);
				    result=SQL_Prepared.executeQuery();
				    Alert alert=new Alert(AlertType.WARNING);
					alert.setTitle("添加成功");
					alert.setHeaderText("添加成功");
					alert.showAndWait();
				    System.out.println("成功");
				 }
		     
    	 }
		     catch(Exception e){
				 e.printStackTrace();
			 }
		     
			 try
			 {
				 if (result != null)// 逐一将上面的几个对象关闭
					 result.close();
				 if (SQL_Prepared != null)
					 SQL_Prepared.close();
				 if (DB_Connection != null)
					 DB_Connection.close();
				 }
			 catch (Exception e)
			 {
				 e.printStackTrace();
				 }
 		   
 	   }
          public void add_exit() throws Exception{
    	 Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("确认");
			alert.setHeaderText("确定放弃");
			alert.showAndWait();
			newAlertDialog.close();
			
    	 
    	 
     }
}