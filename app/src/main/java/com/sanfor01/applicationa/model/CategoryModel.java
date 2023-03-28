package com.sanfor01.applicationa.model;

public class CategoryModel {

    private int id;
    private String name;
    private String image;
    private boolean locked;

    public CategoryModel() {

    }


//    =======================   get   ========================
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public boolean isLocked() {
        return locked;
    }

//   ----------------------------------------------------------

//    =======================   set   =========================

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    //   ----------------------------------------------------------

}
