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
import application.Car; 

public class Show_kucun extends AnchorPane{
	@FXML
    private TableView<Car>cartable;
	private static Show_kucun show_kucun ;
	private static Stage newAlertDialog ;
	private final ObservableList<Car>car_data=FXCollections.observableArrayList();
	@FXML
	private TableColumn<Car,String> car_id;
	@FXML
	private TableColumn<Car, String> carmodel;
	@FXML
    private TableColumn<Car, String> carname;
	@FXML	
	private TableColumn<Car, String> carcolor;
	@FXML
	private TableColumn<Car, String> ckucun;
	@FXML
	private TableColumn<Car, String> cproduct;
	@FXML
	private TableColumn<Car, String> cprice;
	@FXML
	private TableColumn<Car, String> cps;
	Show_kucun()//���캯��
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Show_kucun.fxml"));  //����UI
	     fXMLLoader.setRoot(Show_kucun.this);  
	     fXMLLoader.setController(Show_kucun.this); 
	     try {  
	            fXMLLoader.load();      
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);    
	     }
	}	
	 public  void show_kucun_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false);
	        newAlertDialog.setTitle("�����Ϣ");
	        show_kucun = new Show_kucun();  
	        newAlertDialog.setScene(new Scene(show_kucun));  
	        newAlertDialog.show();
	    }  
@FXML
public void showcarinformation(){
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
	        String sql = "select * from �γ���Ϣ����";// Ԥ������䣬�������������
	        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
	        //pre.setString(1, "0002");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
	        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
	        car_data.clear();
	        while (result.next())
	        {
	        
	            // ���������Ϊ��ʱ
	           //System.out.println("Ա�����" + result.getString("���֤"));
	                    //+ result.getString("����"));
	        	car_data.add(new Car(result.getString("�γ����"),result.getString("�γ��ͺ�"),result.getString("�γ�����"),result.getString("��ɫ"),result.getString("�����"),result.getString("��������"),result.getString("�����۸�"),result.getString("��ע")));
	        	
	        }
	    	cartable.setItems(car_data);  
	    	
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
   	car_id.setCellValueFactory(cellData -> cellData.getValue().car_idProperty());
    carmodel.setCellValueFactory(cellData -> cellData.getValue().carmodelProperty());
    carname.setCellValueFactory(cellData -> cellData.getValue().carnameProperty());
    carcolor.setCellValueFactory(cellData -> cellData.getValue().carcolorProperty());
    ckucun.setCellValueFactory(cellData -> cellData.getValue().ckucunProperty());
    cproduct.setCellValueFactory(cellData -> cellData.getValue().cproductProperty());
    cprice.setCellValueFactory(cellData -> cellData.getValue().cpriceProperty());
    cps.setCellValueFactory(cellData -> cellData.getValue().cpsProperty());

}
}

	