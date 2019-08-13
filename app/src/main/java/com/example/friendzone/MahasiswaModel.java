package com.example.friendzone;
//tanggal 12/08/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MahasiswaModel extends RealmObject {

    @PrimaryKey
    private Integer id;
    private Integer nim;
    private String nama,kelas,telpon,email,sosmed;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public Integer getNim() {
        return nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKelas() {
        return kelas;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSosmed(String sosmed) {
        this.sosmed = sosmed;
    }

    public String getSosmed() {
        return sosmed;
    }
}
