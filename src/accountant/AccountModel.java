/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountant;

/**
 *
 * @author Zakakaria
 */
public class AccountModel {
    private String  accountId;
    private String  accountantId;
    private String  startDate;
    private String  endDate;
    private String  accountName;

    public AccountModel(String accountId, String accountantId, String startDate, String endDate, String accountName) {
        this.accountId = accountId;
        this.accountantId = accountantId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.accountName = accountName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(String accountantId) {
        this.accountantId = accountantId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    

}
