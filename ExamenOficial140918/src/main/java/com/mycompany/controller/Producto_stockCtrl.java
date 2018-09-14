/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.configbd.Conexionbd;
import com.mycompany.controllerimpl.Producto_stockCtrlImpl;
import com.mycompany.dao.Producto_stockDAO;
import com.mycompany.modell.Producto_stock;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author LENOVO
 */
@ManagedBean(name = "producto_stockCtrl")
@SessionScoped
public class Producto_stockCtrl implements Serializable{
    private Producto_stock selec;
    private boolean est;
    Producto_stockDAO ventdao;
    private ArrayList<Producto_stock> list = new ArrayList<>();

    public Producto_stockCtrl() {
        this.selec = new Producto_stock();
        this.ventdao = new Producto_stockCtrlImpl();
    }
    public void createVenta(){
        if(ventdao.createProducto_stock(selec)){
            System.out.println("Insertado");
        }else{
            System.out.println("Error al insertar");
        }
    }
    public ArrayList<Producto_stock> getList(){
        ventdao = new Producto_stockCtrlImpl();
        list = ventdao.readProducto_stock();
        return list;
    }

    public Producto_stock getSelec() {
        return selec;
    }

    public void setSelec(Producto_stock selec) {
        this.selec = selec;
    }
    
    
}
