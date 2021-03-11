package com.alyndroid.architecturepatternstutorialshomework.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.POJO.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding01;
    private MyNumVIEWmodel wmodel01;
    private MyNumPresenter presenter01;
    private DataBase dataBase01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        binding01 = ActivityMainBinding.inflate(getLayoutInflater());
        View view01 = binding01.getRoot();
        setContentView(view01);
        binding01.mulButton.setOnClickListener(this);
        //****************** MVVM ***************************************************
        wmodel01 = ViewModelProviders.of(this).get(MyNumVIEWmodel.class);
        wmodel01.MULTIresult.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding01.mulResultTextView.setText(s);
            }
        });
        //***************** MVP *****************************************************
        presenter01 = new MyNumPresenter();
        binding01.divButton.setOnClickListener(this);
        //******************* MVC ***************************************************
        binding01.plusButton.setOnClickListener(this);
        dataBase01 = new DataBase();
        //*********************************************************************
    }

    @Override
    public void onClick(View v) {
        //*************** MVVM **************************
        if(v.getId() == binding01.mulButton.getId()){
            wmodel01.getMutli();
        }
        //*************** MVP *****************************
        if(v.getId() == binding01.divButton.getId()){
            binding01.divResultTextView.setText(presenter01.getDivistion());
        }
        //**************** MVC ******************************
        if(v.getId() == binding01.plusButton.getId()){
            int num1 = dataBase01.getNumbers().getFirstNum();
            int num2 = dataBase01.getNumbers().getSecondNum();
            int res = num1 + num2;
            String strREs = String.valueOf(res);
            binding01.plusResultTextView.setText(strREs);
        }
    }


}
