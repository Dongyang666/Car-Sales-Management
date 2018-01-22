package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Stuff {
    private  StringProperty sidcolumn;
    private  StringProperty snamecolumn;
    private  StringProperty ssexcolumn;
    private  StringProperty sbrithcolumn;
    private  StringProperty saddresscolumn;
    private  StringProperty stucolumn;
    private  StringProperty snumbercolumn;
    private  StringProperty sstationcolumn;
    private  StringProperty scardcolumn;
 
 Stuff(String sidcolumn, String snamecolumn,String ssexcolumn,String sbrithcolumn,String saddresscolumn,String stucolumn,String snumbercolumn,String sstationcolumn,String scardcolumn) {
        this.sidcolumn = new SimpleStringProperty(sidcolumn);
        this.snamecolumn = new SimpleStringProperty(snamecolumn);
        this.ssexcolumn = new SimpleStringProperty(ssexcolumn);
        this.sbrithcolumn = new SimpleStringProperty(sbrithcolumn);
        this.saddresscolumn= new SimpleStringProperty(saddresscolumn);
        this.stucolumn = new SimpleStringProperty(stucolumn);
        this.snumbercolumn = new SimpleStringProperty(snumbercolumn);
        this.sstationcolumn = new SimpleStringProperty(sstationcolumn);
        this.scardcolumn = new SimpleStringProperty(scardcolumn);
}
    public String getsidcolumn() {
        return sidcolumn.get();
    }
    public void setsidcolumn(String sidcolumn) {
    	this.sidcolumn.set(sidcolumn);
    }
    public StringProperty sidcolumnProperty() {
        return sidcolumn;
    }
   
    public String getsnamecolumn() {
        return snamecolumn.get();
    }
    public void setsnamecolumn(String snamecolumn) {
    	this.snamecolumn.set(snamecolumn);
    }
    public StringProperty snamecolumnProperty() {
        return snamecolumn;
    }
    
    public String getssexcolumn() {
        return ssexcolumn.get();
    }
    public void setssexcolumn(String ssexcolumn) {
    	this.ssexcolumn.set(ssexcolumn);
    }
    public StringProperty ssexcolumnProperty() {
        return ssexcolumn;
    }
        
    public String getsbrithcolumn() {
        return sbrithcolumn.get();
    }
    public void setsbrithcolumn(String sbrithcolumn) {
    	this.sbrithcolumn.set(sbrithcolumn);
    }
    public StringProperty sbrithcolumnProperty() {
        return sbrithcolumn;
    }
    
    public String getsaddresscolumn() {
        return saddresscolumn.get();
    }
    public void setsaddresscolumn(String saddresscolumn) {
    	this.saddresscolumn.set(saddresscolumn);
    }
    public StringProperty saddresscolumnProperty() {
        return saddresscolumn;
    }
    public String getstucolumn() {
        return stucolumn.get();
    }
    public void setstucolumn(String stucolumn) {
    	this.stucolumn.set(stucolumn);
    }
    public StringProperty stucolumnProperty() {
        return stucolumn;
    }
    
    public String getsnumbercolumn() {
        return snumbercolumn.get();
    }
    public void setsnumbercolumn(String snumbercolumn) {
    	this.snumbercolumn.set(snumbercolumn);
    }
    public StringProperty snumbercolumnProperty() {
        return snumbercolumn;
    }
    public String getsstationcolumn() {
        return sstationcolumn.get();
    }
    public void setsstationcolumn(String sstationcolumn) {
    	this.sstationcolumn.set(sstationcolumn);
    }
    public StringProperty sstationcolumnProperty() {
        return sstationcolumn;
    }
    public String getscardcolumn() {
        return scardcolumn.get();
    }
    public void setscardcolumn(String scardcolumn) {
    	this.scardcolumn.set(scardcolumn);
    }
    public StringProperty scardcolumnProperty() {
        return scardcolumn;
    }
    
}

    
    
    
    
    
    
    
    
   