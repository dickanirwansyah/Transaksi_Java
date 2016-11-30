/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transaksi.Interface;

import com.transaksi.Entity.Barang;
import java.util.List;

/**
 *
 * @author krypton
 */
public interface BarangInterface {
    boolean insertBarang(Barang barang);
    boolean updateBarang(Barang barang);
    boolean deleteBarang(Barang barang);
    Barang getByid(String id);
    List<Barang> getBarang();
    String AutoNumber();
    void kurangJumlahStokBarang(int jumlah, Barang barang);
}
