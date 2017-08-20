/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.beans;


/**
 *
 * @author vikramsingh
 */
public class Configuration {
    
    private int id;
    private String key;
    private String value;
    private String duplicate_allowed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDuplicate_allowed() {
        return duplicate_allowed;
    }

    public void setDuplicate_allowed(String duplicate_allowed) {
        this.duplicate_allowed = duplicate_allowed;
    }
    
    
    
}
