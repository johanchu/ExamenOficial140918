/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modell;

/**

 */
public class Producto_stock {

   String id_producto_stock,stock_update,id_producto,id_lote,id_almacen;

    public Producto_stock(String id_producto_stock, String stock_update, String id_producto, String id_lote, String id_almacen) {
        this.id_producto_stock = id_producto_stock;
        this.stock_update = stock_update;
        this.id_producto = id_producto;
        this.id_lote = id_lote;
        this.id_almacen = id_almacen;
    }

    public Producto_stock() {
    }

    public String getId_producto_stock() {
        return id_producto_stock;
    }

    public void setId_producto_stock(String id_producto_stock) {
        this.id_producto_stock = id_producto_stock;
    }

    public String getStock_update() {
        return stock_update;
    }

    public void setStock_update(String stock_update) {
        this.stock_update = stock_update;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_lote() {
        return id_lote;
    }

    public void setId_lote(String id_lote) {
        this.id_lote = id_lote;
    }

    public String getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(String id_almacen) {
        this.id_almacen = id_almacen;
    }
   
   
    
}
