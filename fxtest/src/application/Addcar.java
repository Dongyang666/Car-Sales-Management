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

public class Addcar extends AnchorPane{  //�����ɹ�ʵ����
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
	Addcar()//���캯��
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Buy_Car.fxml"));  //����UI
	     fXMLLoader.setRoot(Addcar.this);  
	     fXMLLoader.setController(Addcar.this); 
	     try {  
	            fXMLLoader.load();
	     
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_addcar_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);
	        newAlertDialog.setTitle("��ӽγ�");
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
			 Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Oracle��������
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// ��ȡ����		        
			 String SQL="SELECT �γ���� FROM �γ���Ϣ���� WHERE �γ����='"+cid+"'";
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     if(result.next()!=false){
			    	 Alert alert=new Alert(AlertType.WARNING);
					 alert.setTitle("Error");
					 alert.setHeaderText("�γ�����Ѵ��ڣ�");
					 alert.showAndWait();
				 }else
				 {
					System.out.println("��ʼ");
				    String SQL2="INSERT INTO �γ���Ϣ����  VALUES('"+cid+"','"+cmodel+"','"+cname+"','"+ccolor+"',"+ui+",'"+cm+"'��'"+cprice+"','"+cps+"')";
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
          public void abandon() throws Exception{
    	 Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("ȷ��");
			alert.setHeaderText("ȷ������");
			alert.showAndWait();
			newAlertDialog.close();
			
    	 
    	 
     }
}