/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transaksi.Dao;

import com.transaksi.Entity.Barang;
import com.transaksi.Interface.BarangInterface;
import com.transaksi.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krypton
 */
public class BarangDao implements BarangInterface{
    
    private Connection connection;
    public BarangDao(){
        connection=DBConnection.getConnection();
    }

    @Override
    public boolean insertBarang(Barang barang) {
        PreparedStatement statement=null;
        boolean valid=false;
        String sql = "insert into barang (kd_barang, nama, jumlah, harga) values (?, ?, ?, ?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, barang.getKodeBarang());
            statement.setString(2, barang.getNama());
            statement.setInt(3, barang.getJumlah());
            statement.setDouble(4, barang.getHarga());
            valid=true;
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean updateBarang(Barang barang) {
      PreparedStatement statement=null;
      boolean valid=false;
      String sql="update barang set nama=?, jumlah=?, harga=? where kd_barang=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, barang.getNama());
            statement.setInt(2, barang.getJumlah());
            statement.setDouble(3, barang.getHarga());
            statement.setString(4, barang.getKodeBarang());
            valid=true;
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean deleteBarang(Barang barang) {
     PreparedStatement statement=null;
     boolean valid=false;
     String sql = "delete from barang where kd_barang=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, barang.getKodeBarang());
            valid=true;
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public Barang getByid(String id) {
     PreparedStatement statement=null;
        ResultSet rs=null;
        Barang b=null;
        String sql="select * from barang where kd_barang=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, id);
            rs=statement.executeQuery();
            while(rs.next()){
                b=new Barang();
                b.setKodeBarang(rs.getString("kd_barang"));
                b.setNama(rs.getString("nama"));
                b.setJumlah(rs.getInt("jumlah"));
                b.setHarga(rs.getDouble("harga"));
            }
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Barang> getBarang() {
     PreparedStatement statement=null;
     ResultSet rs=null;
     List list=new ArrayList();
     String sql="select * from barang";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Barang b=new Barang();
                b.setKodeBarang(rs.getString("kd_barang"));
                b.setNama(rs.getString("nama"));
                b.setJumlah(rs.getInt("jumlah"));
                b.setHarga(rs.getDouble("harga"));
                list.add(b);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String AutoNumber() {
     PreparedStatement statement=null;
     ResultSet rs=null;
     String s, s1;
     String kode=null;
     Integer panjang = 5;
     Integer j;
     String sql = "select max(right(kd_barang, 5)) from barang";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode = "B/00001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                j=s.length();
                s1="";
                for(int i=0; i<=panjang-j; i++){
                    s1=s1+"0";
                }
                kode="B/"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void kurangJumlahStokBarang(int jumlah, Barang barang) {
     PreparedStatement statement=null;
     String sql = "update barang set jumlah=jumlah-? where kd_barang=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1, jumlah);
            statement.setString(2, barang.getKodeBarang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
