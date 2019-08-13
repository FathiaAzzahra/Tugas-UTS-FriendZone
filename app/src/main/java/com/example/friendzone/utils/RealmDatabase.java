//tanggal 12/08/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

package com.example.friendzone.utils;

public interface RealmDatabase {
    public Integer realmGet$id();
    public void realmSet$id(Integer value);

    public Integer realmGet$nim();
    public void realmSet$nim(Integer value);

    public String realmGet$nama();
    public void realmSet$nama(String value);

    public String realmGet$kelas();
    public void realmSet$kelas(String value);

    public String realmGet$tlp();
    public void realmSet$tlp(String value);

    public String realmGet$email();
    public void realmSet$email(String value);

    public String realmGet$sosmed();
    public void realmSet$sosmed(String value);
}
