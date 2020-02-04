package com.example.hoaxeducation.lihatberita;

public class DataSetFire {
    String pname, description, price, image, category, pid, date, time,profilimage,profilname,profilemail;

    public DataSetFire() {
    }

    public String getProfilemail() {
        return profilemail;
    }

    public void setProfilemail(String profilemail) {
        this.profilemail = profilemail;
    }

    public String getProfilimage() {
        return profilimage;
    }

    public void setProfilimage(String profilimage) {
        this.profilimage = profilimage;
    }

    public String getProfilname() {
        return profilname;
    }

    public void setProfilname(String profilname) {
        this.profilname = profilname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DataSetFire(String pname,String description,String price,String image,String category,String pid,String date,String time,
                       String profilimage,String profilname, String profilemail) {
        this.pname = pname;
        this.category = category;
        this.image = image;
        this.description = description;
        this.date = date;
        this.pid = pid;
        this.price = price;
        this.time = time;
        this.profilimage = profilimage;
        this.profilname = profilname;
        this.profilemail = profilemail;
    }
}
