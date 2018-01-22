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

public class Addcustomer extends AnchorPane{     //��ӿͻ���Ϣ��
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
	Addcustomer()//���캯��
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Add_customer.fxml"));  //����UI
	     fXMLLoader.setRoot(Addcustomer.this);  
	     fXMLLoader.setController(Addcustomer.this); 
	     try {  
	            fXMLLoader.load();
	     
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_addcustomer_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);
	        newAlertDialog.setTitle("��ӿͻ�");
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
			 Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Oracle��������
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// ��ȡ����		        
			 String SQL="SELECT �ͻ���� FROM �ͻ���Ϣ�� WHERE �ͻ����='"+acid+"'";
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     if(result.next()!=false){
			    	 Alert alert=new Alert(AlertType.WARNING);
					 alert.setTitle("Error");
					 alert.setHeaderText("�ͻ�����Ѵ��ڣ�");
					 alert.showAndWait();
				 }else
				 {
					System.out.println("��ʼ");
				    String SQL2="INSERT INTO �ͻ���Ϣ��  VALUES('"+acid+"','"+acname+"','"+acleveal+"','"+acnumber+"','"+acaddress+"','"+acitem+"')";
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
          public void add_exit() throws Exception{
    	 Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("ȷ��");
			alert.setHeaderText("ȷ������");
			alert.showAndWait();
			newAlertDialog.close();
			
    	 
    	 
     }
}