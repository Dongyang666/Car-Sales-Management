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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Main_Sceen_Response extends AnchorPane{
	@FXML
    private TableView<Stuff>stuff_table;
	@FXML
    private TableView<Orders>car_sale_table;
	@FXML
    private TableView<Customer>customer_table;
	@FXML
    private TableView<Car>remark_table;
	@FXML  
	private TextField sidcolumn_text;
	@FXML  
	private TextField sname_text;
	@FXML  
	private TextField scard_text;
	@FXML  
	private TextField oid_text;
	@FXML  
	private TextField cid_text;
	@FXML  
	private TextField sid_text;
	@FXML  
	private TextField cidcolumn_text;
	@FXML  
	private TextField cname_text;
	@FXML  
	private TextField cnumber_text;
	@FXML  
	private TextField car_id_text;
	@FXML  
	private TextField carmodel_text;
	@FXML
	private TableColumn<Stuff,String> sidcolumn ;
	@FXML
	private TableColumn<Stuff,String> snamecolumn ;
	@FXML
	private TableColumn<Stuff,String> ssexcolumn ;
	@FXML
	private TableColumn<Stuff,String> sbrithcolumn ;
	@FXML
	private TableColumn<Stuff,String> saddresscolumn ;
	@FXML
	private TableColumn<Stuff,String> stucolumn ;
	@FXML
	private TableColumn<Stuff,String> snumbercolumn ;
	@FXML
	private TableColumn<Stuff,String> sstationcolumn ;
	@FXML
	private TableColumn<Stuff,String> scardcolumn ;
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
	@FXML
	private TableColumn<Customer, String> cidcolumn;
	@FXML
	private TableColumn<Customer, String> cnamecolumn;
	@FXML
	private TableColumn<Customer, String> clevealcolumn;
	@FXML
	private TableColumn<Customer, String> cnumbercolumn;
	@FXML
	private TableColumn<Customer, String> caddresscolumn;
	@FXML
	private TableColumn<Customer, String> citemcolumn;
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
	private final ObservableList<Stuff>stuff_data=FXCollections.observableArrayList();
	private final ObservableList<Orders>car_orders_data=FXCollections.observableArrayList();
	private final ObservableList<Customer>customer_data=FXCollections.observableArrayList();
	private final ObservableList<Car>car_remark_data=FXCollections.observableArrayList();
	private static Main_Sceen_Response  main_Sceen_Response;
	private static Stage newAlertDialog ;

	Main_Sceen_Response()//构造函数
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Main_Sceen.fxml"));  //载入UI
	     fXMLLoader.setRoot(Main_Sceen_Response.this);  
	     fXMLLoader.setController(Main_Sceen_Response.this); 
	     try {  
	            fXMLLoader.load();
	     
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_login_window() {  	//显示UI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false); 
	        newAlertDialog.setTitle("主界面");
	        main_Sceen_Response = new Main_Sceen_Response();  
	        newAlertDialog.setScene(new Scene(main_Sceen_Response));  
	        newAlertDialog.showAndWait();
	    } 
	@FXML
	public void selectsidcolumn() throws Exception{
		Connection con = null;		// 创建一个数据库连接
	    PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
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
	        String sql ="select * from 员工信息表 where 员工编号="+sidcolumn_text.getText()+" ";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(sql);// 实例化预编译语句
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参
	        stuff_data.clear();
	        while (result.next())
	        {
	        	stuff_data.add(new Stuff(result.getString("员工编号"),result.getString("姓名"),result.getString("性别"),result.getString("出生日期"),result.getString("籍贯"),result.getString("学历"),result.getString("联系电话"),result.getString("岗位"),result.getString("身份证")));
	        	
	        }
	    	stuff_table.setItems(stuff_data);          
	    }
	    catch (Exception e)
	    {
	    	System.out.println(e.toString()); 
	    	
	    }
	}
	@FXML
	public void selectsname() throws Exception{
		Connection con = null;		// 创建一个数据库连接
	    PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
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
	        String sql ="select * from 员工信息表 where 姓名='"+sname_text.getText()+ "'";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(sql);// 实例化预编译语句
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参
	        stuff_data.clear();
	        while (result.next())
	        {
	        	stuff_data.add(new Stuff(result.getString("员工编号"),result.getString("姓名"),result.getString("性别"),result.getString("出生日期"),result.getString("籍贯"),result.getString("学历"),result.getString("联系电话"),result.getString("岗位"),result.getString("身份证")));
	        	
	        }
	    	stuff_table.setItems(stuff_data);          
	    }
	    catch (Exception e)
	    {
	    	System.out.println(e.toString()); 
	    	
	    }
	}
	@FXML
	public void selectscard() throws Exception{
		Connection con = null;		// 创建一个数据库连接
	    PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
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
	        String sql ="select * from 员工信息表 where 身份证="+scard_text.getText()+ "";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(sql);// 实例化预编译语句
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参
	        stuff_data.clear();
	        while (result.next())
	        {
	        	stuff_data.add(new Stuff(result.getString("员工编号"),result.getString("姓名"),result.getString("性别"),result.getString("出生日期"),result.getString("籍贯"),result.getString("学历"),result.getString("联系电话"),result.getString("岗位"),result.getString("身份证")));
	        	
	        }
	    	stuff_table.setItems(stuff_data);          
	    }
	    catch (Exception e)
	    {
	    	System.out.println(e.toString()); 
	    	
	    }
}
	@FXML
	public void select_stuff_all() throws Exception{
		Connection con = null;		// 创建一个数据库连接
	    PreparedStatement pre = null;	// 创建预编译语句对象，一般都是用这个而不用Statement
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
	        String sql ="select * from 员工信息表 ";// 预编译语句，“？”代表参数
	        pre = con.prepareStatement(sql);// 实例化预编译语句
	        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参
	        stuff_data.clear();
	        while (result.next())
	        {
	        	stuff_data.add(new Stuff(result.getString("员工编号"),result.getString("姓名"),result.getString("性别"),result.getString("出生日期"),result.getString("籍贯"),result.getString("学历"),result.getString("联系电话"),result.getString("岗位"),result.getString("身份证")));
	        	
	        }
	    	stuff_table.setItems(stuff_data);          
	    }
	    catch (Exception e)
	    {
	    	System.out.println(e.toString()); 
	    	
	    }
	}
	@FXML
	public void selectoid() throws Exception{
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
		        String sql = "select * from 轿车销售表 where 销售序号="+oid_text.getText()+"";// 预编译语句，“？”代表参数
		        pre = con.prepareStatement(sql);// 实例化预编译语句
		        //pre.setString(1, "0002");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
		        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		        car_orders_data.clear();
		        while (result.next())
		        {
		        
		            // 当结果集不为空时
		           //System.out.println("员工编号" + result.getString("身份证"));
		                    //+ result.getString("姓名"));
		        	car_orders_data.add(new Orders(result.getString("销售序号"),result.getString("销售日期"),result.getString("客户编号"),result.getString("轿车型号"),result.getString("颜色"),result.getString("数量"),result.getString("实际售价"),result.getString("经手人编号"),result.getString("车辆牌照"),result.getString("备注")));
		        	
		        }
		        car_sale_table.setItems(car_orders_data);  
		    	
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
	public void selectcid() throws Exception{
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
		        String sql = "select * from 轿车销售表 where 客户编号="+cid_text.getText()+"";// 预编译语句，“？”代表参数
		        pre = con.prepareStatement(sql);// 实例化预编译语句
		        //pre.setString(1, "0002");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
		        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		        car_orders_data.clear();
		        while (result.next())
		        {
		        
		        	car_orders_data.add(new Orders(result.getString("销售序号"),result.getString("销售日期"),result.getString("客户编号"),result.getString("轿车型号"),result.getString("颜色"),result.getString("数量"),result.getString("实际售价"),result.getString("经手人编号"),result.getString("车辆牌照"),result.getString("备注")));
		        	
		        }
		        car_sale_table.setItems(car_orders_data);  
		    	
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
	public void selectsid() throws Exception{
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
		        String sql = "select * from 轿车销售表 where 经手人编号="+sid_text.getText()+"";// 预编译语句，“？”代表参数
		        pre = con.prepareStatement(sql);// 实例化预编译语句
		        //pre.setString(1, "0002");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
		        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		        car_orders_data.clear();
		        while (result.next())
		        {
		        
		        	car_orders_data.add(new Orders(result.getString("销售序号"),result.getString("销售日期"),result.getString("客户编号"),result.getString("轿车型号"),result.getString("颜色"),result.getString("数量"),result.getString("实际售价"),result.getString("经手人编号"),result.getString("车辆牌照"),result.getString("备注")));
		        	
		        }
		        car_sale_table.setItems(car_orders_data);  
		    	
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
	public void select_carsale_all() throws Exception{
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
		        car_orders_data.clear();
		        while (result.next())
		        {
		        
		            // 当结果集不为空时
		           //System.out.println("员工编号" + result.getString("身份证"));
		                    //+ result.getString("姓名"));
		        	car_orders_data.add(new Orders(result.getString("销售序号"),result.getString("销售日期"),result.getString("客户编号"),result.getString("轿车型号"),result.getString("颜色"),result.getString("数量"),result.getString("实际售价"),result.getString("经手人编号"),result.getString("车辆牌照"),result.getString("备注")));
		        	
		        }
		        car_sale_table.setItems(car_orders_data);  
		    	
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
	public void selectcidcolumn() throws Exception{
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
		        String sql = "select * from 客户信息表 where 客户编号="+cidcolumn_text.getText()+"";// 预编译语句，“？”代表参数
		        pre = con.prepareStatement(sql);// 实例化预编译语句
		        //pre.setString(1, "0002");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
		        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		        customer_data.clear();
		        while (result.next())
		        {

		        	customer_data.add(new Customer(result.getString("客户编号"),result.getString("客户姓名"),result.getString("客户等级"),result.getString("联系电话"),result.getString("地址"),result.getString("优惠项目")));
		        	
		        }
		    	customer_table.setItems(customer_data);  
		    	
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
	public void selectcname() throws Exception{
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
		        String sql = "select * from 客户信息表 where 客户姓名='"+cname_text.getText()+"'";// 预编译语句，“？”代表参数
		        pre = con.prepareStatement(sql);// 实例化预编译语句
		        //pre.setString(1, "0002");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
		        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		        customer_data.clear();
		        while (result.next())
		        {

		        	customer_data.add(new Customer(result.getString("客户编号"),result.getString("客户姓名"),result.getString("客户等级"),result.getString("联系电话"),result.getString("地址"),result.getString("优惠项目")));
		        	
		        }
		    	customer_table.setItems(customer_data);  
		    	
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
	public void selectcnumber() throws Exception{
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
		        String sql = "select * from 客户信息表 where 联系电话="+cnumber_text.getText()+"";// 预编译语句，“？”代表参数
		        pre = con.prepareStatement(sql);// 实例化预编译语句
		        //pre.setString(1, "0002");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
		        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		        customer_data.clear();
		        while (result.next())
		        {

		        	customer_data.add(new Customer(result.getString("客户编号"),result.getString("客户姓名"),result.getString("客户等级"),result.getString("联系电话"),result.getString("地址"),result.getString("优惠项目")));
		        	
		        }
		    	customer_table.setItems(customer_data);  
		    	
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
	public void select_customer_all() throws Exception{
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
		        String sql = "select * from 客户信息表";// 预编译语句，“？”代表参数
		        pre = con.prepareStatement(sql);// 实例化预编译语句
		        //pre.setString(1, "0002");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
		        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		        customer_data.clear();
		        while (result.next())
		        {
		        
		            // 当结果集不为空时
		           //System.out.println("员工编号" + result.getString("身份证"));
		                    //+ result.getString("姓名"));
		        	customer_data.add(new Customer(result.getString("客户编号"),result.getString("客户姓名"),result.getString("客户等级"),result.getString("联系电话"),result.getString("地址"),result.getString("优惠项目")));
		        	
		        }
		    	customer_table.setItems(customer_data);  
		    	
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
	public void selectcar_id() throws Exception{
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
		        String sql = "select * from 轿车信息库存表 where 轿车编号="+car_id_text.getText()+"";// 预编译语句，“？”代表参数
		        pre = con.prepareStatement(sql);// 实例化预编译语句
		        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		        car_remark_data.clear();
		        while (result.next())
		        {
		        	car_remark_data.add(new Car(result.getString("轿车编号"),result.getString("轿车型号"),result.getString("轿车名称"),result.getString("颜色"),result.getString("库存量"),result.getString("生产厂家"),result.getString("出厂价格"),result.getString("备注")));
		        	
		        }
		    	remark_table.setItems(car_remark_data);  
		    	
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
	public void selectcarmodel() throws Exception{
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
		        String sql = "select * from 轿车信息库存表 where 轿车型号='"+carmodel_text.getText()+"'";// 预编译语句，“？”代表参数
		        pre = con.prepareStatement(sql);// 实例化预编译语句
		        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		        car_remark_data.clear();
		        while (result.next())
		        {
		        	car_remark_data.add(new Car(result.getString("轿车编号"),result.getString("轿车型号"),result.getString("轿车名称"),result.getString("颜色"),result.getString("库存量"),result.getString("生产厂家"),result.getString("出厂价格"),result.getString("备注")));
		        	
		        }
		    	remark_table.setItems(car_remark_data);  
		    	
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
	public void select_remark_all() throws Exception{
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
		        car_remark_data.clear();
		        while (result.next())
		        {
		        	car_remark_data.add(new Car(result.getString("轿车编号"),result.getString("轿车型号"),result.getString("轿车名称"),result.getString("颜色"),result.getString("库存量"),result.getString("生产厂家"),result.getString("出厂价格"),result.getString("备注")));
		        	
		        }
		    	remark_table.setItems(car_remark_data);  
		    	
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
	
	public void showaddcar()throws Exception{
		Addcar addcar=new Addcar();
		addcar.show_addcar_window();
		
	}
	public void showcardelect()throws Exception{
		Cardelect cardelect=new Cardelect();
		cardelect.show_cardelect_window();	
	}
	public void showcarorder()throws Exception{
		Show_Car_Orders sc=new Show_Car_Orders();
		sc.show_car_order_window();
	}
	public void selectkucuninf()throws Exception{
		Show_kucun sk=new Show_kucun();
				sk.show_kucun_window();
	}
	
	public void carsaleaction()throws Exception{
		Car_sale cs=new Car_sale();
		cs.show_sale_car_window();	
	}
	public void addcustomer(){
		Addcustomer ac=new Addcustomer();
		ac.show_addcustomer_window();
	}
	public void deletecustomer(){
		c_delect cd=new c_delect();
		cd.show_customer_delect_window();
				
	}
	public void helpaction(){
		Help hp=new Help();
		hp.show_help_window();
	}
	public void add_customer_service(){
		
		Add_service as=new Add_service();
		as.show_add_service_window();
				
	}
	public void see_customer_service(){
		Show_Service_Class ssc=new Show_Service_Class();
		ssc.show_service_record_window();
	}
	public void delete_sercice(){
		Delete_service ds=new Delete_service();
		ds.show_service_delect_window();
 }
  
		
	
	
	@FXML
	private void initialize() {
		sidcolumn.setCellValueFactory(cellData -> cellData.getValue().sidcolumnProperty());
		snamecolumn.setCellValueFactory(cellData -> cellData.getValue().snamecolumnProperty());
		ssexcolumn.setCellValueFactory(cellData -> cellData.getValue().ssexcolumnProperty());
		sbrithcolumn.setCellValueFactory(cellData -> cellData.getValue().sbrithcolumnProperty());
		saddresscolumn.setCellValueFactory(cellData -> cellData.getValue().saddresscolumnProperty());
		stucolumn.setCellValueFactory(cellData -> cellData.getValue().stucolumnProperty());
		snumbercolumn.setCellValueFactory(cellData -> cellData.getValue().snumbercolumnProperty());
		sstationcolumn.setCellValueFactory(cellData -> cellData.getValue().sstationcolumnProperty());
		scardcolumn.setCellValueFactory(cellData -> cellData.getValue().scardcolumnProperty());
		
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
		
	    cidcolumn.setCellValueFactory(cellData -> cellData.getValue().cidcolumnProperty());
	    cnamecolumn.setCellValueFactory(cellData -> cellData.getValue().cnamecolumnProperty());
	    clevealcolumn.setCellValueFactory(cellData -> cellData.getValue().clevealcolumnProperty());
	    cnumbercolumn.setCellValueFactory(cellData -> cellData.getValue().cnumbercolumnProperty());
	    caddresscolumn.setCellValueFactory(cellData -> cellData.getValue().caddresscolumnProperty());
	    citemcolumn.setCellValueFactory(cellData -> cellData.getValue().citemcolumnProperty());
	    
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


