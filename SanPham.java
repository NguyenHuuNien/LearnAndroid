package com.hyunie.sanpham;

import androidx.annotation.NonNull;

public class SanPham {
    private String name;
    private int gia;
    private int anh;

    public SanPham(String name, int gia, int anh) {
        this.name = name;
        this.gia = gia;
        this.anh = anh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public SanPham() {
    }
}
