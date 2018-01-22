package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Service {
    private  StringProperty service_id;
    private  StringProperty service_day;
    private  StringProperty service_cid;
    private  StringProperty service_carid;
    private  StringProperty service_sid;
    private  StringProperty service_record;
    
 Service(String service_id, String service_day,String service_cid,String service_carid,String service_sid,String service_record) {
        this.service_id = new SimpleStringProperty(service_id);
        this.service_day = new SimpleStringProperty(service_day);
        this.service_cid = new SimpleStringProperty(service_cid);
        this.service_carid = new SimpleStringProperty(service_carid);
        this.service_sid = new SimpleStringProperty(service_sid);
        this.service_record = new SimpleStringProperty(service_record);
}
    public String getservice_id() {
        return service_id.get();
    }
    public void setservice_id(String service_id) {
    	this.service_id.set(service_id);
    }
    public StringProperty service_idProperty() {
        return service_id;
    }
   
    public String getservice_day() {
        return service_day.get();
    }
    public void setservice_day(String service_day) {
    	this.service_day.set(service_day);
    }
    public StringProperty service_dayProperty() {
        return service_day;
    }
    
    public String getservice_cid() {
        return service_cid.get();
    }
    public void setservice_cid(String service_cid) {
    	this.service_cid.set(service_cid);
    }
    public StringProperty service_cidProperty() {
        return service_cid;
    }
        
    public String getservice_carid() {
        return service_carid.get();
    }
    public void setservice_carid(String service_carid) {
    	this.service_carid.set(service_carid);
    }
    
    public StringProperty service_caridProperty() {
        return service_carid;
    }
    
    public String getservice_sid() {
        return service_sid.get();
    }
    public void setckucun(String service_sid) {
    	this.service_sid.set(service_sid);
    }
    public StringProperty service_sidProperty() {
        return service_sid;
    }
    public String getservice_record() {
        return service_record.get();
    }
    public void setservice_record(String service_record) {
    	this.service_record.set(service_record);
    }
    public StringProperty service_recordProperty() {
        return service_record;
    }
    
   
}

    
    
    
    
    
    
    
    
   