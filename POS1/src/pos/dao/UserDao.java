/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.dao;

import com.mysql.cj.xdevapi.DatabaseObject;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pos.model.User;
import pos1.util.DbUtil;

public class UserDao {

    DbUtil util = new DbUtil();
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;

    public void saveUser(User user) {

        sql = "insert into user(userName , password) values(?,?)";
        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ps.executeUpdate();

            ps.close();
            util.getCon().close();
            System.out.println("Data Saved");
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
