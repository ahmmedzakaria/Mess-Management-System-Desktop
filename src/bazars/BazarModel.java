/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazars;

import java.io.IOException;

/**
 *
 * @author Zakakaria
 */
public class BazarModel {

    private String accountId;
    private String memberId;
    private String fname;
    private String lName;
    private String fullName;
    private String bazarAmt;
    private String bazarDate;

    public BazarModel(String accountId, String memberId, String bazarAmt, String bazarDate) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.bazarAmt = bazarAmt;
        this.bazarDate = bazarDate;
    }

    public BazarModel(String fname, String lName, String bazarAmt, String bazarDate, String accountId, String memberId) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.fname = fname;
        this.lName = lName;
        this.bazarAmt = bazarAmt;
        this.bazarDate = bazarDate;
        this.fullName = fname + " " + lName;
    }

    public BazarModel() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBazarAmt() {
        return bazarAmt;
    }

    public void setBazarAmt(String bazarAmt) throws IOException {
        if (bazarAmt.isEmpty()) {
            throw new IOException();
        } else {
            this.bazarAmt = bazarAmt;
        }
    }

    public String getBazarDate() {
        return bazarDate;
    }

    public void setBazarDate(String bazarDate) {
        this.bazarDate = bazarDate;
    }

}
