/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.modell.Producto_stock;
import java.util.ArrayList;

/**
 *
 * @author P&D
 */
public interface Producto_stockDAO {
    public boolean createProducto_stock(Producto_stock prost);
    public ArrayList<Producto_stock> readProducto_stock();
    public boolean updateProducto_stock(Producto_stock prost);
    public boolean deleteProducto_stock(String id);
}