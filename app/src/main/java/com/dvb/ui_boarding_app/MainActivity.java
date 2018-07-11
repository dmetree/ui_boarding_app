package com.dvb.ui_boarding_app;

import android.content.Loader;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dvb.ui_boarding_app.databinding.ActivityMainBinding;
import com.dvb.ui_boarding_app.utilities.FakeDataUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        BoardingPassInfo fakeBoardingInfo = FakeDataUtils.generateFakeBoardingPassInfo();

        displayBoardingPassInfo(fakeBoardingInfo);
    }


    private void displayBoardingPassInfo(BoardingPassInfo info){
        mBinding.passengerName.setText(info.passengerName);
        mBinding.fromLabel.setText(info.originCode);
        mBinding.toLabel.setText(info.destCode);
        mBinding.textView20.setText(info.flightCode);

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String boardingTime = formatter.format(info.boardingTime);
        String departureTime = formatter.format(info.departureTime);
        String arrivalTime = formatter.format(info.arrivalTime);

        mBinding.boardingTime.setText(boardingTime);
        mBinding.departure.setText(departureTime);
        mBinding.arrival.setText(arrivalTime);

//        format the total minutes until boarding
        long totalMinutesUntilBoarding = info.getMinutesUntilBoarding();
        long hoursUntilBoarding = TimeUnit.MINUTES.toHours(totalMinutesUntilBoarding);
        long minutesLessHoursUntilBoarding =
                totalMinutesUntilBoarding - TimeUnit.HOURS.toMinutes(hoursUntilBoarding);

        String hoursAndMinutesUntilBoarding = getString(R.string.countDownFormat,
                hoursUntilBoarding, minutesLessHoursUntilBoarding);

        mBinding.boardingIn.setText(hoursAndMinutesUntilBoarding);
        mBinding.terminal.setText(info.departureTerminal);
        mBinding.gate.setText(info.departureGate);
        mBinding.seat.setText(info.seatNumber);
    }

}
