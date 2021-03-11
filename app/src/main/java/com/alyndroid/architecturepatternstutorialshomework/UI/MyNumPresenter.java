package com.alyndroid.architecturepatternstutorialshomework.UI;

import com.alyndroid.architecturepatternstutorialshomework.POJO.DataBase;

public class MyNumPresenter {
    private DataBase dataBase01 = new DataBase();
    public String getDivistion(){
        int num1 = dataBase01.getNumbers().getFirstNum();
        int num2 =dataBase01.getNumbers().getSecondNum();
        int res = num1 / num2;
        String strRes = String.valueOf(res);
        return strRes;
    }
}
