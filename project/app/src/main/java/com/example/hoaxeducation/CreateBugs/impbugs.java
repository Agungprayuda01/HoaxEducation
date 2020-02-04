package com.example.hoaxeducation.CreateBugs;

import java.io.Serializable;

public class impbugs implements Serializable {
    private String email;
    private String masaalah;
    private String key;
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMasaalah() {
        return masaalah;
    }

    public void setMasaalah(String masaalah) {
        this.masaalah = masaalah;
    }

    @Override
    public String toString() {
        return " "+email +"\n" +
                " "+uid +"\n" +
                " "+masaalah;
    }
    public impbugs(String nm, String em, String ms){
        uid = nm;
        email = em;
        masaalah = ms;
    }
}