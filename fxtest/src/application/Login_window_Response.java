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

	Login_window_Response()//构造函数
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Login_View.fxml"));  //载入UI
	     fXMLLoader.setRoot(Login_window_Response.this);  
	     fXMLLoader.setController(Login_window_Response.this); 
	     try {  
	            fXMLLoader.load();  
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_login_window() {  	//显示UI
	        newAlertDialog = new Stage(StageStyle.UNDECORATED);  
	        newAlertDialog.setResizable(false);  
	        login_window_response = new Login_window_Response();  
	        newAlertDialog.setScene(new Scene(login_window_response));  
	        newAlertDialog.showAndWait();
	    }  
	      
	 public static void hideAlertDialog() {  //关闭窗口
	        if(newAlertDialog != null) {  
	            newAlertDialog.close();  
	        }  
	    }
	
	
	@SuppressWarnings({ "unused" })
	@FXML
	public void onLoginButtonClick() throws Exception//登陆事件响应
	{
		
		if(Account_Edit.getText().replace(" ", "").equals("")||Password_Edit.getText().replace(" ", "").equals(""))//判断账号或密码是否为空
		{
			if(Account_Edit.getText().replace(" ", "").equals(""))//判断账号是否为空，是，输出账号为空Error
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
				Alert alert=new Alert(AlertType.WARNING);//输出密码为空Error
				alert.setTitle("Error");
				alert.setHeaderText("Password_not_null");
				alert.showAndWait();
				LoginTimes++;
				login_times_detection();
			}
		}
		else
		{
			Connection con = null;		// 创建一个数据库连接
		    PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
		    try
		    {
		        Class.forName("oracle.jdbc.driver.OracleDriver");	// 加载Oracle驱动程序
		        //System.out.println("开始尝试连接数据库！");
		        String user = Account_Edit.getText();		// 用户名
		        String password = Password_Edit.getText();		// 密码
		        con = DriverManager.getConnection(Main.url, user, password);// 获取连接		        
		        System.out.println("连接成功！");        
		        Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Welcome");
				alert.setHeaderText("Connect succeed");
				alert.showAndWait();
				 if (pre != null)		
		               pre.close();  	//释放连接接
		         if (con != null)
		               con.close();		//释放连接接
		         System.out.println("连接已断开");
		         Main.Account=Account_Edit.getText();
		         Main.Password=Password_Edit.getText();
				newAlertDialog.close();//调用类方法关闭窗口
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
	
	public void login_times_detection()//登陆次数记录，超过3次，程序退出
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
	
	public void onQuitButtonClick()//退出事件响应
	{
		System.exit(0);
	}
}
