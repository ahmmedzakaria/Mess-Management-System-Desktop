/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package members;

/**
 *
 * @author Zakakaria
 */
public class MemberModel {

    private String memberId;
    private String managerId;
    private String fName;
    private String lName;
    private String fullName;
    private String mealName;
    private String imgPath;
    private String date;

    public MemberModel(String memberId, String managerId, String fName, String lName, String mealName, String imgPath, String date) {
        this(managerId, fName, lName, mealName, imgPath, date);
        this.memberId = memberId;
    }

    public MemberModel(String managerId, String fName, String lName, String mealName, String imgPath, String date) {
        this(managerId, fName, lName, imgPath, date);
        this.mealName = mealName;
    }

    public MemberModel(String managerId, String fName, String lName, String imgPath, String date) {
        this(fName, lName);
        this.managerId = managerId;
        this.imgPath = imgPath;
        this.date = date;
    }

    public MemberModel(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        this.fullName = fName + " " + lName;
    }

    public MemberModel(String fullName) {
        this.fullName = fullName;
    }
    

    public MemberModel() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMealName() {
        return mealName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getManagerId() {
        return managerId;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getDate() {
        return date;
    }

}
