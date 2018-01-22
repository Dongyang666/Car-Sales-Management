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

	public class Delete_service extends AnchorPane  {       //ɾ���ͻ���Ϣ��

		private static Delete_service sdelect;
		private static Stage newAlertDialog ;
		  @FXML
		private TextField service_id;
		public Delete_service() 
		{
			 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Delete_Service_View.fxml"));  //����UI
		     fXMLLoader.setRoot(Delete_service.this);  
		     fXMLLoader.setController(Delete_service.this); 
		     try {  
		            fXMLLoader.load();
		     
		     } catch (IOException exception) {  
		            throw new RuntimeException(exception);  
		     }
		}	
		 public  void show_service_delect_window() {  	//��ʾUI
		        newAlertDialog = new Stage(StageStyle.DECORATED);  
		        newAlertDialog.setResizable(false);  
		        newAlertDialog.setTitle("���ɾ���ͻ�");
		        sdelect= new Delete_service();  
		        newAlertDialog.setScene(new Scene(sdelect));  
		        newAlertDialog.showAndWait();
		    } 
		
			public void service_delete_button() {
			    Connection DB_Connection=null;
				PreparedStatement SQL_Prepared=null;
				ResultSet result = null;
			 try{
				 Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
				 String idd=service_id.getText();
				 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// ��ȡ����		        
				 String SQL="delete  FROM �ۺ����� WHERE �������='"+idd+"'";
				 Alert alert=new Alert(AlertType.CONFIRMATION);
					alert.setTitle("ȷ��ɾ��");
					alert.setHeaderText("ȷ��ɾ��");
					alert.showAndWait();
				 SQL_Prepared=DB_Connection.prepareStatement(SQL);
			     result=SQL_Prepared.executeQuery();
			     Alert alert1=new Alert(AlertType.INFORMATION);
					alert1.setTitle("ɾ���ɹ�");
					alert1.setHeaderText("ɾ���ɹ�");
					alert1.showAndWait();
			     
			     }catch(Exception e){
					 e.printStackTrace();
				 }
				 try
				 {
					 if (result != null)// ��һ������ļ�������ر�
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

	


