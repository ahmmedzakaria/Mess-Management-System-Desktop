/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import bazars.BazarModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zakakaria
 */
public class BazarDbController {
    static Connection con = null;
    static Statement st  = null;
    static CallableStatement csmt = null;
    static ResultSet rs=null;
    
     public static boolean addBazar(BazarModel model) {
        boolean t = true;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pAddBazar(?,?,?,?)}");
            csmt.setString(1, model.getAccountId());
            System.out.println("addBazar"+model.getMemberId());
            csmt.setString(2, model.getMemberId());
            csmt.setString(3, model.getBazarAmt());
            csmt.setString(4, model.getBazarDate());
            t = csmt.execute();
            System.out.println(t);
        } catch (SQLException e) {
            e.printStackTrace();
            t=false;
        } finally {
           dbController.closeResources();
        }
        return t;
    }
     
     public static double getTotalBazar(String accountId) {
        double ttlBazar= 0;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{?=CALL fgetTotalBazar(?)}");
            csmt.registerOutParameter(1, java.sql.Types.INTEGER);
            csmt.setString(2, accountId);   
            csmt.execute();
            ttlBazar=csmt.getDouble(1);;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.dbController.closeResources();
        }
        return ttlBazar;
    }
     
      public static List<BazarModel> getAllBazars(String accountId) {
        List<BazarModel> bazarList = new ArrayList();
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pGetAllBazar(?)}");
            csmt.setString(1, accountId);
            csmt.execute();

            rs = csmt.getResultSet();
            
            while (rs.next()) {
                BazarModel bazar=new BazarModel(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDate(4).toString(),
                rs.getString(5),
                rs.getString(6)
                );
                
                bazarList.add(bazar);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.dbController.closeResources();
        }
        return bazarList;
    }
}
