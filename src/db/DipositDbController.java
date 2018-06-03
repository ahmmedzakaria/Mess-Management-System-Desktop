/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import diposit.DipositModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import members.MemberModel;

/**
 *
 * @author Zakakaria
 */
public class DipositDbController {
    static Connection con = null;
    static CallableStatement csmt = null;
    static ResultSet rs=null;
    
    public static List getAllDiposits(String accountId) {
        List<DipositModel> memberList = new ArrayList();
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pGetAllDiposit(?)}");
            csmt.setString(1, accountId);
            csmt.execute();

            rs = csmt.getResultSet();
            
            while (rs.next()) {
                DipositModel member=new DipositModel(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getDate(5).toString()
                );
                
                memberList.add(member);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbController.closeResources();
        }
        return memberList;
    }
public static boolean saveDipositBatch(List<DipositModel> dipositModelList) {
        
        try {
            con = DatabaseHelper.getConnection();

            con.setAutoCommit(false);
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pAddDiposit(?,?,?,?)}");
            for(DipositModel model:dipositModelList){
            csmt.setString(1, model.getAccountId());
            csmt.setString(2, model.getMemberId());
            csmt.setString(3, model.getDipositAmt());
            csmt.setString(4, model.getDipositDate());
            csmt.addBatch();
            }
            int counts[] = csmt.executeBatch();
            con.commit();
            System.out.println("Committed " + counts.length + " updates");

        } catch (SQLException ex) {

            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex1) {
                    Logger lgr = Logger.getLogger(AccountDbController.class.getName());
                    lgr.log(Level.WARNING, ex1.getMessage(), ex1);
                }
            }

            Logger lgr = Logger.getLogger(AccountDbController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            dbController.closeResources();
        }
        return true;

    }
public static double getTotalDiposit(String accountId) {
        double ttlDiposit= 0;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{?=CALL fTotalDiposit(?)}");
            csmt.registerOutParameter(1, java.sql.Types.INTEGER);
            csmt.setString(2, accountId);   
            csmt.execute();
            ttlDiposit=csmt.getDouble(1);;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.dbController.closeResources();
        }
        return ttlDiposit;
    }
}
