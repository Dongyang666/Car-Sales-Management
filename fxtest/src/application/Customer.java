package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private  StringProperty cidcolumn;
    private  StringProperty cnamecolumn;
    private  StringProperty clevealcolumn;
    private  StringProperty cnumbercolumn;
    private  StringProperty caddresscolumn;
    private  StringProperty citemcolumn;
 Customer(String cidcolumn, String cnamecolumn,String clevealcolumn,String cnumbercolumn,String caddresscolumn,String citemcolumn) {
        this.cidcolumn = new SimpleStringProperty(cidcolumn);
        this.cnamecolumn = new SimpleStringProperty(cnamecolumn);
        this.clevealcolumn = new SimpleStringProperty(clevealcolumn);
        this.cnumbercolumn = new SimpleStringProperty(cnumbercolumn);
        this.caddresscolumn= new SimpleStringProperty(caddresscolumn);
        this.citemcolumn = new SimpleStringProperty(citemcolumn);
}
    public String getcidcolumn() {
        return cidcolumn.get();
    }
    public void setcidcolumn(String cidcolumn) {
    	this.cidcolumn.set(cidcolumn);
    }
    public StringProperty cidcolumnProperty() {
        return cidcolumn;
    }
   
    public String getcnamecolumn() {
        return cnamecolumn.get();
    }
    public void setcnamecolumn(String cnamecolumn) {
    	this.cnamecolumn.set(cnamecolumn);
    }
    public StringProperty cnamecolumnProperty() {
        return cnamecolumn;
    }
    
    public String getclevealcolumn() {
        return clevealcolumn.get();
    }
    public void setclevealcolumn(String clevealcolumn) {
    	this.clevealcolumn.set(clevealcolumn);
    }
    public StringProperty clevealcolumnProperty() {
        return clevealcolumn;
    }
        
    public String getcnumbercolumn() {
        return cnumbercolumn.get();
    }
    public void setcnumbercolumn(String cnumbercolumn) {
    	this.cnumbercolumn.set(cnumbercolumn);
    }
    public StringProperty cnumbercolumnProperty() {
        return cnumbercolumn;
    }
    
    public String getcaddresscolumn() {
        return caddresscolumn.get();
    }
    public void setcaddresscolumn(String caddresscolumn) {
    	this.caddresscolumn.set(caddresscolumn);
    }
    public StringProperty caddresscolumnProperty() {
        return caddresscolumn;
    }
    
    public String getcitemcolumn() {
        return citemcolumn.get();
    }
    public void setcitemcolumn(String citemcolumn) {
    	this.citemcolumn.set(citemcolumn);
    }
    public StringProperty citemcolumnProperty() {
        return citemcolumn;
    }
    
  
}

    
    
    
    
    
    
    
    
   