package com.mycompany.controllerimpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mycompany.modell.Producto_stock;
import com.mycompany.configbd.Conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.dao.Producto_stockDAO;

/**
 *
 * @author ANDY
 */
public class Producto_stockCtrlImpl implements Producto_stockDAO {

    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Producto_stock> listDatos;

    public Producto_stockCtrlImpl() {
        cx = new Conexionbd();
    }

    @Override
    public boolean createProducto_stock(Producto_stock prost) {
        sql = "INSERT INTO public.producto_stock(stock_update,id_producto,id_lote,id_almacen) "
                + "VALUES('"+prost.getStock_update()+"','"+prost.getId_producto()+"','"+prost.getId_lote()+"','"+prost.getId_almacen()+"')";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<Producto_stock> readProducto_stock() {
        listDatos = new ArrayList<>();
        sql = "SELECT id_producto_stock,stock_update,id_producto,id_lote,id_almacen "
                + "    FROM public.producto_stock";
        try {
            while (rs.next()) {
                listDatos.add(new Producto_stock(rs.getString("id_producto_stock"),rs.getString("stock_update"),rs.getString("id_producto"),rs.getString("id_lote"), rs.getString("id_almacen")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Producto_stockCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateProducto_stock(Producto_stock prost) {
        sql = "UPDATE public.producto_stock SET "
                + " stock_update = '"+prost.getStock_update()+"', id_producto = '"+prost.getId_producto()+"', id_lote = '"+prost.getId_lote()+"', id_almacen = '"+prost.getId_almacen()+"' "
                + "WHERE id_producto_stock = "+prost.getId_producto_stock()+" ";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteProducto_stock(String id) {
        sql = "DELETE FROM public.producto_stock "
                + "WHERE id_producto_stock = "+id+" ";
        return cx.executeInsertUpdate(sql);
    }

}
