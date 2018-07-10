package com.dvb.ui_boarding_app;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dvb.ui_boarding_app.databinding.ActivityMainBinding;
import com.dvb.ui_boarding_app.utilities.FakeDataUtils;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        BoardingPassInfo fakeBoardingInfo = FakeDataUtils.generateFakeBoardingPassInfo();
    }


    private void displayBoardingPassInfo(BoardingPassInfo info){

    }

}
