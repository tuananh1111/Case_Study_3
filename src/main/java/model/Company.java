package model;

import java.io.Serializable;

public class Company implements Serializable {
        private String comId;
        private String comName;
        private String comAddress;

    public Company() {
    }

    public Company(String comName, String comAddress) {
        this.comName = comName;
        this.comAddress = comAddress;
    }

    public Company(String comId, String comName, String comAddress) {
        this.comId = comId;
        this.comName = comName;
        this.comAddress = comAddress;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }
}

