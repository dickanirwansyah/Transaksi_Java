/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transaksi.Entity;

/**
 *
 * @author krypton
 */
public class Barang {
    private String kodeBarang;
    private String nama;
    private int jumlah;
    private double harga;
    private boolean cek;

    public boolean isCek() {
        return cek;
    }

    public void setCek(boolean cek) {
        this.cek = cek;
    }
    
    
    
    public String getKodeBarang(){
        return kodeBarang;
    }
    
    public void setKodeBarang(String kodeBarang){
        this.kodeBarang=kodeBarang;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public int getJumlah(){
        return jumlah;
    }
    
    public void setJumlah(int jumlah){
        this.jumlah=jumlah;
    }
    
    public double getHarga(){
        return harga;
    }
    
    public void setHarga(double harga){
        this.harga=harga;
    }

    @Override
    public String toString() {
        return nama;
    }
    
    
}
