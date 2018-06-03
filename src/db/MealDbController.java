/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import accountant.ReportModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import meals.MealModel;

/**
 *
 * @author Zakakaria
 */
public class MealDbController {
    static Connection con = null;
    static Statement st  = null;
    static CallableStatement csmt = null;
    static ResultSet rs=null;

    
    public static boolean saveAllMeals(List<MealModel> mealModel){
     try {
            con = DatabaseHelper.getConnection();
            int loopcount=0;
            con.setAutoCommit(false);
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pAddMeal(?,?,?,?)}");
            for(MealModel model: mealModel){
            csmt.setString(1, model.getAccountId());
            csmt.setString(2, model.getMemberId());
            csmt.setString(3, model.getMeal());
            csmt.setString(4, model.getMealDate());
            csmt.addBatch();
            loopcount++;
            }
            System.out.println("loopcount "+loopcount);
            int counts[] = csmt.executeBatch();
            System.out.println("counts "+counts);
            
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
    public static double getTotalMeal(String accountId) {
        double ttlMeal= 0;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{?=CALL fgetTotalMeal(?)}");
            csmt.registerOutParameter(1, java.sql.Types.INTEGER);
            csmt.setString(2, accountId);   
            csmt.execute();
            ttlMeal=csmt.getDouble(1);;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.dbController.closeResources();
        }
        return ttlMeal;
    }
    
     public static List<ReportModel>  getAllAccountDetails(String accountId) {
        List<ReportModel> memberList = new ArrayList();
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pGetAllAccountDetails(?)}");
            csmt.setString(1, accountId);
            csmt.execute();

            rs = csmt.getResultSet();
            
            while (rs.next()) {
                ReportModel report=new ReportModel(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7)
                );
                
                memberList.add(report);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.dbController.closeResources();
        }
        return memberList;
    }

}
