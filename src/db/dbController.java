/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import members.MemberModel;


/**
 *
 * @author Zakakaria
 */
public class dbController {

    static Connection con = null;
    static CallableStatement csmt = null;
    static ResultSet rs=null;
    static Statement st=null;

    public static boolean addAccountant(String name, String userName, String pass) {
        boolean t = true;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pAddAccountant(?,?,?)}");
            csmt.setString(1, name);
            csmt.setString(2, userName);
            csmt.setString(3, pass);
            t = csmt.execute();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            t=false;
        }catch(Exception e){
        
        } finally {
           closeResources();
        }
        return t;
    }
    
    public static boolean addManager(String name, String userName, String pass,String date) {
        boolean t = true;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pAddManager(?,?,?,?)}");
            csmt.setString(1, name);
            csmt.setString(2, userName);
            csmt.setString(3, pass);
            csmt.setString(4, date);
            t = csmt.execute();
            System.out.println(t);
        } catch (SQLException e) {
            e.printStackTrace();
            t=false;
        } finally {
           closeResources();
        }
        return t;
    }
    
    public static boolean validateAccountentLogin(String userName, String pass) {
        boolean t = true;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{?=CALL fAccountantLoginValidator(?,?)}");
            csmt.registerOutParameter(1, java.sql.Types.INTEGER);
            csmt.setString(2, userName);
            csmt.setString(3, pass);
            
            csmt.execute();
            int rowCount=csmt.getInt(1);
            if(rowCount!=1){
                t=false;
            }
            System.out.println(rowCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return t;
    }
    
    public static boolean validateManagertLogin(String userName, String pass) {
        boolean t = true;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{?=CALL fManagerLoginValidator(?,?)}");
            csmt.registerOutParameter(1, java.sql.Types.INTEGER);
            csmt.setString(2, userName);
            csmt.setString(3, pass);
            
            csmt.execute();
            int rowCount=csmt.getInt(1);
            if(rowCount!=1){
                t=false;
            }
            System.out.println(rowCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return t;
    }
    
     public static boolean addMember(MemberModel member) {
        boolean t = true;
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pAddMember(?,?,?,?,?)}");
            csmt.setString(1, member.getManagerId());
            csmt.setString(2, member.getfName());
            csmt.setString(3, member.getlName());
            csmt.setString(4, member.getImgPath());
            csmt.setString(5, member.getDate());
            t = csmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                csmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return t;
    }
     public static List getAllMembers() {
        List<MemberModel> memberList = new ArrayList();
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL pGetAllMembers()}");
            csmt.execute();

            rs = csmt.getResultSet();
            
            while (rs.next()) {
                MemberModel member=new MemberModel(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getDate(7).toString()
                );
                
                memberList.add(member);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return memberList;
    }
     
      public static List getAllMembers(String accountId) {
        List<MemberModel> memberList = new ArrayList();
        try {
            con = DatabaseHelper.getConnection();
            csmt = con.prepareCall("{CALL getMembersForAccount(?)}");
            csmt.setString(1, accountId);
            csmt.execute();

            rs = csmt.getResultSet();
            
            while (rs.next()) {
                MemberModel member=new MemberModel(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getDate(7).toString()
                );
                
                memberList.add(member);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return memberList;
    }
     
     
     
     public static List<String> getAllMemberNames(){
         List<String> members=new ArrayList<>();
         List<MemberModel> membreList=dbController.getAllMembers();
        for(MemberModel member : membreList){
          members.add(member.getFullName());
       }
        return members;
     }
      public static List<String> getAllMemberNames(String accountId){
         List<String> members=new ArrayList<>();
         List<MemberModel> membreList=dbController.getAllMembers(accountId);
        for(MemberModel member : membreList){
          members.add(member.getFullName());
       }
        return members;
     }
    
    public static void closeResources(){
        try {
            if(con != null)
                con.close();
            if(csmt != null)
                csmt.close();
            if(rs != null)
                rs.close();
            if(st!=null)
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
}
