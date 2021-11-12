package com.example.ghichu_java2;

public class danhmuc {
    private String iddanhmuc;
    private String tenloai;
    private String thoigiantao;

    public danhmuc(String iddanhmuc, String tenloai, String thoigiantao){

        this.iddanhmuc = iddanhmuc;
        this.tenloai = tenloai;
        this.thoigiantao = thoigiantao;
    }

    public String getIddanhmuc() { return iddanhmuc; }

    public String getTenloai() {
        return tenloai;
    }

    public String getThoigiantao() { return thoigiantao; }

    public void setIddanhmuc(String iddanhmuc) {
        this.iddanhmuc = iddanhmuc;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public void setThoigiantao(String thoigiantao) {
        this.thoigiantao = thoigiantao;
    }
}
