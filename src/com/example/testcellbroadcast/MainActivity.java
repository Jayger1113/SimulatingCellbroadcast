package com.example.testcellbroadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsCbCmasInfo;
import android.telephony.SmsCbLocation;
import android.telephony.SmsCbMessage;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button mBtn911;
    Button mBtn919;
    Button mBtn4370;
    Button mBtn4383;
    Button mBtn4380;
    Button mBtn4393;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {
        mBtn911 = (Button) findViewById(R.id.btn_911);
        mBtn911.setOnClickListener(mOnLickListener911);
        mBtn919 = (Button) findViewById(R.id.btn_919);
        mBtn919.setOnClickListener(mOnLickListener919);
        mBtn4370 = (Button) findViewById(R.id.btn_4370);
        mBtn4370.setOnClickListener(mOnLickListener4370);
        mBtn4383 = (Button) findViewById(R.id.btn_4383);
        mBtn4383.setOnClickListener(mOnLickListener4383);
        mBtn4380 = (Button) findViewById(R.id.btn_4380);
        mBtn4380.setOnClickListener(mOnLickListener4380);
        mBtn4393 = (Button) findViewById(R.id.btn_4393);
        mBtn4393.setOnClickListener(mOnLickListener4393);
    }

    View.OnClickListener mOnLickListener911 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            send911TestMessage();
        }
    };
    View.OnClickListener mOnLickListener919 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            send919TestMessage();
        }
    };

    View.OnClickListener mOnLickListener4370 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            send4370TestMessage();
        }
    };

    View.OnClickListener mOnLickListener4383 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            send4383TestMessage();
        }
    };

    View.OnClickListener mOnLickListener4380 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            send4380TestMessage();
        }
    };

    View.OnClickListener mOnLickListener4393 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            send4393TestMessage();
        }
    };

    private void send911TestMessage() {
        Intent intent = new Intent("android.provider.Telephony.SMS_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(
                Channel911Constants.TEST_PLMN, Channel911Constants.TEST_LAC,
                Channel911Constants.TEST_CELL_ID);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(
                Channel911Constants.TEST_MESSAGE_FORMAT,
                Channel911Constants.TEST_GEO_SCOPE,
                Channel911Constants.TEST_SERIAL_NUM, smsCbLocation,
                Channel911Constants.TEST_CHANNEL_911,
                Channel911Constants.TEST_LANGUAGE,
                Channel911Constants.TEST_CHANNEL_MESSAGE,
                Channel911Constants.TEST_PRIORITY, null, null);
        intent.setClassName("com.android.cellbroadcastreceiver",
                "com.android.cellbroadcastreceiver.CellBroadcastAlertService");
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", Channel911Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", Channel911Constants.TEST_SLOT);
        startService(intent);
    }

    private void send919TestMessage() {

    }

    private void send4370TestMessage() {

    }

    private void send4383TestMessage() {

    }

    private void send4380TestMessage() {
        Intent intent = new Intent("android.provider.Telephony.SMS_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(
                Channel4380Constants.TEST_PLMN, Channel4380Constants.TEST_LAC,
                Channel4380Constants.TEST_CELL_ID);
        SmsCbCmasInfo smsCbCmasInfo = new SmsCbCmasInfo(
                Channel4380Constants.TEST_CMASINFO_MESSAGE_CLASS,
                Channel4380Constants.TEST_CMASINFO_CATEGORY,
                Channel4380Constants.TEST_CMASINFO_RESPONSETYPE,
                Channel4380Constants.TEST_CMASINFO_SERVERITY,
                Channel4380Constants.TEST_CMASINFO_URGENCY,
                Channel4380Constants.TEST_CMASINFO_CERTAINTY);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(
                Channel4380Constants.TEST_MESSAGE_FORMAT,
                Channel4380Constants.TEST_GEO_SCOPE,
                Channel4380Constants.TEST_SERIAL_NUM, smsCbLocation,
                Channel4380Constants.TEST_CHANNEL_4380,
                Channel4380Constants.TEST_LANGUAGE,
                Channel4380Constants.TEST_CHANNEL_MESSAGE,
                Channel4380Constants.TEST_PRIORITY, null, smsCbCmasInfo);
        intent.setClassName("com.android.cellbroadcastreceiver",
                "com.android.cellbroadcastreceiver.CellBroadcastAlertService");
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", Channel4380Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", Channel4380Constants.TEST_SLOT);
        startService(intent);
    }

    private void send4393TestMessage() {

    }
}
