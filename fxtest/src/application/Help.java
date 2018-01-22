package application;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.AnchorPane;

public class Help extends AnchorPane {
	private static Help help;
	private static Stage newAlertDialog ;

	public Help() {
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Help.fxml"));  //‘ÿ»ÎUI
	     fXMLLoader.setRoot(Help.this);  
	     fXMLLoader.setController(Help.this); 
	     try {  
	            fXMLLoader.load();  
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_help_window() {  	//œ‘ æUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false);  
	        help = new Help();  
	        newAlertDialog.setScene(new Scene(help));  
	        newAlertDialog.showAndWait();
	    }  
}
