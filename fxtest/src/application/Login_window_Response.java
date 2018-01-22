package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Login_window_Response extends AnchorPane{

	@FXML  
	private TextField Account_Edit;
	@FXML  
	private PasswordField Password_Edit;
	@FXML  
    private Button LoginButton;
	@FXML  
    private Button QuitButton;
	
	private static Login_window_Response login_window_response;
	private static Stage newAlertDialog ;
	public static int  LoginTimes=0;

	Login_window_Response()//���캯��
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Login_View.fxml"));  //����UI
	     fXMLLoader.setRoot(Login_window_Response.this);  
	     fXMLLoader.setController(Login_window_Response.this); 
	     try {  
	            fXMLLoader.load();  
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_login_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.UNDECORATED);  
	        newAlertDialog.setResizable(false);  
	        login_window_response = new Login_window_Response();  
	        newAlertDialog.setScene(new Scene(login_window_response));  
	        newAlertDialog.showAndWait();
	    }  
	      
	 public static void hideAlertDialog() {  //�رմ���
	        if(newAlertDialog != null) {  
	            newAlertDialog.close();  
	        }  
	    }
	
	
	@SuppressWarnings({ "unused" })
	@FXML
	public void onLoginButtonClick() throws Exception//��½�¼���Ӧ
	{
		
		if(Account_Edit.getText().replace(" ", "").equals("")||Password_Edit.getText().replace(" ", "").equals(""))//�ж��˺Ż������Ƿ�Ϊ��
		{
			if(Account_Edit.getText().replace(" ", "").equals(""))//�ж��˺��Ƿ�Ϊ�գ��ǣ�����˺�Ϊ��Error
			{
				Alert alert=new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Username_not_null");
				alert.showAndWait();
				 LoginTimes++;
				 login_times_detection();
			}
			else
			{
				Alert alert=new Alert(AlertType.WARNING);//�������Ϊ��Error
				alert.setTitle("Error");
				alert.setHeaderText("Password_not_null");
				alert.showAndWait();
				LoginTimes++;
				login_times_detection();
			}
		}
		else
		{
			Connection con = null;		// ����һ�����ݿ�����
		    PreparedStatement pre = null;	// ����Ԥ����������һ�㶼�������������Statement
		    try
		    {
		        Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Oracle��������
		        //System.out.println("��ʼ�����������ݿ⣡");
		        String user = Account_Edit.getText();		// �û���
		        String password = Password_Edit.getText();		// ����
		        con = DriverManager.getConnection(Main.url, user, password);// ��ȡ����		        
		        System.out.println("���ӳɹ���");        
		        Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Welcome");
				alert.setHeaderText("Connect succeed");
				alert.showAndWait();
				 if (pre != null)		
		               pre.close();  	//�ͷ����ӽ�
		         if (con != null)
		               con.close();		//�ͷ����ӽ�
		         System.out.println("�����ѶϿ�");
		         Main.Account=Account_Edit.getText();
		         Main.Password=Password_Edit.getText();
				newAlertDialog.close();//�����෽���رմ���
		    }
		    catch (Exception e)
		    {
		    	System.out.println(e.toString()); 
		    	Alert alert=new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Incorrect username or password");
				alert.showAndWait();
				Account_Edit.setText(null);
				Password_Edit.setText(null);
				LoginTimes++;
				login_times_detection();
		    }
		}
		
	}
	
	public void login_times_detection()//��½������¼������3�Σ������˳�
	{
		if(3==LoginTimes)
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Three times to enter  the error message!");
			alert.setContentText("       			The system will exit!");
			alert.showAndWait();
			System.exit(0);
		}
	}
	
	public void onQuitButtonClick()//�˳��¼���Ӧ
	{
		System.exit(0);
	}
}
