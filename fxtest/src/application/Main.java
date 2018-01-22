package application;
	
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	public static  String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	public static  String Account="scott";
	public static  String Password="a331335278a";
	
	@Override
	public void start(Stage stage) throws Exception {
		Login_window_Response login_window_response=new Login_window_Response();
		login_window_response.show_login_window();
		Main_Sceen_Response hh=new Main_Sceen_Response();
		hh.show_login_window();
		
		
	}	
}
