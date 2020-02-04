package com.example.hoaxeducation.CreateLaporan;

import java.io.Serializable;

public class impBugs implements Serializable {
    private String Namaanda;
    private String email;
    private String fitur;
    private String masaalah;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNamaberita() {
        return Namaanda;
    }

    public void setNamaberita(String namaberita) {
        this.Namaanda = Namaanda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return fitur;
    }

    public void setUrl(String url) {
        this.fitur = fitur;
    }

    public String getMasaalah() {
        return masaalah;
    }

    public void setMasaalah(String masaalah) {
        this.masaalah = masaalah;
    }

    @Override
    public String toString() {
        return " "+Namaanda+"\n" +
                " "+email +"\n" +
                " "+fitur +"\n" +
                " "+masaalah;
    }
    public impBugs(String nm, String em, String ur, String ms){
        Namaanda = nm;
        email = em;
        fitur = ur;
        masaalah = ms;
    }
}
