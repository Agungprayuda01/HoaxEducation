package com.example.hoaxeducation.CreateBantuan;

import java.io.Serializable;
import com.google.firebase.database.IgnoreExtraProperties;

public class impBantuan implements Serializable {
    private String namaberita;
    private String email;
    private String url;
    private String profilimage;

    public String getProfilimage() {
        return profilimage;
    }

    public void setProfilimage(String profilimage) {
        this.profilimage = profilimage;
    }

    private String masaalah;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNamaberita() {
        return namaberita;
    }

    public void setNamaberita(String namaberita) {
        this.namaberita = namaberita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMasaalah() {
        return masaalah;
    }

    public void setMasaalah(String masaalah) {
        this.masaalah = masaalah;
    }

    @Override
    public String toString() {
        return " "+namaberita+"\n" +
                " "+email +"\n" +
                " "+url +"\n" +
                " "+masaalah + "\n"+
                " "+profilimage;
    }
    public impBantuan(String nm, String em, String ur,String ms, String pm){
        namaberita = nm;
        email = em;
        url = ur;
        masaalah = ms;
        profilimage = pm;
    }
}
