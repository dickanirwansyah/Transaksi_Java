/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transaksi.Entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author krypton
 */
public class Transaksi {
    private String kodeTransaksi;
    private Date tanggal;
    private String karyawan;
    private double total;
    List<TransaksiDetil> getTransaksiDetil;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    public String getKodeTransaksi(){
        return kodeTransaksi;
    }
    
    public void setKodeTransaksi(String kodeTransaksi){
        this.kodeTransaksi=kodeTransaksi;
    }
    
    public Date getTanggal(){
        return tanggal;
    }
    
    public void setTanggal(Date tanggal){
        this.tanggal=tanggal;
    }
    
    public String getKaryawan(){
        return karyawan;
    }
    
    public void setKaryawan(String karyawan){
        this.karyawan=karyawan;
    }

    public List<TransaksiDetil> getGetTransaksiDetil() {
        return getTransaksiDetil;
    }

    public void setGetTransaksiDetil(List<TransaksiDetil> getTransaksiDetil) {
        this.getTransaksiDetil = getTransaksiDetil;
    }
    
    
}
