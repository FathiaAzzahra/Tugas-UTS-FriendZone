package com.example.friendzone.utils;
//tanggal 12/08/2019
//NIM : 10116014
//NAMA : Fathia Azzahra
//Kelas : IF 1

import java.util.List;

public interface Database {
    public List<Object> select(String queryString);
    public int insert(String tableName, Object content);
    boolean update(String tableName, Object content);
    boolean delete(String tableName, int id);
    boolean execute(String queryString);
}
