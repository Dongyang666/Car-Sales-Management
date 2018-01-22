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

	Main_Sceen_Response()//���캯��
	{
		 FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("Main_Sceen.fxml"));  //����UI
	     fXMLLoader.setRoot(Main_Sceen_Response.this);  
	     fXMLLoader.setController(Main_Sceen_Response.this); 
	     try {  
	            fXMLLoader.load();
	     
	     } catch (IOException exception) {  
	            throw new RuntimeException(exception);  
	     }
	}	
	 public  void show_login_window() {  	//��ʾUI
	        newAlertDialog = new Stage(StageStyle.DECORATED);  
	        newAlertDialog.setResizable(false); 
	        newAlertDialog.setTitle("������");
	        main_Sceen_Response = new Main_Sceen_Response();  
	        newAlertDialog.setScene(new Scene(main_Sceen_Response));  
	        newAlertDialog.showAndWait();
	    } 
	@FXML
	public void selectsidcolumn() throws Exception{
		Connection con = null;		// ����һ�����ݿ�����
	    PreparedStatement pre = null;	// ����Ԥ����������һ�㶼�������������Statement
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
	        String sql ="select * from Ա����Ϣ�� where Ա�����="+sidcolumn_text.getText()+" ";// Ԥ������䣬�������������
	        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
	        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ�
	        stuff_data.clear();
	        while (result.next())
	        {
	        	stuff_data.add(new Stuff(result.getString("Ա�����"),result.getString("����"),result.getString("�Ա�"),result.getString("��������"),result.getString("����"),result.getString("ѧ��"),result.getString("��ϵ�绰"),result.getString("��λ"),result.getString("���֤")));
	        	
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
		Connection con = null;		// ����һ�����ݿ�����
	    PreparedStatement pre = null;	// ����Ԥ����������һ�㶼�������������Statement
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
	        String sql ="select * from Ա����Ϣ�� where ����='"+sname_text.getText()+ "'";// Ԥ������䣬�������������
	        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
	        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ�
	        stuff_data.clear();
	        while (result.next())
	        {
	        	stuff_data.add(new Stuff(result.getString("Ա�����"),result.getString("����"),result.getString("�Ա�"),result.getString("��������"),result.getString("����"),result.getString("ѧ��"),result.getString("��ϵ�绰"),result.getString("��λ"),result.getString("���֤")));
	        	
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
		Connection con = null;		// ����һ�����ݿ�����
	    PreparedStatement pre = null;	// ����Ԥ����������һ�㶼�������������Statement
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
	        String sql ="select * from Ա����Ϣ�� where ���֤="+scard_text.getText()+ "";// Ԥ������䣬�������������
	        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
	        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ�
	        stuff_data.clear();
	        while (result.next())
	        {
	        	stuff_data.add(new Stuff(result.getString("Ա�����"),result.getString("����"),result.getString("�Ա�"),result.getString("��������"),result.getString("����"),result.getString("ѧ��"),result.getString("��ϵ�绰"),result.getString("��λ"),result.getString("���֤")));
	        	
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
		Connection con = null;		// ����һ�����ݿ�����
	    PreparedStatement pre = null;	// ����Ԥ����������һ�㶼�������������Statement
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
	        String sql ="select * from Ա����Ϣ�� ";// Ԥ������䣬�������������
	        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
	        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ�
	        stuff_data.clear();
	        while (result.next())
	        {
	        	stuff_data.add(new Stuff(result.getString("Ա�����"),result.getString("����"),result.getString("�Ա�"),result.getString("��������"),result.getString("����"),result.getString("ѧ��"),result.getString("��ϵ�绰"),result.getString("��λ"),result.getString("���֤")));
	        	
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
		        String sql = "select * from �γ����۱� where �������="+oid_text.getText()+"";// Ԥ������䣬�������������
		        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		        //pre.setString(1, "0002");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
		        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		        car_orders_data.clear();
		        while (result.next())
		        {
		        
		            // ���������Ϊ��ʱ
		           //System.out.println("Ա�����" + result.getString("���֤"));
		                    //+ result.getString("����"));
		        	car_orders_data.add(new Orders(result.getString("�������"),result.getString("��������"),result.getString("�ͻ����"),result.getString("�γ��ͺ�"),result.getString("��ɫ"),result.getString("����"),result.getString("ʵ���ۼ�"),result.getString("�����˱��"),result.getString("��������"),result.getString("��ע")));
		        	
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
	public void selectcid() throws Exception{
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
		        String sql = "select * from �γ����۱� where �ͻ����="+cid_text.getText()+"";// Ԥ������䣬�������������
		        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		        //pre.setString(1, "0002");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
		        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		        car_orders_data.clear();
		        while (result.next())
		        {
		        
		        	car_orders_data.add(new Orders(result.getString("�������"),result.getString("��������"),result.getString("�ͻ����"),result.getString("�γ��ͺ�"),result.getString("��ɫ"),result.getString("����"),result.getString("ʵ���ۼ�"),result.getString("�����˱��"),result.getString("��������"),result.getString("��ע")));
		        	
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
	public void selectsid() throws Exception{
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
		        String sql = "select * from �γ����۱� where �����˱��="+sid_text.getText()+"";// Ԥ������䣬�������������
		        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		        //pre.setString(1, "0002");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
		        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		        car_orders_data.clear();
		        while (result.next())
		        {
		        
		        	car_orders_data.add(new Orders(result.getString("�������"),result.getString("��������"),result.getString("�ͻ����"),result.getString("�γ��ͺ�"),result.getString("��ɫ"),result.getString("����"),result.getString("ʵ���ۼ�"),result.getString("�����˱��"),result.getString("��������"),result.getString("��ע")));
		        	
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
	public void select_carsale_all() throws Exception{
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
		        car_orders_data.clear();
		        while (result.next())
		        {
		        
		            // ���������Ϊ��ʱ
		           //System.out.println("Ա�����" + result.getString("���֤"));
		                    //+ result.getString("����"));
		        	car_orders_data.add(new Orders(result.getString("�������"),result.getString("��������"),result.getString("�ͻ����"),result.getString("�γ��ͺ�"),result.getString("��ɫ"),result.getString("����"),result.getString("ʵ���ۼ�"),result.getString("�����˱��"),result.getString("��������"),result.getString("��ע")));
		        	
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
	public void selectcidcolumn() throws Exception{
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
		        String sql = "select * from �ͻ���Ϣ�� where �ͻ����="+cidcolumn_text.getText()+"";// Ԥ������䣬�������������
		        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		        //pre.setString(1, "0002");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
		        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		        customer_data.clear();
		        while (result.next())
		        {

		        	customer_data.add(new Customer(result.getString("�ͻ����"),result.getString("�ͻ�����"),result.getString("�ͻ��ȼ�"),result.getString("��ϵ�绰"),result.getString("��ַ"),result.getString("�Ż���Ŀ")));
		        	
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
	public void selectcname() throws Exception{
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
		        String sql = "select * from �ͻ���Ϣ�� where �ͻ�����='"+cname_text.getText()+"'";// Ԥ������䣬�������������
		        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		        //pre.setString(1, "0002");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
		        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		        customer_data.clear();
		        while (result.next())
		        {

		        	customer_data.add(new Customer(result.getString("�ͻ����"),result.getString("�ͻ�����"),result.getString("�ͻ��ȼ�"),result.getString("��ϵ�绰"),result.getString("��ַ"),result.getString("�Ż���Ŀ")));
		        	
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
	public void selectcnumber() throws Exception{
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
		        String sql = "select * from �ͻ���Ϣ�� where ��ϵ�绰="+cnumber_text.getText()+"";// Ԥ������䣬�������������
		        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		        //pre.setString(1, "0002");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
		        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		        customer_data.clear();
		        while (result.next())
		        {

		        	customer_data.add(new Customer(result.getString("�ͻ����"),result.getString("�ͻ�����"),result.getString("�ͻ��ȼ�"),result.getString("��ϵ�绰"),result.getString("��ַ"),result.getString("�Ż���Ŀ")));
		        	
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
	public void select_customer_all() throws Exception{
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
		        String sql = "select * from �ͻ���Ϣ��";// Ԥ������䣬�������������
		        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		        //pre.setString(1, "0002");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
		        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		        customer_data.clear();
		        while (result.next())
		        {
		        
		            // ���������Ϊ��ʱ
		           //System.out.println("Ա�����" + result.getString("���֤"));
		                    //+ result.getString("����"));
		        	customer_data.add(new Customer(result.getString("�ͻ����"),result.getString("�ͻ�����"),result.getString("�ͻ��ȼ�"),result.getString("��ϵ�绰"),result.getString("��ַ"),result.getString("�Ż���Ŀ")));
		        	
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
	public void selectcar_id() throws Exception{
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
		        String sql = "select * from �γ���Ϣ���� where �γ����="+car_id_text.getText()+"";// Ԥ������䣬�������������
		        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		        car_remark_data.clear();
		        while (result.next())
		        {
		        	car_remark_data.add(new Car(result.getString("�γ����"),result.getString("�γ��ͺ�"),result.getString("�γ�����"),result.getString("��ɫ"),result.getString("�����"),result.getString("��������"),result.getString("�����۸�"),result.getString("��ע")));
		        	
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
	public void selectcarmodel() throws Exception{
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
		        String sql = "select * from �γ���Ϣ���� where �γ��ͺ�='"+carmodel_text.getText()+"'";// Ԥ������䣬�������������
		        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
		        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
		        car_remark_data.clear();
		        while (result.next())
		        {
		        	car_remark_data.add(new Car(result.getString("�γ����"),result.getString("�γ��ͺ�"),result.getString("�γ�����"),result.getString("��ɫ"),result.getString("�����"),result.getString("��������"),result.getString("�����۸�"),result.getString("��ע")));
		        	
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
	public void select_remark_all() throws Exception{
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
		        car_remark_data.clear();
		        while (result.next())
		        {
		        	car_remark_data.add(new Car(result.getString("�γ����"),result.getString("�γ��ͺ�"),result.getString("�γ�����"),result.getString("��ɫ"),result.getString("�����"),result.getString("��������"),result.getString("�����۸�"),result.getString("��ע")));
		        	
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


