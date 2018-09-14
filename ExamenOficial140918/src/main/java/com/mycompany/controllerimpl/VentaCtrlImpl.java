package com.mycompany.controllerimpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mycompany.modell.Venta;
import com.mycompany.configbd.Conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.dao.VentaDAO;

/**
 *
 * @author ANDY
 */
public class VentaCtrlImpl implements VentaDAO {

    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Venta> listDatos;

    public VentaCtrlImpl() {
        cx = new Conexionbd();
    }

    @Override
    public boolean createVenta(Venta vent) {
        sql = "INSERT INTO public.venta(fecha,concepto, igv, total, sub_total, id_cliente_direccion, id_vendedor) "
                + "VALUES('"+vent.getFecha()+"','"+vent.getConcepto()+"','"+vent.getIgv()+"','"+vent.getTotal()+"','"+vent.getSub_total()+"','"+vent.getId_cliente_direccion()+"','"+vent.getId_vendedor()+"')";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<Venta> readVenta() {
        listDatos = new ArrayList<>();
        sql = "SELECT id_venta, fecha, concepto, igv, total, sub_total, id_cliente_direccion, id_vendedor "
                + "    FROM public.venta";
        try {
            while (rs.next()) {
                listDatos.add(new Venta(rs.getString("id_venta"),rs.getString("fecha"),rs.getString("concepto"),rs.getString("igv"),rs.getString("total"), rs.getString("sub_total"), rs.getString("id_cliente_direccion"), rs.getString("id_vendedor")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(VentaCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateVenta(Venta vent) {
        sql = "UPDATE public.venta SET "
                + " fecha = '"+vent.getFecha()+"', concepto = '"+vent.getConcepto()+"', igv = '"+vent.getIgv()+"', total = '"+vent.getTotal()+"', sub_total = '"+vent.getSub_total()+"', id_cliente_direccion = '"+vent.getId_cliente_direccion()+"', id_vendedor = '"+vent.getId_vendedor()+"' "
                + "WHERE id_venta = "+vent.getId_venta()+" ";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteVenta(String id) {
        sql = "DELETE FROM public.venta "
                + "WHERE id_venta = "+id+" ";
        return cx.executeInsertUpdate(sql);
    }

}
