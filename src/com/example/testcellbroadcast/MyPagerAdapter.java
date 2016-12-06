
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

import com.example.testcellbroadcast.constants.MsgId4370Constants;
import com.example.testcellbroadcast.constants.MsgId4372Constants;
import com.example.testcellbroadcast.constants.MsgId4374Constants;
import com.example.testcellbroadcast.constants.MsgId4379Constants;
import com.example.testcellbroadcast.constants.MsgId4380Constants;
import com.example.testcellbroadcast.constants.MsgId911Constants;
import com.example.testcellbroadcast.constants.MsgId919Constants;
import com.example.testcellbroadcast.constants.MsgIdCustomConstants;

public class MyPagerAdapter extends PagerAdapter {

    private static final String TAG = MyPagerAdapter.class.getSimpleName();

    private List<View> mListViews;

    private Activity mActivity;

    Button mSim1Btn911;

    Button mSim1Btn919;

    Button mSim1Btn4370;

    Button mSim1Btn4372;

    Button mSim1Btn4374;

    Button mSim1Btn4379;

    Button mSim1Btn4380;

    Button mSim1BtnCustom;

    EditText mSim1EditText;

    Switch mSim1Switch911;

    Button mSim2Btn911;

    Button mSim2Btn919;

    Button mSim2Btn4370;

    Button mSim2Btn4372;

    Button mSim2Btn4374;

    Button mSim2Btn4379;

    Button mSim2Btn4380;

    Button mSim2BtnCustom;

    EditText mSim2EditText;

    Switch mSim2Switch911;

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

        mSim1Btn4372 = (Button)mActivity.findViewById(R.id.sim1_btn_4372);
        mSim1Btn4372.setOnClickListener(mOnLickListener4372);

        mSim1Btn4374 = (Button)mActivity.findViewById(R.id.sim1_btn_4374);
        mSim1Btn4374.setOnClickListener(mOnLickListener4374);

        mSim1Btn4379 = (Button)mActivity.findViewById(R.id.sim1_btn_4379);
        mSim1Btn4379.setOnClickListener(mOnLickListener4379);

        mSim1Btn4380 = (Button)mActivity.findViewById(R.id.sim1_btn_4380);
        mSim1Btn4380.setOnClickListener(mOnLickListener4380);

        mSim1EditText = (EditText)mActivity.findViewById(R.id.sim1_ed_custom);
        mSim1BtnCustom = (Button)mActivity.findViewById(R.id.sim1_btn_custom);
        mSim1BtnCustom.setOnClickListener(mOnLickListenerCustom);
        mSim1Switch911 = (Switch)mActivity.findViewById(R.id.sim1_switch_911);

