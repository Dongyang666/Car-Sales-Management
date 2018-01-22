package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Car {
    private  StringProperty car_id;
    private  StringProperty carmodel;
    private  StringProperty carname;
    private  StringProperty carcolor;
    private  StringProperty ckucun;
    private  StringProperty cproduct;
    private  StringProperty cprice;
    private  StringProperty cps;
 
 Car(String car_id, String carmodel,String carname,String carcolor,String ckucun,String cproduct,String cprice,String cps) {
        this.car_id = new SimpleStringProperty(car_id);
        this.carmodel = new SimpleStringProperty(carmodel);
        this.carname = new SimpleStringProperty(carname);
        this.carcolor = new SimpleStringProperty(carcolor);
        this.ckucun = new SimpleStringProperty(ckucun);
        this.cproduct = new SimpleStringProperty(cproduct);
        this.cprice = new SimpleStringProperty(cprice);
        this.cps = new SimpleStringProperty(cps);
}
    public String getcar_id() {
        return car_id.get();
    }
    public void setcar_id(String car_id) {
    	this.car_id.set(car_id);
    }
    public StringProperty car_idProperty() {
        return car_id;
    }
   
    public String getcarmodel() {
        return carmodel.get();
    }
    public void setcarmodel(String carmodel) {
    	this.carmodel.set(carmodel);
    }
    public StringProperty carmodelProperty() {
        return carmodel;
    }
    
    public String getcarname() {
        return carname.get();
    }
    public void setcarname(String carname) {
    	this.carname.set(carname);
    }
    public StringProperty carnameProperty() {
        return carname;
    }
        
    public String getcarcolor() {
        return carcolor.get();
    }
    public void setcarcolor(String carcolor) {
    	this.carcolor.set(carcolor);
    }
    
    public StringProperty carcolorProperty() {
        return carcolor;
    }
    
    public String getckucun() {
        return ckucun.get();
    }
    public void setckucun(String ckucun) {
    	this.ckucun.set(ckucun);
    }
    public StringProperty ckucunProperty() {
        return ckucun;
    }
    public String getcproduct() {
        return cproduct.get();
    }
    public void setcproduct(String cproduct) {
    	this.cproduct.set(cproduct);
    }
    public StringProperty cproductProperty() {
        return cproduct;
    }
    
    public String getcprice() {
        return cprice.get();
    }
    public void setcprice(String cprice) {
    	this.cprice.set(cprice);
    }
    public StringProperty cpriceProperty() {
        return cprice;
    }
    public String getcps() {
        return cps.get();
    }
    public void setcps(String cps) {
    	this.cps.set(cps);
    }
    public StringProperty cpsProperty() {
        return cps;
    }

}

    
    
    
    
    
    
    
    
   