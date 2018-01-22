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

	
	Show_Service_Class()//构造函数
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Show_Service.fxml"));  //载入UI
	     fXMLLoader.setRoot(Show_Service_Class.this);  
	     fXMLLoader.setController(Show_Service_Class.this); 
	     try {  
	            fXMLLoader.load();      
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);    
	     }
	}	
	 public  void show_service_record_window() {  	//显示UI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false);
	        newAlertDialog.setTitle("轿车保养信息");
	        show_Service_class = new Show_Service_Class();  
	        newAlertDialog.setScene(new Scene(show_Service_class));  
	        newAlertDialog.show();
	    }  
@FXML
public void show_service_record(){
	Connection con = null;// 创建一个数据库连接
	PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	ResultSet result = null;// 创建一个结果集对象
	 try
	    {
	        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
	        System.out.println("开始尝试连接数据库！");
	        String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
	        String user = "scott";// 用户名,系统默认的账户名
	        String password = "a331335278a";// 你安装时选设置的密码
	        con = DriverManager.getConnection(url, user, password);// 获取连接
	        System.out.println("连接成功！");
	        String sql = "select * from 售后管理表";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(sql);// 实例化预编译语句
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	        service_data.clear();
	        while (result.next())
	        {
	        	service_data.add(new Service(result.getString("服务序号"),result.getString("保养日期"),result.getString("客户编号"),result.getString("车辆牌照"),result.getString("保养人编号"),result.getString("业务记录")));
	        	
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
	            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
	            // 注意关闭的顺序，最后使用的最先关闭
	            if (result != null)
	                result.close();
	            if (pre != null)
	                pre.close();
	            if (con != null)
	                con.close();
	            System.out.println("数据库连接已关闭！");
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

	