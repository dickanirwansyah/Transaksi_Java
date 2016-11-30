/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transaksi.TabelModel;

import com.transaksi.Entity.Barang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author krypton
 */
public class TabelModelBarang extends AbstractTableModel{
    
    private List<Barang> list=new ArrayList<Barang>();
    public TabelModelBarang(){
        
    }

    @Override
    public int getRowCount() {
    return list.size();
    }

    @Override
    public int getColumnCount() {
     return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     switch(columnIndex){
         case 0 : return list.get(rowIndex).getKodeBarang();
         case 1 : return list.get(rowIndex).getNama();
         case 2 : return list.get(rowIndex).getJumlah();
         case 3 : return list.get(rowIndex).getHarga();
         case 4 : return list.get(rowIndex).isCek();
         default:return null;
     }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "kode barang";
                case  1 : return "nama";
                case 2 : return "jumlah";
                case 3 : return "harga";
                case 4 : return "#";
                default:return null;
        }
    }
    
    public void insertBarang(Barang barang){
        this.list.add(barang);
        fireTableDataChanged();
    }
    
    public void updateBarang(int index, Barang barang){
        this.list.set(index, barang);
        fireTableDataChanged();
    }
    
    public void deletBarang(int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(List<Barang> list){
        this.list=list;
        fireTableDataChanged();
    }
    
    public Barang getBarang(int index){
        return list.get(index);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==4){
            return Boolean.class;
        }else{
            return super.getColumnClass(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
    }
    
    
    
    public Boolean barangCek(Boolean cek){
        return list.equals(cek);
    }
    
    public List<Barang> getBarangCek(){
        List ls=new ArrayList();
        for(Barang b : list){
            if(b.isCek()){
                ls.add(b);
            }
        }
        return ls;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
     if(aValue!=null && aValue instanceof Boolean && columnIndex==4){
         Boolean cek=(Boolean) aValue;
         list.get(rowIndex).setCek(cek);
     }
    }
    
    
    
}