        mSim2Btn911 = (Button)mActivity.findViewById(R.id.sim2_btn_911);
        mSim2Btn911.setOnClickListener(mOnLickListener911);
        mSim2Btn919 = (Button)mActivity.findViewById(R.id.sim2_btn_919);
        mSim2Btn919.setOnClickListener(mOnLickListener919);
        mSim2Btn4370 = (Button)mActivity.findViewById(R.id.sim2_btn_4370);
        mSim2Btn4370.setOnClickListener(mOnLickListener4370);
        mSim2Btn4372 = (Button)mActivity.findViewById(R.id.sim2_btn_4372);
        mSim2Btn4372.setOnClickListener(mOnLickListener4372);
        mSim2Btn4374 = (Button)mActivity.findViewById(R.id.sim2_btn_4374);
        mSim2Btn4374.setOnClickListener(mOnLickListener4374);
        mSim2Btn4379 = (Button)mActivity.findViewById(R.id.sim2_btn_4379);
        mSim2Btn4379.setOnClickListener(mOnLickListener4379);
        mSim2Btn4380 = (Button)mActivity.findViewById(R.id.sim2_btn_4380);
        mSim2Btn4380.setOnClickListener(mOnLickListener4380);
        mSim2Switch911 = (Switch)mActivity.findViewById(R.id.sim2_switch_911);

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
                testGeo = mSim1Switch911.isChecked() ? 1 : MsgId911Constants.TEST_GEO_SCOPE;
            } else {
                testGeo = mSim2Switch911.isChecked() ? 1 : MsgId911Constants.TEST_GEO_SCOPE;
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
            send4370TestMessage(isSim1 ? 0 : 1);
        }
    };

    View.OnClickListener mOnLickListener4372 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            boolean isSim1 = v.getId() == R.id.sim1_btn_4372 ? true : false;
            send4372TestMessage(isSim1 ? 0 : 1);
        }
    };

    View.OnClickListener mOnLickListener4374 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            boolean isSim1 = v.getId() == R.id.sim1_btn_4374 ? true : false;
            send4374TestMessage(isSim1 ? 0 : 1);
        }
    };

    View.OnClickListener mOnLickListener4379 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            boolean isSim1 = v.getId() == R.id.sim1_btn_4379 ? true : false;
            send4379TestMessage(isSim1 ? 0 : 1);
        }
    };

    View.OnClickListener mOnLickListener4380 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            send4380TestMessage(v.getId() == R.id.sim1_btn_4380 ? 0 : 1);
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
        Intent intent = new Intent("android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(MsgId911Constants.TEST_PLMN,
                MsgId911Constants.TEST_LAC, MsgId911Constants.TEST_CELL_ID);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(MsgId911Constants.TEST_MESSAGE_FORMAT,
                testGEOScope, MsgId911Constants.TEST_SERIAL_NUM, smsCbLocation,
                MsgId911Constants.TEST_CHANNEL_911, MsgId911Constants.TEST_LANGUAGE,
                MsgId911Constants.TEST_CHANNEL_MESSAGE, MsgId911Constants.TEST_PRIORITY, null,
                null);
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", MsgId911Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.sendBroadcast(intent);
    }

    private void send919TestMessage(int testSlotId) {
        Log.v(TAG, "send919TestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(MsgId919Constants.TEST_PLMN,
                MsgId919Constants.TEST_LAC, MsgId919Constants.TEST_CELL_ID);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(MsgId919Constants.TEST_MESSAGE_FORMAT,
                MsgId919Constants.TEST_GEO_SCOPE, MsgId919Constants.TEST_SERIAL_NUM, smsCbLocation,
                MsgId919Constants.TEST_CHANNEL_919, MsgId919Constants.TEST_LANGUAGE,
                MsgId919Constants.TEST_CHANNEL_MESSAGE, MsgId919Constants.TEST_PRIORITY, null,
                null);
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", MsgId919Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.sendBroadcast(intent);
    }

    private void send4370TestMessage(int testSlotId) {
        Log.v(TAG, "send4370TestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(MsgId4370Constants.TEST_SmsCbLocation_Plmn,
                MsgId4370Constants.TEST_SmsCbLocation_Lac,
                MsgId4370Constants.TEST_SmsCbLocation_Cid);
        SmsCbCmasInfo smsCbCmasInfo = new SmsCbCmasInfo(
                MsgId4370Constants.TEST_SmsCbCmasInfo_MESSAGE_CLASS,
                MsgId4370Constants.TEST_SmsCbCmasInfo_CATEGORY,
                MsgId4370Constants.TEST_SmsCbCmasInfo_RESPONSETYPE,
                MsgId4370Constants.TEST_SmsCbCmasInfo_SERVERITY,
                MsgId4370Constants.TEST_SmsCbCmasInfo_URGENCY,
                MsgId4370Constants.TEST_SmsCbCmasInfo_CERTAINTY);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(MsgId4370Constants.TEST_MESSAGE_FORMAT,
                MsgId4370Constants.TEST_GEO_SCOPE, MsgId4370Constants.TEST_SERIAL_NUM,
                smsCbLocation, MsgId4370Constants.TEST_SERVICE_CATEGORY,
                MsgId4370Constants.TEST_LANGUAGE, MsgId4370Constants.TEST_CHANNEL_BODY,
                MsgId4370Constants.TEST_PRIORITY, null, smsCbCmasInfo);
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", MsgId4370Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.sendBroadcast(intent);
    }

    private void send4372TestMessage(int testSlotId) {
        Log.v(TAG, "send4372TestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(MsgId4372Constants.TEST_SmsCbLocation_Plmn,
                MsgId4372Constants.TEST_SmsCbLocation_Lac,
                MsgId4372Constants.TEST_SmsCbLocation_Cid);
        SmsCbCmasInfo smsCbCmasInfo = new SmsCbCmasInfo(
                MsgId4372Constants.TEST_SmsCbCmasInfo_MESSAGE_CLASS,
                MsgId4372Constants.TEST_SmsCbCmasInfo_CATEGORY,
                MsgId4372Constants.TEST_SmsCbCmasInfo_RESPONSETYPE,
                MsgId4372Constants.TEST_SmsCbCmasInfo_SERVERITY,
                MsgId4372Constants.TEST_SmsCbCmasInfo_URGENCY,
                MsgId4372Constants.TEST_SmsCbCmasInfo_CERTAINTY);

        SmsCbMessage SmsCbMessage = new SmsCbMessage(MsgId4372Constants.TEST_MESSAGE_FORMAT,
                MsgId4372Constants.TEST_GEO_SCOPE, MsgId4372Constants.TEST_SERIAL_NUM,
                smsCbLocation, MsgId4372Constants.TEST_SERVICE_CATEGORY,
                MsgId4372Constants.TEST_LANGUAGE, MsgId4372Constants.TEST_CHANNEL_BODY,
                MsgId4372Constants.TEST_PRIORITY, null, smsCbCmasInfo);
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", MsgId4372Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.sendBroadcast(intent);
    }

    private void send4374TestMessage(int testSlotId) {
        Log.v(TAG, "send4374TestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(MsgId4374Constants.TEST_SmsCbLocation_Plmn,
                MsgId4374Constants.TEST_SmsCbLocation_Lac,
                MsgId4374Constants.TEST_SmsCbLocation_Cid);
        SmsCbCmasInfo smsCbCmasInfo = new SmsCbCmasInfo(
                MsgId4374Constants.TEST_SmsCbCmasInfo_MESSAGE_CLASS,
                MsgId4374Constants.TEST_SmsCbCmasInfo_CATEGORY,
                MsgId4374Constants.TEST_SmsCbCmasInfo_RESPONSETYPE,
                MsgId4374Constants.TEST_SmsCbCmasInfo_SERVERITY,
                MsgId4374Constants.TEST_SmsCbCmasInfo_URGENCY,
                MsgId4374Constants.TEST_SmsCbCmasInfo_CERTAINTY);

        SmsCbMessage SmsCbMessage = new SmsCbMessage(MsgId4374Constants.TEST_MESSAGE_FORMAT,
                MsgId4374Constants.TEST_GEO_SCOPE, MsgId4374Constants.TEST_SERIAL_NUM,
                smsCbLocation, MsgId4374Constants.TEST_SERVICE_CATEGORY,
                MsgId4374Constants.TEST_LANGUAGE, MsgId4374Constants.TEST_CHANNEL_BODY,
                MsgId4374Constants.TEST_PRIORITY, null, smsCbCmasInfo);
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", MsgId4372Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.sendBroadcast(intent);
    }

    private void send4379TestMessage(int testSlotId) {
        Log.v(TAG, "send4379TestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(MsgId4379Constants.TEST_SmsCbLocation_Plmn,
                MsgId4379Constants.TEST_SmsCbLocation_Lac,
                MsgId4379Constants.TEST_SmsCbLocation_Cid);
        SmsCbCmasInfo smsCbCmasInfo = new SmsCbCmasInfo(
                MsgId4379Constants.TEST_SmsCbCmasInfo_MESSAGE_CLASS,
                MsgId4379Constants.TEST_SmsCbCmasInfo_CATEGORY,
                MsgId4379Constants.TEST_SmsCbCmasInfo_RESPONSETYPE,
                MsgId4379Constants.TEST_SmsCbCmasInfo_SERVERITY,
                MsgId4379Constants.TEST_SmsCbCmasInfo_URGENCY,
                MsgId4379Constants.TEST_SmsCbCmasInfo_CERTAINTY);

        SmsCbMessage SmsCbMessage = new SmsCbMessage(MsgId4379Constants.TEST_MESSAGE_FORMAT,
                MsgId4379Constants.TEST_GEO_SCOPE, MsgId4379Constants.TEST_SERIAL_NUM,
                smsCbLocation, MsgId4379Constants.TEST_SERVICE_CATEGORY,
                MsgId4379Constants.TEST_LANGUAGE, MsgId4379Constants.TEST_CHANNEL_BODY,
                MsgId4379Constants.TEST_PRIORITY, null, smsCbCmasInfo);
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", MsgId4379Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.sendBroadcast(intent);
    }

    private void send4380TestMessage(int testSlotId) {
        Log.v(TAG, "send4380TestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(MsgId4380Constants.TEST_PLMN,
                MsgId4380Constants.TEST_LAC, MsgId4380Constants.TEST_CELL_ID);
        SmsCbCmasInfo smsCbCmasInfo = new SmsCbCmasInfo(
                MsgId4380Constants.TEST_CMASINFO_MESSAGE_CLASS,
                MsgId4380Constants.TEST_CMASINFO_CATEGORY,
                MsgId4380Constants.TEST_CMASINFO_RESPONSETYPE,
                MsgId4380Constants.TEST_CMASINFO_SERVERITY,
                MsgId4380Constants.TEST_CMASINFO_URGENCY,
                MsgId4380Constants.TEST_CMASINFO_CERTAINTY);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(MsgId4380Constants.TEST_MESSAGE_FORMAT,
                MsgId4380Constants.TEST_GEO_SCOPE, MsgId4380Constants.TEST_SERIAL_NUM,
                smsCbLocation, MsgId4380Constants.TEST_CHANNEL_4380,
                MsgId4380Constants.TEST_LANGUAGE, MsgId4380Constants.TEST_CHANNEL_MESSAGE,
                MsgId4380Constants.TEST_PRIORITY, null, smsCbCmasInfo);
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", MsgId4380Constants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.sendBroadcast(intent);
    }

    private void sendCustomTestMessage(int testSlotId) {
        Log.v(TAG, "sendCustomTestMessage,testSlotId = " + testSlotId);
        Intent intent = new Intent("android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED");
        SmsCbLocation smsCbLocation = new SmsCbLocation(MsgIdCustomConstants.TEST_PLMN,
                MsgIdCustomConstants.TEST_LAC, MsgIdCustomConstants.TEST_CELL_ID);
        SmsCbMessage SmsCbMessage = new SmsCbMessage(MsgIdCustomConstants.TEST_MESSAGE_FORMAT,
                MsgIdCustomConstants.TEST_GEO_SCOPE, MsgIdCustomConstants.TEST_SERIAL_NUM,
                smsCbLocation,
                Integer.parseInt(testSlotId == 0 ? mSim1EditText.getText().toString()
                        : mSim2EditText.getText().toString()),
                MsgIdCustomConstants.TEST_LANGUAGE, MsgIdCustomConstants.TEST_CHANNEL_MESSAGE,
                MsgIdCustomConstants.TEST_PRIORITY, null, null);
        intent.putExtra("message", SmsCbMessage);
        intent.putExtra("subscription", MsgIdCustomConstants.TEST_SUBSCRIPTION);
        intent.putExtra("slot", testSlotId);
        mActivity.sendBroadcast(intent);
    }

}
