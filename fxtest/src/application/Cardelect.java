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

public class Cardelect extends AnchorPane{
	
	@FXML
    private TableView<Car>cartable;
	private static Cardelect cardelect ;
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


	
	Cardelect()//���캯��
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("cardelect.fxml"));  //����UI
	     fXMLLoader.setRoot(Cardelect.this);  
	     fXMLLoader.setController(Cardelect.this); 
	     try {  
	            fXMLLoader.load();      
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);    
	     }
	}	
	 public  void show_cardelect_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false);
	        newAlertDialog.setTitle("ɾ���γ���Ϣ");
	        cardelect = new Cardelect();  
	        newAlertDialog.setScene(new Scene(cardelect));  
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
	            System.out.println("���ݿ������ѹر� ��");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
}
@FXML
public void cardelect(){
	Delect de=new Delect();
	de.show_delect_window();
	
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

	