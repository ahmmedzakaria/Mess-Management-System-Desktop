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
public class ReportModel {
    private String fullName;
    private String accountDetailsId;
    private String accountId;
    private String memberId;
    private String memberTtlDiposit;
    private String memberTtlMeal;
    private String memberNumBazar;
    private String memberExtra;

    private String memberTotalMelCost;
    private String memberTotalcost;
    private String memberGetMony;
    private String accGetMony;
    private String accTtlBazar;
    private String accNumBazar;
    private String accTtlExtras;
    private String accTtlDiposit;
    private String accMealRet;

    public ReportModel(String accountDetailsId, String accountId, String memberId, String memberTtlDiposit, String memberTtlMeal, String memberNumBazar, String memberExtra) {
        this.accountDetailsId = accountDetailsId;
        this.accountId = accountId;
        this.memberId = memberId;
        this.memberTtlDiposit = memberTtlDiposit;
        this.memberTtlMeal = memberTtlMeal;
        this.memberNumBazar = memberNumBazar;
        this.memberExtra = memberExtra;
    }

    public ReportModel() {
    }
    

    public String getAccountDetailsId() {
        return accountDetailsId;
    }

    public void setAccountDetailsId(String accountDetailsId) {
        this.accountDetailsId = accountDetailsId;
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

    public String getMemberTtlDiposit() {
        return memberTtlDiposit;
    }

    public void setMemberTtlDiposit(String memberTtlDiposit) {
        this.memberTtlDiposit = memberTtlDiposit;
    }

    public String getMemberTtlMeal() {
        return memberTtlMeal;
    }

    public void setMemberTtlMeal(String memberTtlMeal) {
        this.memberTtlMeal = memberTtlMeal;
    }

    public String getMemberNumBazar() {
        return memberNumBazar;
    }

    public void setMemberNumBazar(String memberNumBazar) {
        this.memberNumBazar = memberNumBazar;
    }

    public String getMemberExtra() {
        return memberExtra;
    }

    public void setMemberExtra(String memberExtra) {
        this.memberExtra = memberExtra;
    }

    public String getMemberTotalMelCost() {
        return memberTotalMelCost;
    }

    public void setMemberTotalMelCost(String memberTotalMelCost) {
        this.memberTotalMelCost = memberTotalMelCost;
    }

    public String getAccTtlBazar() {
        return accTtlBazar;
    }

    public void setAccTtlBazar(String accTtlBazar) {
        this.accTtlBazar = accTtlBazar;
    }

    public String getAccNumBazar() {
        return accNumBazar;
    }

    public void setAccNumBazar(String accNumBazar) {
        this.accNumBazar = accNumBazar;
    }

    public String getAccTtlExtras() {
        return accTtlExtras;
    }

    public void setAccTtlExtras(String accTtlExtras) {
        this.accTtlExtras = accTtlExtras;
    }

    public String getAccTtlDiposit() {
        return accTtlDiposit;
    }

    public void setAccTtlDiposit(String accTtlDiposit) {
        this.accTtlDiposit = accTtlDiposit;
    }

    public String getAccMealRet() {
        return accMealRet;
    }

    public void setAccMealRet(String accMealRet) {
        this.accMealRet = accMealRet;
    }

    public String getMemberTotalcost() {
        return memberTotalcost;
    }

    public void setMemberTotalcost(String memberTotalcost) {
        this.memberTotalcost = memberTotalcost;
    }

    public String getMemberGetMony() {
        return memberGetMony;
    }

    public void setMemberGetMony(String memberGetMony) {
        this.memberGetMony = memberGetMony;
    }

    public String getAccGetMony() {
        return accGetMony;
    }

    public void setAccGetMony(String accGetMony) {
        this.accGetMony = accGetMony;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    

}
