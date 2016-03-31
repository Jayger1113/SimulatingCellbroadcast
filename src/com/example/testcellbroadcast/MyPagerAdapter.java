
package com.example.testcellbroadcast;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.telephony.SmsCbCmasInfo;
import android.telephony.SmsCbLocation;
import android.telephony.SmsCbMessage;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.testcellbroadcast.constants.Channel4370Constants;
import com.example.testcellbroadcast.constants.Channel4380Constants;
import com.example.testcellbroadcast.constants.Channel4383Constants;
import com.example.testcellbroadcast.constants.Channel4393Constants;
import com.example.testcellbroadcast.constants.Channel911Constants;
import com.example.testcellbroadcast.constants.Channel919Constants;
import com.example.testcellbroadcast.constants.ChannelCustomConstants;

public class MyPagerAdapter extends PagerAdapter {

    private static final String TAG = MyPagerAdapter.class.getSimpleName();

    private List<View> mListViews;

    private Activity mActivity;

    Button mSim1Btn911;

    Button mSim1Btn919;

    Button mSim1Btn4370;

    Button mSim1Btn4383;

    Button mSim1Btn4380;

    Button mSim1Btn4393;

    Button mSim1BtnCustom;

    EditText mSim1EditText;

    Switch mSim1Switch911;

    Switch mSim1Switch4370;

    Button mSim2Btn911;

    Button mSim2Btn919;

    Button mSim2Btn4370;

    Button mSim2Btn4383;

    Button mSim2Btn4380;

    Button mSim2Btn4393;

    Button mSim2BtnCustom;

    EditText mSim2EditText;

    Switch mSim2Switch911;

    Switch mSim2Switch4370;

    public MyPagerAdapter(Activity activity) {
        mListViews = new ArrayList<View>();
        mActivity = activity;
        LayoutInflater inflater = mActivity.getLayoutInflater();
        mListViews.add(inflater.inflate(R.layout.sim1, null));
        mListViews.add(inflater.inflate(R.layout.sim2, null));
    }

    @Override
    public int getCount() {
        return mListViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == (object);
    }

    @Override
    public Object instantiateItem(View collection, int position) {

        ((ViewPager)collection).addView(mListViews.get(position), 0);

        return mListViews.get(position);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        Log.v(TAG, "finishUpdate container.getId()=" + container.getId());

        mSim1Btn911 = (Button)mActivity.findViewById(R.id.sim1_btn_911);
        mSim1Btn911.setOnClickListener(mOnLickListener911);
        mSim1Btn919 = (Button)mActivity.findViewById(R.id.sim1_btn_919);
        mSim1Btn919.setOnClickListener(mOnLickListener919);
        mSim1Btn4370 = (Button)mActivity.findViewById(R.id.sim1_btn_4370);
        mSim1Btn4370.setOnClickListener(mOnLickListener4370);
        mSim1Btn4383 = (Button)mActivity.findViewById(R.id.sim1_btn_4383);
        mSim1Btn4383.setOnClickListener(mOnLickListener4383);
        mSim1Btn4380 = (Button)mActivity.findViewById(R.id.sim1_btn_4380);
        mSim1Btn4380.setOnClickListener(mOnLickListener4380);
        mSim1Btn4393 = (Button)mActivity.findViewById(R.id.sim1_btn_4393);
        mSim1Btn4393.setOnClickListener(mOnLickListener4393);

        mSim1EditText = (EditText)mActivity.findViewById(R.id.sim1_ed_custom);
        mSim1BtnCustom = (Button)mActivity.findViewById(R.id.sim1_btn_custom);
        mSim1BtnCustom.setOnClickListener(mOnLickListenerCustom);
        mSim1Switch911 = (Switch)mActivity.findViewById(R.id.sim1_switch_911);
        mSim1Switch4370 = (Switch)mActivity.findViewById(R.id.sim1_switch_4370);

        mSim2Btn911 = (Button)mActivity.findViewById(R.id.sim2_btn_911);
        mSim2Btn911.setOnClickListener(mOnLickListener911);
        mSim2Btn919 = (Button)mActivity.findViewById(R.id.sim2_btn_919);
        mSim2Btn919.setOnClickListener(mOnLickListener919);
        mSim2Btn4370 = (Button)mActivity.findViewById(R.id.sim2_btn_4370);
        mSim2Btn4370.setOnClickListener(mOnLickListener4370);
        mSim2Btn4383 = (Button)mActivity.findViewById(R.id.sim2_btn_4383);
        mSim2Btn4383.setOnClickListener(mOnLickListener4383);
        mSim2Btn4380 = (Button)mActivity.findViewById(R.id.sim2_btn_4380);
        mSim2Btn4380.setOnClickListener(mOnLickListener4380);
        mSim2Btn4393 = (Button)mActivity.findViewById(R.id.sim2_btn_4393);
        mSim2Btn4393.setOnClickListener(mOnLickListener4393);
        mSim2Switch911 = (Switch)mActivity.findViewById(R.id.sim2_switch_911);
        mSim2Switch4370 = (Switch)mActivity.findViewById(R.id.sim2_switch_4370);

        mSim2EditText = (EditText)mActivity.findViewById(R.id.sim2_ed_custom);
        mSim2BtnCustom = (Button)mActivity.findViewById(R.id.sim2_btn_custom);
        mSim2BtnCustom.setOnClickListener(mOnLickListenerCustom);

    }

