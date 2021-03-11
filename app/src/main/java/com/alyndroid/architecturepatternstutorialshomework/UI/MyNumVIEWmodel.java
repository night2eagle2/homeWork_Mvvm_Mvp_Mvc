package com.alyndroid.architecturepatternstutorialshomework.UI;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.POJO.DataBase;

public class MyNumVIEWmodel extends ViewModel {

    private DataBase myDataBase = new DataBase();
    public MutableLiveData<String> MULTIresult = new MutableLiveData<>();

    public void getMutli(){
        int num1 = myDataBase.getNumbers().getFirstNum();
        int num2 = myDataBase.getNumbers().getSecondNum();
        int res = num1 * num2;
        String strRes = String.valueOf(res);
        MULTIresult.setValue(strRes);
    }

}
