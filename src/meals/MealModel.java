/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meals;

import java.io.IOException;

/**
 *
 * @author Zakakaria
 */
public class MealModel {

    private String accountId;
    private String memberId;
    private String meal;
    private String mealDate;

    public MealModel(String accountId, String memberId, String meal, String mealDate) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.meal = meal;
        this.mealDate = mealDate;
    }

    public MealModel() {
    }

    public String getAccountId() {
        return accountId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMeal() {
        return meal;
    }

    public String getMealDate() {
        return mealDate;
    }

    public void setAccountId(String accountId) throws IOException {
        if (accountId.isEmpty()) {
            throw new IOException();
        } else {
            this.accountId = accountId;
        }
    }

    public void setMemberId(String memberId) throws IOException {
        if (memberId.isEmpty()) {
            throw new IOException();
        } else {
            this.memberId = memberId;
        }
    }

    public void setMeal(String meal) throws IOException {
        if (meal.isEmpty()) {
            throw new IOException();
        } else {
            this.meal = meal;
        }
    }

    public void setMealDate(String mealDate) throws IOException {
        if (mealDate.isEmpty()) {
            throw new IOException();
        } else {
            this.mealDate = mealDate;
        }
    }

}
