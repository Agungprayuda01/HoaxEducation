package com.example.hoaxeducation.LihatBantuan;

public class DataSetFire {
    String namaberita;
    String masaalah;
    String url;
    String profilimage;
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilimage() {
        return profilimage;
    }

    public void setProfilimage(String profilimage) {
        this.profilimage = profilimage;
    }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getNamaberita() {
        return namaberita;
    }

    public void setNamaberita(String namaberita) {
        this.namaberita = namaberita;
    }

    public String getMasaalah() {
        return masaalah;
    }

    public void setMasalah(String masaalah) {
        this.masaalah = masaalah;
    }

    public DataSetFire() {
    }

    public DataSetFire(String namaberita, String masaalah, String url, String profilimage, String email) {
        this.namaberita = namaberita;
        this.masaalah = masaalah;
        this.url = url;
        this.profilimage = profilimage;
        this.email = email;
    }
}
