/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transaksi.Interface;

import com.transaksi.Entity.Transaksi;

/**
 *
 * @author krypton
 */
public interface TransaksiInterface {
    boolean insertTransaksi(Transaksi transaksi);
    String kodeTransaksi();
}
