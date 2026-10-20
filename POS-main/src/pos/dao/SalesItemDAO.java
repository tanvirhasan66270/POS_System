/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pos.model.SalesItem;
import pos.util.DbUtil;

/**
 *
 * @author Admin
 */
public class SalesItemDAO {

    DbUtil db = new DbUtil();
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public void saveSalesItem(SalesItem sitem) {

        try {

            Connection con = db.getCon();

            sql = "INSERT INTO sales_items(sales_id,product_id,quantity,unit_price,total_price,discount_rate,discount,actual_price) VALUES(?,?,?,?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, sitem.getSalesId());
            ps.setInt(2, sitem.getProductId());
            ps.setDouble(3, sitem.getQuantity());
            ps.setDouble(4, sitem.getUnitPrice());
            ps.setDouble(5, sitem.getTotalPrice());
            ps.setDouble(6, sitem.getDiscountRate());
            ps.setDouble(7, sitem.getDiscount());
            ps.setDouble(8, sitem.getActualPrice());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
