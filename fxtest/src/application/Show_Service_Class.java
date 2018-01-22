package application;

import java.io.IOException;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import application.Service;

public class Show_Service_Class extends AnchorPane{
	
	@FXML
    private TableView<Service>service_table;
	private static Show_Service_Class show_Service_class ;
	private static Stage newAlertDialog ;
	private final ObservableList<Service>service_data=FXCollections.observableArrayList();
	@FXML
	private TableColumn<Service,String> service_id;
	@FXML
	private TableColumn<Service, String> service_day;
	@FXML
    private TableColumn<Service, String> service_cid;
	@FXML	
	private TableColumn<Service, String> service_carid;
	@FXML
	private TableColumn<Service, String> service_sid;
	@FXML
	private TableColumn<Service, String> service_record;

	
	Show_Service_Class()//���캯��
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Show_Service.fxml"));  //����UI
	     fXMLLoader.setRoot(Show_Service_Class.this);  
	     fXMLLoader.setController(Show_Service_Class.this); 
	     try {  
	            fXMLLoader.load();      
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);    
	     }
	}	
	 public  void show_service_record_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false);
	        newAlertDialog.setTitle("�γ�������Ϣ");
	        show_Service_class = new Show_Service_Class();  
	        newAlertDialog.setScene(new Scene(show_Service_class));  
	        newAlertDialog.show();
	    }  
@FXML
public void show_service_record(){
	Connection con = null;// ����һ�����ݿ�����
	PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
	ResultSet result = null;// ����һ�����������
	 try
	    {
	        Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
	        System.out.println("��ʼ�����������ݿ⣡");
	        String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:orcl";// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
	        String user = "scott";// �û���,ϵͳĬ�ϵ��˻���
	        String password = "a331335278a";// �㰲װʱѡ���õ�����
	        con = DriverManager.getConnection(url, user, password);// ��ȡ����
	        System.out.println("���ӳɹ���");
	        String sql = "select * from �ۺ�����";// Ԥ������䣬�������������
	        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
	        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
	        service_data.clear();
	        while (result.next())
	        {
	        	service_data.add(new Service(result.getString("�������"),result.getString("��������"),result.getString("�ͻ����"),result.getString("��������"),result.getString("�����˱��"),result.getString("ҵ���¼")));
	        	
	        }
	    	service_table.setItems(service_data);  
	    	
	    }

	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	   finally
	    {
	        try
	        {
	            // ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
	            // ע��رյ�˳�����ʹ�õ����ȹر�
	            if (result != null)
	                result.close();
	            if (pre != null)
	                pre.close();
	            if (con != null)
	                con.close();
	            System.out.println("���ݿ������ѹرգ�");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
}
@FXML
private void initialize() {
	service_id.setCellValueFactory(cellData -> cellData.getValue().service_idProperty());
    service_day.setCellValueFactory(cellData -> cellData.getValue().service_dayProperty());
    service_cid.setCellValueFactory(cellData -> cellData.getValue().service_cidProperty());
    service_carid.setCellValueFactory(cellData -> cellData.getValue().service_caridProperty());
    service_sid.setCellValueFactory(cellData -> cellData.getValue().service_sidProperty());
    service_record.setCellValueFactory(cellData -> cellData.getValue().service_recordProperty());

}
}

	