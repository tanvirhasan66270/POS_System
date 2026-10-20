/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pos.model.Sales;
import pos.service.DaoService;
import pos.util.DbUtil;
import pos.util.SalesUtil;

/**
 *
 * @author Admin
 */
public class SalesDao {

    DbUtil dbu = new DbUtil();
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    SalesUtil su = new SalesUtil();

    public SalesDao() {
    }

    public int save(Sales sl) {

        int salesId = 0;

        sql = "INSERT INTO sales(invoice_no,sales_date,customer_cell,total_amount) VALUES(?,?,?,?)";

        try {
            ps = dbu.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, sl.getInvoiceNo());
            ps.setDate(2, sl.getSqlsalesDate());
            ps.setString(3, sl.getCustomerCell());
            ps.setDouble(4, sl.getTotalAmount());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                salesId = rs.getInt(1);
            }

            ps.close();
            dbu.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(SalesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return salesId;


    }

    

}
