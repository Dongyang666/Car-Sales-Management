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
import application.Orders;

public class Show_Car_Orders extends AnchorPane{
	
	@FXML
    private TableView<Orders> car_oders;
	private static Show_Car_Orders show_Car_Orders ;
	private static Stage newAlertDialog ;
	private final ObservableList<Orders> car_order_data=FXCollections.observableArrayList();
	@FXML
	private TableColumn<Orders,String> oid;
	@FXML
	private TableColumn<Orders, String> oday;
	@FXML
    private TableColumn<Orders, String> cid;
	@FXML	
	private TableColumn<Orders, String> cmodel;
	@FXML
	private TableColumn<Orders, String> color;
	@FXML
	private TableColumn<Orders, String> number;
	@FXML
	private TableColumn<Orders, String> price;
	@FXML
	private TableColumn<Orders, String> sid;
	@FXML
	private TableColumn<Orders, String> carid;
	@FXML
	private TableColumn<Orders, String> ps;
	Show_Car_Orders()//���캯��
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Show_Car_orders.fxml"));  //����UI
	     fXMLLoader.setRoot(Show_Car_Orders.this);  
	     fXMLLoader.setController(Show_Car_Orders.this); 
	     try {  
	            fXMLLoader.load();      
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);    
	     }
	}	
	 public  void show_car_order_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false);
	        newAlertDialog.setTitle("���۶�����ѯ");
	        show_Car_Orders= new Show_Car_Orders();  
	        newAlertDialog.setScene(new Scene(show_Car_Orders));  
	        newAlertDialog.show();
	    }  
@FXML
public void show_car_sale(){
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
	        String sql = "select * from �γ����۱�";// Ԥ������䣬�������������
	        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
	        //pre.setString(1, "0002");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
	        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
	        car_order_data.clear();
	        while (result.next())
	        {
	        
	            // ���������Ϊ��ʱ
	           //System.out.println("Ա�����" + result.getString("���֤"));
	                    //+ result.getString("����"));
	        	car_order_data.add(new Orders(result.getString("�������"),result.getString("��������"),result.getString("�ͻ����"),result.getString("�γ��ͺ�"),result.getString("��ɫ"),result.getString("����"),result.getString("ʵ���ۼ�"),result.getString("�����˱��"),result.getString("��������"),result.getString("��ע")));
	        	
	        }
	        car_oders.setItems(car_order_data);  
	    	
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
 public void exit(){
	 newAlertDialog.close();
 }
 @FXML
 public void deleteorders(){
	 o_delete od=new o_delete();
	 od.show_delect_window();
 }

@FXML
private void initialize() {
   	oid.setCellValueFactory(cellData -> cellData.getValue().oidProperty());
    oday.setCellValueFactory(cellData -> cellData.getValue().odayProperty());
    cid.setCellValueFactory(cellData -> cellData.getValue().cidProperty());
    cmodel.setCellValueFactory(cellData -> cellData.getValue().cmodelProperty());
    color.setCellValueFactory(cellData -> cellData.getValue().colorProperty());
    number.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
    price.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
    sid.setCellValueFactory(cellData -> cellData.getValue().sidProperty());
    carid.setCellValueFactory(cellData -> cellData.getValue().caridProperty());
    ps.setCellValueFactory(cellData -> cellData.getValue().psProperty());

}
}

	