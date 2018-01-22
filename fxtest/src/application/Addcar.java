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

public class Addcar extends AnchorPane{  //车辆采购实现类
	@FXML  
	private TextField carid;
	@FXML  
	private TextField carname;
	@FXML  
	private TextField carmanufacturer;
	@FXML  
	private TextField carmodel;
	@FXML  
	private TextField carcolor;
	@FXML  
	private TextField carnumber;
	@FXML  
	private TextField carprice;
	@FXML  
	private TextField carps;
	@FXML  
	private AnchorPane caigou;
	private static Addcar addcar ;
	private static Stage newAlertDialog ;
	Addcar()//构造函数
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Buy_Car.fxml"));  //载入UI
	     fXMLLoader.setRoot(Addcar.this);  
	     fXMLLoader.setController(Addcar.this); 
	     try {  
	            fXMLLoader.load();
	     
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_addcar_window() {  	//显示UI
	        newAlertDialog = new Stage(StageStyle.DECORATED);
	        newAlertDialog.setTitle("添加轿车");
	        newAlertDialog.setResizable(false);  
	        addcar= new Addcar();  
	        newAlertDialog.setScene(new Scene(addcar));  
	        newAlertDialog.showAndWait();
	    } 
     public void onbuybutton() throws Exception{
    	    Connection DB_Connection=null;
			PreparedStatement SQL_Prepared=null;
			ResultSet result = null;
			String cid=carid.getText();
 	        String cmodel=carmodel.getText();
 	        String cname=carname.getText();
 	        String ccolor=carcolor.getText();
 	        String cm=carmanufacturer.getText();
 	        String cprice=carprice.getText();
 	        String cnumber=carnumber.getText();
 	        String cps=carps.getText();
 	        int ui=Integer.parseInt(cnumber);
    	 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");	// 加载Oracle驱动程序
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// 获取连接		        
			 String SQL="SELECT 轿车编号 FROM 轿车信息库存表 WHERE 轿车编号='"+cid+"'";
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     if(result.next()!=false){
			    	 Alert alert=new Alert(AlertType.WARNING);
					 alert.setTitle("Error");
					 alert.setHeaderText("轿车编号已存在！");
					 alert.showAndWait();
				 }else
				 {
					System.out.println("开始");
				    String SQL2="INSERT INTO 轿车信息库存表  VALUES('"+cid+"','"+cmodel+"','"+cname+"','"+ccolor+"',"+ui+",'"+cm+"'，'"+cprice+"','"+cps+"')";
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
          public void abandon() throws Exception{
    	 Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("确认");
			alert.setHeaderText("确定放弃");
			alert.showAndWait();
			newAlertDialog.close();
			
    	 
    	 
     }
}