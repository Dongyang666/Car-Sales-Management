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
	Show_Car_Orders()//构造函数
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Show_Car_orders.fxml"));  //载入UI
	     fXMLLoader.setRoot(Show_Car_Orders.this);  
	     fXMLLoader.setController(Show_Car_Orders.this); 
	     try {  
	            fXMLLoader.load();      
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);    
	     }
	}	
	 public  void show_car_order_window() {  	//显示UI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false);
	        newAlertDialog.setTitle("销售订单查询");
	        show_Car_Orders= new Show_Car_Orders();  
	        newAlertDialog.setScene(new Scene(show_Car_Orders));  
	        newAlertDialog.show();
	    }  
@FXML
public void show_car_sale(){
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
	        String sql = "select * from 轿车销售表";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(sql);// 实例化预编译语句
	        //pre.setString(1, "0002");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	        car_order_data.clear();
	        while (result.next())
	        {
	        
	            // 当结果集不为空时
	           //System.out.println("员工编号" + result.getString("身份证"));
	                    //+ result.getString("姓名"));
	        	car_order_data.add(new Orders(result.getString("销售序号"),result.getString("销售日期"),result.getString("客户编号"),result.getString("轿车型号"),result.getString("颜色"),result.getString("数量"),result.getString("实际售价"),result.getString("经手人编号"),result.getString("车辆牌照"),result.getString("备注")));
	        	
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

	