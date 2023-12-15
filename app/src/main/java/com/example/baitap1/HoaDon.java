package com.example.baitap1;

public class HoaDon {
    private int id;
    private String name;
    private int sophong;
    private float dongia;
    private int ngay;

    public HoaDon() {

    }
    public HoaDon(int id, String name, int sophong, float dongia, int ngay ) {
        this.id = id;
        this.name = name;
        this.sophong= sophong;
        this.dongia = dongia;
        this.ngay= ngay;
    };

    public HoaDon( String name, int sophong, float dongia, int ngay ) {
        this.name = name;
        this.sophong= sophong;
        this.dongia = dongia;
        this.ngay= ngay;
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDongia() {
        return dongia;
    }

    public int getNgay() {
        return ngay;
    }

    public int getSophong() {
        return sophong;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public void setSophong(int sophong) {
        this.sophong = sophong;
    }

}
