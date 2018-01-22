package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Orders {      //销售表的类
    private  StringProperty oid;
    private  StringProperty oday;
    private  StringProperty cid;
    private  StringProperty cmodel;
    private  StringProperty color;
    private  StringProperty number;
    private  StringProperty price;
    private  StringProperty sid;
    private  StringProperty carid;
    private  StringProperty ps;
 
 Orders(String oid, String oday,String cid,String cmodel,String color,String number,String price,String sid,String carid,String ps) {
        this.oid = new SimpleStringProperty(oid);
        this.oday = new SimpleStringProperty(oday);
        this.cid = new SimpleStringProperty(cid);
        this.cmodel = new SimpleStringProperty(cmodel);
        this.color = new SimpleStringProperty(color);
        this.number = new SimpleStringProperty(number);
        this.price = new SimpleStringProperty(price);
        this.sid = new SimpleStringProperty(sid);
        this.carid = new SimpleStringProperty(carid);
        this.ps = new SimpleStringProperty(ps);
}
    public String getoid() {
        return oid.get();
    }
    public void setoid(String oid) {
    	this.oid.set(oid);
    }
    public StringProperty oidProperty() {
        return oid;
    }
   
    public String getoday() {
        return oday.get();
    }
    public void setoday(String oday) {
    	this.oday.set(oday);
    }
    public StringProperty odayProperty() {
        return oday;
    }
    
    public String getcid() {
        return cid.get();
    }
    public void setcid(String cid) {
    	this.cid.set(cid);
    }
    public StringProperty cidProperty() {
        return cid;
    }
        
    public String getcmodel() {
        return cmodel.get();
    }
    public void setcmodel(String cmodel) {
    	this.cmodel.set(cmodel);
    }
    
    public StringProperty cmodelProperty() {
        return cmodel;
    }
    
    public String getcolor() {
        return color.get();
    }
    public void setcolor(String color) {
    	this.color.set(color);
    }
    public StringProperty colorProperty() {
        return color;
    }
    public String getnumber() {
        return number.get();
    }
    public void setnumber(String number) {
    	this.number.set(number);
    }
    public StringProperty numberProperty() {
        return number;
    }
    
    public String getprice() {
        return price.get();
    }
    public void setprice(String price) {
    	this.price.set(price);
    }
    public StringProperty priceProperty() {
        return price;
    }
    public String getsid() {
        return sid.get();
    }
    public void setsid(String sid) {
    	this.sid.set(sid);
    }
    public StringProperty sidProperty() {
        return sid;
    }
    public String getcarid() {
        return carid.get();
    }
    public void setcarid(String carid) {
    	this.carid.set(carid);
    }
    public StringProperty caridProperty() {
        return carid;
    }
    public String getps() {
        return ps.get();
    }
    public void setps(String ps) {
    	this.ps.set(ps);
    }
    public StringProperty psProperty() {
        return ps;
    }

}

    
    
    
    
    
    
    
    
   