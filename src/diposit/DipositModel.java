/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diposit;

/**
 *
 * @author Zakakaria
 */
public class DipositModel{
    private String dipositId;
    private String accountId;
    private String memberId;
    private String dipositAmt;
    private String ttlDiposit="0";
    private String dipositDate;

    public DipositModel(String dipositId, String accountId, String memberId, String dipositAmt,String dipositDate) {
        this.dipositId = dipositId;
        this.accountId = accountId;
        this.memberId = memberId;
        this.dipositAmt = dipositAmt;
        this.dipositDate = dipositDate;
    }

    public DipositModel() {
    }
    

    public String getTtlDiposit() {
        return ttlDiposit;
    }

    
    public String getDipositId() {
        return dipositId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getMemberId() {
        return memberId;
    }


    public String getDipositAmt() {
        return dipositAmt;
    }

    public String getDipositDate() {
        return dipositDate;
    }

    public void setDipositId(String dipositId) {
        this.dipositId = dipositId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setDipositAmt(String dipositAmt) {
        this.dipositAmt = dipositAmt;
    }

    public void setTtlDiposit(String ttlDiposit) {
        this.ttlDiposit = ttlDiposit;
    }

    public void setDipositDate(String dipositDate) {
        this.dipositDate = dipositDate;
    }
    
    
}
