/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transaksi.Dao;

import com.transaksi.Entity.Transaksi;
import com.transaksi.Entity.TransaksiDetil;
import com.transaksi.Interface.TransaksiInterface;
import com.transaksi.db.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author krypton
 */
public class TransaksiDao implements TransaksiInterface{
    
    private Connection connection;
    private BarangDao barangDao;
    public TransaksiDao(){
        connection=DBConnection.getConnection();
        barangDao=new BarangDao();
    }

    @Override
    public boolean insertTransaksi(Transaksi transaksi) {
       PreparedStatement statement=null;
       boolean valid=false;
       String sql = "insert into transaksi (kd_transaksi, tanggal, karyawan, total) values (?, ?, ?, ?)";
        try {
            statement=connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            statement.setString(1, transaksi.getKodeTransaksi());
            statement.setDate(2, new Date(transaksi.getTanggal().getTime()));
            statement.setString(3, transaksi.getKaryawan());
            statement.setDouble(4, transaksi.getTotal());
            statement.executeUpdate();
            
            //proses insert transaksi 
            String SQL_INSERT_TRANSAKSI = "INSERT INTO transaksi_detil (kd_transaksi, kd_barang, jumlah, harga) "
                    + "values (?, ?, ?, ?)";
            List<TransaksiDetil>detilsTransaksi=transaksi.getGetTransaksiDetil();
            
            int validJumlah=0;
            for(TransaksiDetil transaksiDetil : detilsTransaksi){
                statement=connection.prepareStatement(SQL_INSERT_TRANSAKSI);
                statement.setString(1, transaksiDetil.getTransaksi().getKodeTransaksi());
                statement.setString(2, transaksiDetil.getBarang().getKodeBarang());
                statement.setInt(3, transaksiDetil.getJumlah());
                statement.setDouble(4, transaksiDetil.getHarga());
                statement.executeUpdate();
                
                
                barangDao=new BarangDao();
                if(transaksiDetil.getBarang().getJumlah() < transaksiDetil.getJumlah()){
                    JOptionPane.showMessageDialog(null, "maaf jumlah stok barang tidak mencukupi !");
                    validJumlah=transaksiDetil.getBarang().getJumlah() - transaksiDetil.getJumlah();
                    valid=false;
                }else{
                    barangDao.kurangJumlahStokBarang(transaksiDetil.getJumlah(), transaksiDetil.getBarang());
                }
            }
            if(validJumlah<0){
                connection.rollback();
                connection.setAutoCommit(true);
            }else{
                connection.commit();
                connection.setAutoCommit(true);
                valid=true;
            }
            
        } catch (SQLException ex) {
           try {
               connection.commit();
               connection.setAutoCommit(true);
               Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex1) {
               Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex1);
           }
        }
        return valid;
    }

    @Override
    public String kodeTransaksi() {
     PreparedStatement statement=null;
        ResultSet rs=null;
        String kode=null;
        String s, s1;
        Integer panjang = 5;
        Integer j;
        String sql = "select max(right(kd_transaksi, 5)) from transaksi";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="T/00001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                j=s.length();
                s1="";
                for(int i=0; i<=panjang-j; i++){
                    s1=s1+"0";
                }
                kode="T/"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
