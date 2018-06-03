/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import accountant.AccountModel;
import static db.dbController.con;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import members.MemberModel;

/**
 *
 * @author Zakakaria
 */
public class AccountDbController {
    

    static Connection con = null;
    static Statement st  = null;
    static CallableStatement csmt = null;
    private static ResultSet rs;
    
    public static int getLastAccountId(){
        boolean t=true;
        int accountId=-1;
        try {
            
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{?=CALL fGetLastAccountId()}");
            csmt.registerOutParameter(1, java.sql.Types.INTEGER);
            t = csmt.execute();
            accountId=csmt.getInt(1);
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            t=false;
        }catch(Exception e){
        
        } finally {
           dbController.closeResources();
        }
        return accountId;
    }
    
       public static boolean createAccount(String accountentId,String date, String accountName) {
        boolean t = true;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pAddAccount(?,?,?)}");
            csmt.setString(1, accountentId);
            csmt.setString(2, date);
            csmt.setString(3, accountName);
            t = csmt.execute();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            t=false;
        }catch(Exception e){
        
        } finally {
           dbController.closeResources();
        }
        return t;
    }

    public static boolean addBatchAccountDetails(String accountId,List<MemberModel> members) {
        
        try {
            con = DatabaseHelper.getConnection();

            con.setAutoCommit(false);
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pAddAccountDetails(?,?)}");
            for(MemberModel member:members){
            csmt.setString(1, accountId);
            csmt.setString(2, member.getMemberId());
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
    
      public static List<AccountModel> getAllAccount(String accountantId) {
        List<AccountModel> accountList = new ArrayList();
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pGetAllAccountForAccountant(?)}");
            csmt.setString(1, accountantId);
            csmt.execute();

            rs = csmt.getResultSet();
            
            while (rs.next()) {
                AccountModel account=new AccountModel(
                rs.getString(1),
                rs.getString(2),
                toString(rs.getDate(3)),
                toString(rs.getDate(4)),
                rs.getString(5)
                );
                
                accountList.add(account);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.dbController.closeResources();
        }
        return accountList;
    }


    static public String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }


}
