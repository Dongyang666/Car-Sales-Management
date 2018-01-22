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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import application.Main;
public class Car_sale extends AnchorPane{ 
	@FXML
	ComboBox<String>  sale_cid;
	@FXML  
	private TextField sale_cname;
	@FXML  
	private TextField sale_ps;
	@FXML  
	private TextField sale_cleveal;
	@FXML  
	private TextField sale_cnumber;
	@FXML  
	private TextField sale_caddress;
	@FXML  
	private TextField sale_cproduct;
	@FXML  
	private TextField sale_id;
	@FXML  
	private TextField sale_day;
	@FXML  
	private TextField sale_cmodel;
	@FXML  
	private TextField sale_color;
	@FXML  
	private TextField sale_number;
	@FXML  
	private TextField sale_price;
	@FXML  
	private TextField sale_saleman;
	@FXML  
	private TextField sale_cardid;
	private static Car_sale car_sale ;
	private static Stage newAlertDialog ;
	Car_sale()//���캯��
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("car_sale.fxml"));  //����UI
	     fXMLLoader.setRoot(Car_sale.this);  
	     fXMLLoader.setController(Car_sale.this); 
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
			 String SQL="SELECT �ͻ���� FROM �ͻ���Ϣ�� ";
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     while(result.next()!=false){
		    	 String ls=result.getString("�ͻ����"); 
		    	 sale_cid.getItems().add(ls);
		    	 
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
	 public  void show_sale_car_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);
	        newAlertDialog.setTitle("��ӽγ�");
	        newAlertDialog.setResizable(false);  
	        car_sale= new Car_sale();  
	        newAlertDialog.setScene(new Scene(car_sale));  
	        newAlertDialog.showAndWait();
	    } 
     public void show_car_information() throws Exception{
    	    Connection DB_Connection=null;
			PreparedStatement SQL_Prepared=null;
			ResultSet result = null;
			
    	 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Oracle��������
			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// ��ȡ����		 
			 String sc=sale_cid.getValue();
			 String SQL="SELECT * FROM �ͻ���Ϣ�� where �ͻ����="+sc+" ";
			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
		     result=SQL_Prepared.executeQuery();
		     if(result.next()!=false){
		    	 sale_cname.setText(result.getString("�ͻ�����"));
			     sale_cleveal.setText(result.getString("�ͻ��ȼ�"));
			     sale_cnumber.setText(result.getString("��ϵ�绰"));
			     sale_caddress.setText(result.getString("��ַ"));
			     sale_cproduct.setText(result.getString("�Ż���Ŀ")); 
			     sale_cname.setEditable(false);
			     sale_cleveal.setEditable(false);
			     sale_cnumber.setEditable(false);
			     sale_caddress.setEditable(false);
			     sale_cproduct.setEditable(false);
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
          public void sale_car_button() throws Exception{
        	  Connection DB_Connection=null;
  			PreparedStatement SQL_Prepared=null;
  			ResultSet result = null;
  			String sid=sale_id.getText();
   	        String sday=sale_day.getText();
   	        String scid=sale_cid.getValue();
   	        String smodel=sale_cmodel.getText();
   	        String scolor=sale_color.getText();
   	        String snumber=sale_number.getText();
   	        String sprice=sale_price.getText();
   	        String ssleman=sale_saleman.getText();
   	        String scarid=sale_cardid.getText();
   	        String sp=sale_ps.getText();
   	        int ui=Integer.parseInt(snumber);
      	 try{
  			 Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Oracle��������
  			 DB_Connection = DriverManager.getConnection(Main.url, Main.Account, Main.Password);// ��ȡ����		        
  			 String SQL="SELECT ������� FROM �γ����۱� WHERE �������='"+sid+"'";
  			 SQL_Prepared=DB_Connection.prepareStatement(SQL);
  		     result=SQL_Prepared.executeQuery();
  		     if(result.next()!=false){
  			    	 Alert alert=new Alert(AlertType.WARNING);
  					 alert.setTitle("Error");
  					 alert.setHeaderText("��������Ѵ��ڣ�");
  					 alert.showAndWait();
  				 }else
  				 {
  					System.out.println("��ʼ");
  				    Alert alert=new Alert(AlertType.CONFIRMATION);
  					alert.setTitle("�µ�");
  					alert.setHeaderText("ȷ���µ�");
  					alert.showAndWait();
  					String SQL2="INSERT INTO �γ����۱�  VALUES('"+sid+"','"+sday+"','"+scid+"','"+smodel+"','"+scolor+"',"+ui+",'"+sprice+"','"+ssleman+"','"+scarid+"','"+sp+"')";
  					SQL_Prepared=DB_Connection.prepareStatement(SQL2);
  				    result=SQL_Prepared.executeQuery();
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