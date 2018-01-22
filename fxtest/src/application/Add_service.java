package application;

import java.io.IOException;
import java.sql.*;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import application.Main;
public class Add_service extends AnchorPane{ 
	@FXML
	ComboBox<String>  add_scarid;
	@FXML
	ComboBox<String>  add_sid;
	@FXML
	private TextField add_scid;
	@FXML  
	private TextField add_service_id;
	@FXML  
	private TextField add_sday;
	@FXML  
	private TextField add_srecord;
	
	private static Add_service add_service ;
	private static Stage newAlertDialog ;
	Add_service()//构造函数
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Add_Service.fxml"));  //载入UI
	     fXMLLoader.setRoot(Add_service.this);  
	     fXMLLoader.setController(Add_service.this); 
	     try {  
	            fXMLLoader.load();
	     
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
 		    Connection DB_Connection=null;
			PreparedStatement SQL_Prepared=null;
			ResultSet result = null;
			
	 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");	// 加载Oracle驱动程序
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// 获取连接		        
			 String SQL="SELECT 员工编号 FROM 员工信息表 ";
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     while(result.next()!=false){
		    	 String customer_id=result.getString("员工编号"); 
		    	 add_sid.getItems().add(customer_id);
		    	 
				 }
		      SQL="SELECT 车辆牌照 FROM 轿车销售表 ";
		      SQL_Prepared=DB_Connection.prepareStatement(SQL);
			     result=SQL_Prepared.executeQuery();
			     while(result.next()!=false){
			    	 String car_id=result.getString("车辆牌照"); 
			    	 add_scarid.getItems().add(car_id); 
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
	 public  void show_add_service_window() {  	//显示UI
	        newAlertDialog = new Stage(StageStyle.DECORATED);
	        newAlertDialog.setTitle("添加售后服务");
	        newAlertDialog.setResizable(false);  
	        add_service= new Add_service();  
	        newAlertDialog.setScene(new Scene(add_service));  
	        newAlertDialog.showAndWait();
	    } 
	public  void add_scaridAction(){
		    Connection DB_Connection=null;
			PreparedStatement SQL_Prepared=null;
			ResultSet result = null;
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 加载Oracle驱动程序
			DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// 获取连接		       
			String as=add_scarid.getValue();
		    String SQL="SELECT 客户编号 FROM 轿车销售表 where 车辆牌照='"+as+"'";
		    SQL_Prepared=DB_Connection.prepareStatement(SQL);
		    result=SQL_Prepared.executeQuery();
		     while(result.next()!=false){
		     add_scid.setText(result.getString("客户编号"));
		      }
		     add_scid.setEditable(false);;
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
		     
	 
     public void add_service_button() throws Exception{
    	 Connection DB_Connection=null;
			PreparedStatement SQL_Prepared=null;
			ResultSet result = null;
			String assid=add_service_id.getText();
	        String asday=add_sday.getText();
	        String asrecord=add_srecord.getText();
	        String ascarid=add_scarid.getValue();
	        String ascid=add_scid.getText();
	        String asid=add_sid.getValue();
 	 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");	// 加载Oracle驱动程序
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// 获取连接		        
			 String SQL="SELECT 服务序号 FROM 售后管理表 WHERE 服务序号='"+assid+"'";
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     if(result.next()!=false){
			    	 Alert alert=new Alert(AlertType.WARNING);
					 alert.setTitle("Error");
					 alert.setHeaderText("服务编号已存在！");
					 alert.showAndWait();
				 }else
				 {
					System.out.println("开始");
				    String SQL2="INSERT INTO 售后管理表  VALUES('"+assid+"','"+asday+"','"+ascid+"','"+ascarid+"','"+asid+"','"+asrecord+"')";
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
         
}