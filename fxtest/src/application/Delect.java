package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Delect extends AnchorPane  {

	private static Delect delect;
	private static Stage newAlertDialog ;
	  @FXML
	private TextField car_id;
	  @FXML
	private Button but1;
	public Delect() 
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Cardelect_view.fxml"));  //载入UI
	     fXMLLoader.setRoot(Delect.this);  
	     fXMLLoader.setController(Delect.this); 
	     try {  
	            fXMLLoader.load();
	     
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_delect_window() {  	//显示UI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false);  
	        newAlertDialog.setTitle("编号删除轿车");
	        delect= new Delect();  
	        newAlertDialog.setScene(new Scene(delect));  
	        newAlertDialog.showAndWait();
	    } 
	
	public void okdelect(){
		    Connection DB_Connection=null;
			PreparedStatement SQL_Prepared=null;
			ResultSet result = null;
		 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
			 String idd=car_id.getText();
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// 获取连接		        
			 String SQL="delete  FROM 轿车信息库存表 WHERE 轿车编号='"+idd+"'";
			 Alert alert=new Alert(AlertType.CONFIRMATION);
				alert.setTitle("确定删除");
				alert.setHeaderText("确定删除");
				alert.showAndWait();
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     Alert alert1=new Alert(AlertType.INFORMATION);
				alert1.setTitle("删除成功");
				alert1.setHeaderText("删除成功");
				alert1.showAndWait();
		     
		     }catch(Exception e){
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
