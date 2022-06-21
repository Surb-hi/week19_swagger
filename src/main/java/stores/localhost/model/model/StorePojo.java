package stores.localhost.model.model;

import java.util.HashMap;

public class StorePojo {
    private String name;
    private String type;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Object lat;
    private Object lng;
    private String hours;
    private HashMap<Object,Object> services;


    public Object getLng() {
        return lng;
    }

    public void setLng(Object lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }



    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public HashMap<Object, Object> getServices() {
        return services;
    }

    public void setServices(HashMap<Object, Object> services) {
        this.services = services;
    }
}