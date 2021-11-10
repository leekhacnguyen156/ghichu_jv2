package com.example.ghichu_java2;

public class ghichu {
    private String id;
    private String tieude;
    private String noidung;
    private String hinhanh;
    private String thoigiantao;

    public ghichu() {
    }

    public ghichu(String id, String tieude, String noidung, String hinhanh, String thoigiantao) {
        this.id = id;
        this.tieude = tieude;
        this.noidung = noidung;
        this.hinhanh = hinhanh;
        this.thoigiantao = thoigiantao;
    }

    public String getId() {
        return id;
    }

    public String getTieude() {
        return tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public String getThoigiantao() {
        return thoigiantao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public void setThoigiantao(String thoigiantao) {
        this.thoigiantao = thoigiantao;
    }
}
