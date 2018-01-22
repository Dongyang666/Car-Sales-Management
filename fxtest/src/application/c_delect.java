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

public class c_delect extends AnchorPane  {       //ɾ���ͻ���Ϣ��

	private static c_delect cdelect;
	private static Stage newAlertDialog ;
	  @FXML
	private TextField delete_cid;
	public c_delect() 
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Customerdelete_View.fxml"));  //����UI
	     fXMLLoader.setRoot(c_delect.this);  
	     fXMLLoader.setController(c_delect.this); 
	     try {  
	            fXMLLoader.load();
	     
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_customer_delect_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false);  
	        newAlertDialog.setTitle("���ɾ���ͻ�");
	        cdelect= new c_delect();  
	        newAlertDialog.setScene(new Scene(cdelect));  
	        newAlertDialog.showAndWait();
	    } 
	
	public void delete_customer_button(){
		    Connection DB_Connection=null;
			PreparedStatement SQL_Prepared=null;
			ResultSet result = null;
		 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
			 String idd=delete_cid.getText();
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// ��ȡ����		        
			 String SQL="delete  FROM �ͻ���Ϣ�� WHERE �ͻ����='"+idd+"'";
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
