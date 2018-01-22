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
	Add_service()//���캯��
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Add_Service.fxml"));  //����UI
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
			 Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Oracle��������
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// ��ȡ����		        
			 String SQL="SELECT Ա����� FROM Ա����Ϣ�� ";
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     while(result.next()!=false){
		    	 String customer_id=result.getString("Ա�����"); 
		    	 add_sid.getItems().add(customer_id);
		    	 
				 }
		      SQL="SELECT �������� FROM �γ����۱� ";
		      SQL_Prepared=DB_Connection.prepareStatement(SQL);
			     result=SQL_Prepared.executeQuery();
			     while(result.next()!=false){
			    	 String car_id=result.getString("��������"); 
			    	 add_scarid.getItems().add(car_id); 
					 }
			     
	 }				
		     catch(Exception e){
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
	 public  void show_add_service_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);
	        newAlertDialog.setTitle("����ۺ����");
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
			Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Oracle��������
			DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// ��ȡ����		       
			String as=add_scarid.getValue();
		    String SQL="SELECT �ͻ���� FROM �γ����۱� where ��������='"+as+"'";
		    SQL_Prepared=DB_Connection.prepareStatement(SQL);
		    result=SQL_Prepared.executeQuery();
		     while(result.next()!=false){
		     add_scid.setText(result.getString("�ͻ����"));
		      }
		     add_scid.setEditable(false);;
			}
			
		     catch(Exception e){
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
			 Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Oracle��������
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// ��ȡ����		        
			 String SQL="SELECT ������� FROM �ۺ����� WHERE �������='"+assid+"'";
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     if(result.next()!=false){
			    	 Alert alert=new Alert(AlertType.WARNING);
					 alert.setTitle("Error");
					 alert.setHeaderText("�������Ѵ��ڣ�");
					 alert.showAndWait();
				 }else
				 {
					System.out.println("��ʼ");
				    String SQL2="INSERT INTO �ۺ�����  VALUES('"+assid+"','"+asday+"','"+ascid+"','"+ascarid+"','"+asid+"','"+asrecord+"')";
					SQL_Prepared=DB_Connection.prepareStatement(SQL2);
				    result=SQL_Prepared.executeQuery();
				    Alert alert=new Alert(AlertType.WARNING);
					alert.setTitle("��ӳɹ�");
					alert.setHeaderText("��ӳɹ�");
					alert.showAndWait();
				    System.out.println("�ɹ�");
				 }
		     
 	 }
		     catch(Exception e){
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