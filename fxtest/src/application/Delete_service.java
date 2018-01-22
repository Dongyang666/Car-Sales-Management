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
	import javafx.scene.control.TextField;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.layout.AnchorPane;
	import javafx.stage.Stage;
	import javafx.stage.StageStyle;

	public class Delete_service extends AnchorPane  {       //删除客户信息类

		private static Delete_service sdelect;
		private static Stage newAlertDialog ;
		  @FXML
		private TextField service_id;
		public Delete_service() 
		{
			 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Delete_Service_View.fxml"));  //载入UI
		     fXMLLoader.setRoot(Delete_service.this);  
		     fXMLLoader.setController(Delete_service.this); 
		     try {  
		            fXMLLoader.load();
		     
		     } catch (IOException exception) {  
		            throw new RuntimeException(exception);  
		     }
		}	
		 public  void show_service_delect_window() {  	//显示UI
		        newAlertDialog = new Stage(StageStyle.DECORATED);  
		        newAlertDialog.setResizable(false);  
		        newAlertDialog.setTitle("编号删除客户");
		        sdelect= new Delete_service();  
		        newAlertDialog.setScene(new Scene(sdelect));  
		        newAlertDialog.showAndWait();
		    } 
		
			public void service_delete_button() {
			    Connection DB_Connection=null;
				PreparedStatement SQL_Prepared=null;
				ResultSet result = null;
			 try{
				 Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
				 String idd=service_id.getText();
				 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// 获取连接		        
				 String SQL="delete  FROM 售后管理表 WHERE 服务序号='"+idd+"'";
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

	


