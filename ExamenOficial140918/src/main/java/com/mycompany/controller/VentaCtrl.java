/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.configbd.Conexionbd;
import com.mycompany.controllerimpl.VentaCtrlImpl;
import com.mycompany.dao.VentaDAO;
import com.mycompany.modell.Venta;
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
@ManagedBean(name = "ventaCtrl")
@SessionScoped
public class VentaCtrl implements Serializable{
    private Venta selec;
    private boolean est;
    VentaDAO ventdao;
    private ArrayList<Venta> list = new ArrayList<>();

    public VentaCtrl() {
        this.selec = new Venta();
        this.ventdao = new VentaCtrlImpl();
    }
    public void createVenta(){
        if(ventdao.createVenta(selec)){
            System.out.println("Insertado");
        }else{
            System.out.println("Error al insertar");
        }
    }
    public ArrayList<Venta> getList(){
        ventdao = new VentaCtrlImpl();
        list = ventdao.readVenta();
        return list;
    }

    public Venta getSelec() {
        return selec;
    }

    public void setSelec(Venta selec) {
        this.selec = selec;
    }
    
    
}