    View.OnClickListener mOnLickListener911 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            boolean isSim1 = v.getId() == R.id.sim1_btn_911 ? true : false;
            int testGeo;
            if (isSim1) {
                testGeo = mSim1Switch911.isChecked() ? 1 : Channel911Constants.TEST_GEO_SCOPE;
            } else {
                testGeo = mSim2Switch911.isChecked() ? 1 : Channel911Constants.TEST_GEO_SCOPE;
            }
            send911TestMessage(isSim1 ? 0 : 1, testGeo);
        }
    };

    View.OnClickListener mOnLickListener919 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            send919TestMessage(v.getId() == R.id.sim1_btn_919 ? 0 : 1);
        }
    };

    View.OnClickListener mOnLickListener4370 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            boolean isSim1 = v.getId() == R.id.sim1_btn_4370 ? true : false;
            int testGeo;
            if (isSim1) {
                testGeo = mSim1Switch4370.isChecked() ? 1 : Channel4370Constants.TEST_GEO_SCOPE;
            } else {
                testGeo = mSim2Switch4370.isChecked() ? 1 : Channel4370Constants.TEST_GEO_SCOPE;
            }
            send4370TestMessage(isSim1 ? 0 : 1, testGeo);
        }
    };

    View.OnClickListener mOnLickListener4383 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            send4383TestMessage(v.getId() == R.id.sim1_btn_4383 ? 0 : 1);
        }
    };

    View.OnClickListener mOnLickListener4380 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            send4380TestMessage(v.getId() == R.id.sim1_btn_4380 ? 0 : 1);
        }
    };

    View.OnClickListener mOnLickListener4393 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            send4393TestMessage(v.getId() == R.id.sim1_btn_4393 ? 0 : 1);
        }
    };

    View.OnClickListener mOnLickListenerCustom = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            sendCustomTestMessage(v.getId() == R.id.sim1_btn_custom ? 0 : 1);
        }
    };

    private void send911TestMessage(int testSlotId, int testGEOScope) {
        Log.v(TAG,
                "send911TestMessage,testSlotId = " + testSlotId + ",testGEOScope=" + testGEOScope);
        Intent intent = new Intent("android.provider.Telephony.SMS_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(Channel911Constants.TEST_PLMN,
                Channel911Constants.TEST_LAC, Channel911Constants.TEST_CELL_ID);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(Channel911Constants.TEST_MESSAGE_FORMAT,
                testGEOScope, Channel911Constants.TEST_SERIAL_NUM, smsCbLocation,
                Channel911Constants.TEST_CHANNEL_911, Channel911Constants.TEST_LANGUAGE,
                Channel911Constants.TEST_CHANNEL_MESSAGE, Channel911Constants.TEST_PRIORITY, null,
                null);
        intent.setClassName("com.android.cellbroadcastreceiver",
                "com.android.cellbroadcastreceiver.CellBroadcastAlertService");
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", Channel911Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.startService(intent);
    }

    private void send919TestMessage(int testSlotId) {
        Log.v(TAG, "send919TestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(Channel919Constants.TEST_PLMN,
                Channel919Constants.TEST_LAC, Channel919Constants.TEST_CELL_ID);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(Channel919Constants.TEST_MESSAGE_FORMAT,
                Channel919Constants.TEST_GEO_SCOPE, Channel919Constants.TEST_SERIAL_NUM,
                smsCbLocation, Channel919Constants.TEST_CHANNEL_919,
                Channel919Constants.TEST_LANGUAGE, Channel919Constants.TEST_CHANNEL_MESSAGE,
                Channel919Constants.TEST_PRIORITY, null, null);
        intent.setClassName("com.android.cellbroadcastreceiver",
                "com.android.cellbroadcastreceiver.CellBroadcastAlertService");
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", Channel919Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.startService(intent);
    }

    private void send4370TestMessage(int testSlotId, int testGEOScope) {
        Log.v(TAG,
                "send4370TestMessage,testSlotId = " + testSlotId + ",testGEOScope=" + testGEOScope);
        Intent intent = new Intent("android.provider.Telephony.SMS_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(Channel4370Constants.TEST_PLMN,
                Channel4370Constants.TEST_LAC, Channel4370Constants.TEST_CELL_ID);
        SmsCbCmasInfo smsCbCmasInfo = new SmsCbCmasInfo(
                Channel4370Constants.TEST_CMASINFO_MESSAGE_CLASS,
                Channel4370Constants.TEST_CMASINFO_CATEGORY,
                Channel4370Constants.TEST_CMASINFO_RESPONSETYPE,
                Channel4370Constants.TEST_CMASINFO_SERVERITY,
                Channel4370Constants.TEST_CMASINFO_URGENCY,
                Channel4370Constants.TEST_CMASINFO_CERTAINTY);
        SmsCbMessage SmsCbMessage = null;
        if (testGEOScope == 0) {
            SmsCbMessage = new SmsCbMessage(Channel4370Constants.TEST_MESSAGE_FORMAT,
                    testGEOScope, Channel4370Constants.TEST_SERIAL_NUM, smsCbLocation,
                    Channel4370Constants.TEST_CHANNEL_4370, Channel4370Constants.TEST_LANGUAGE,
                    Channel4370Constants.TEST_CHANNEL_MESSAGE, Channel4370Constants.TEST_PRIORITY,
                    null, smsCbCmasInfo);
        } else {
            SmsCbMessage = new SmsCbMessage(Channel4370Constants.TEST_MESSAGE_FORMAT,
                    testGEOScope, Channel4370Constants.TEST_SERIAL_NUM, smsCbLocation,
                    Channel4370Constants.TEST_CHANNEL_4370, Channel4370Constants.TEST_LANGUAGE,
                    Channel4370Constants.TEST_CHANNEL_MESSAGE, Channel4370Constants.TEST_PRIORITY,
                    null, null);
        }
        intent.setClassName("com.android.cellbroadcastreceiver",
                "com.android.cellbroadcastreceiver.CellBroadcastAlertService");
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", Channel4370Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.startService(intent);
    }

    private void send4383TestMessage(int testSlotId) {
        Log.v(TAG, "send4383TestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(Channel4383Constants.TEST_PLMN,
                Channel4383Constants.TEST_LAC, Channel4383Constants.TEST_CELL_ID);
        SmsCbCmasInfo smsCbCmasInfo = new SmsCbCmasInfo(
                Channel4383Constants.TEST_CMASINFO_MESSAGE_CLASS,
                Channel4383Constants.TEST_CMASINFO_CATEGORY,
                Channel4383Constants.TEST_CMASINFO_RESPONSETYPE,
                Channel4383Constants.TEST_CMASINFO_SERVERITY,
                Channel4383Constants.TEST_CMASINFO_URGENCY,
                Channel4383Constants.TEST_CMASINFO_CERTAINTY);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(Channel4383Constants.TEST_MESSAGE_FORMAT,
                Channel4383Constants.TEST_GEO_SCOPE, Channel4383Constants.TEST_SERIAL_NUM,
                smsCbLocation, Channel4383Constants.TEST_CHANNEL_4383,
                Channel4383Constants.TEST_LANGUAGE, Channel4383Constants.TEST_CHANNEL_MESSAGE,
                Channel4383Constants.TEST_PRIORITY, null, smsCbCmasInfo);
        intent.setClassName("com.android.cellbroadcastreceiver",
                "com.android.cellbroadcastreceiver.CellBroadcastAlertService");
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", Channel4383Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.startService(intent);
    }

    private void send4380TestMessage(int testSlotId) {
        Log.v(TAG, "send4380TestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(Channel4380Constants.TEST_PLMN,
                Channel4380Constants.TEST_LAC, Channel4380Constants.TEST_CELL_ID);
        SmsCbCmasInfo smsCbCmasInfo = new SmsCbCmasInfo(
                Channel4380Constants.TEST_CMASINFO_MESSAGE_CLASS,
                Channel4380Constants.TEST_CMASINFO_CATEGORY,
                Channel4380Constants.TEST_CMASINFO_RESPONSETYPE,
                Channel4380Constants.TEST_CMASINFO_SERVERITY,
                Channel4380Constants.TEST_CMASINFO_URGENCY,
                Channel4380Constants.TEST_CMASINFO_CERTAINTY);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(Channel4380Constants.TEST_MESSAGE_FORMAT,
                Channel4380Constants.TEST_GEO_SCOPE, Channel4380Constants.TEST_SERIAL_NUM,
                smsCbLocation, Channel4380Constants.TEST_CHANNEL_4380,
                Channel4380Constants.TEST_LANGUAGE, Channel4380Constants.TEST_CHANNEL_MESSAGE,
                Channel4380Constants.TEST_PRIORITY, null, smsCbCmasInfo);
        intent.setClassName("com.android.cellbroadcastreceiver",
                "com.android.cellbroadcastreceiver.CellBroadcastAlertService");
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", Channel4380Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.startService(intent);
    }

    private void send4393TestMessage(int testSlotId) {
        Log.v(TAG, "send4393TestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(Channel4393Constants.TEST_PLMN,
                Channel4393Constants.TEST_LAC, Channel4393Constants.TEST_CELL_ID);
        SmsCbCmasInfo smsCbCmasInfo = new SmsCbCmasInfo(
                Channel4393Constants.TEST_CMASINFO_MESSAGE_CLASS,
                Channel4393Constants.TEST_CMASINFO_CATEGORY,
                Channel4393Constants.TEST_CMASINFO_RESPONSETYPE,
                Channel4393Constants.TEST_CMASINFO_SERVERITY,
                Channel4393Constants.TEST_CMASINFO_URGENCY,
                Channel4393Constants.TEST_CMASINFO_CERTAINTY);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(Channel4393Constants.TEST_MESSAGE_FORMAT,
                Channel4393Constants.TEST_GEO_SCOPE, Channel4393Constants.TEST_SERIAL_NUM,
                smsCbLocation, Channel4393Constants.TEST_CHANNEL_4393,
                Channel4393Constants.TEST_LANGUAGE, Channel4393Constants.TEST_CHANNEL_MESSAGE,
                Channel4393Constants.TEST_PRIORITY, null, smsCbCmasInfo);
        intent.setClassName("com.android.cellbroadcastreceiver",
                "com.android.cellbroadcastreceiver.CellBroadcastAlertService");
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", Channel4393Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.startService(intent);
    }

    private void sendCustomTestMessage(int testSlotId) {
        Log.v(TAG, "sendCustomTestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(ChannelCustomConstants.TEST_PLMN,
                ChannelCustomConstants.TEST_LAC, ChannelCustomConstants.TEST_CELL_ID);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(ChannelCustomConstants.TEST_MESSAGE_FORMAT,
                ChannelCustomConstants.TEST_GEO_SCOPE, ChannelCustomConstants.TEST_SERIAL_NUM,
                smsCbLocation,
                Integer.parseInt(testSlotId == 0 ? mSim1EditText.getText().toString()
                        : mSim2EditText.getText().toString()),
                ChannelCustomConstants.TEST_LANGUAGE, ChannelCustomConstants.TEST_CHANNEL_MESSAGE,
                ChannelCustomConstants.TEST_PRIORITY, null, null);
        intent.setClassName("com.android.cellbroadcastreceiver",
                "com.android.cellbroadcastreceiver.CellBroadcastAlertService");
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", ChannelCustomConstants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.startService(intent);
    }
}
