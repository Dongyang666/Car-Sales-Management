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


	
	Cardelect()//构造函数
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("cardelect.fxml"));  //载入UI
	     fXMLLoader.setRoot(Cardelect.this);  
	     fXMLLoader.setController(Cardelect.this); 
	     try {  
	            fXMLLoader.load();      
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);    
	     }
	}	
	 public  void show_cardelect_window() {  	//显示UI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false);
	        newAlertDialog.setTitle("删除轿车信息");
	        cardelect = new Cardelect();  
	        newAlertDialog.setScene(new Scene(cardelect));  
	        newAlertDialog.show();
	    }  
@FXML
public void showcarinformation(){
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
	        String sql = "select * from 轿车信息库存表";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(sql);// 实例化预编译语句
	        //pre.setString(1, "0002");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	        car_data.clear();
	        while (result.next())
	        {
	        
	            // 当结果集不为空时
	           //System.out.println("员工编号" + result.getString("身份证"));
	                    //+ result.getString("姓名"));
	        	car_data.add(new Car(result.getString("轿车编号"),result.getString("轿车型号"),result.getString("轿车名称"),result.getString("颜色"),result.getString("库存量"),result.getString("生产厂家"),result.getString("出厂价格"),result.getString("备注")));
	        	
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
	            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
	            // 注意关闭的顺序，最后使用的最先关闭
	            if (result != null)
	                result.close();
	            if (pre != null)
	                pre.close();
	            if (con != null)
	                con.close();
	            System.out.println("数据库连接已关闭 ！");
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

	