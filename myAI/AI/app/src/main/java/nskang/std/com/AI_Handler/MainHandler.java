package nskang.std.com.AI_Handler;

import android.os.Looper;
import android.util.Log;

import nskang.std.com.DEFINE.WORK_DEFINE;
import nskang.std.com.MSG.CMSG;

public class MainHandler extends TOPHandler {
    private final static String TAG = "MainHandler";
    public MainHandler(Looper looper) {
        super(looper);
    }

    @Override
    public void handleSysMessage(CMSG msg) {
        int msgFrom = msg.getMsgFrom();
        switch (msgFrom) {
            case WORK_DEFINE.FIRST_WORK:
                Log.e(TAG, "====================================");
                Log.e(TAG, " handleSysMessage!! from FIRST_WORK");
                Log.e(TAG, " SRC : " + msg.getSrc());
                Log.e(TAG, " DST : " + msg.getDest());
                Log.e(TAG, " ID  " + msg.getTransId());
                Log.e(TAG, " Delay time after Event(ms) : " + (System.currentTimeMillis() - msg.getmEventTime()));
                Log.e(TAG, "====================================");
                break;
            case WORK_DEFINE.SECOND_WORK:
                Log.e(TAG, "====================================");
                Log.e(TAG, " handleSysMessage!! from SECOND_WORK");
                Log.e(TAG, " SRC : " + msg.getSrc());
                Log.e(TAG, " DST : " + msg.getDest());
                Log.e(TAG, " ID  " + msg.getTransId());
                Log.e(TAG, " Delay time after Event(ms) : " + (System.currentTimeMillis() - msg.getmEventTime()));
                Log.e(TAG, "====================================");
                break;
            case WORK_DEFINE.THIRD_WORK:
                Log.e(TAG, "====================================");
                Log.e(TAG, " handleSysMessage!! from THIRD_WORK");
                Log.e(TAG, " SRC : " + msg.getSrc());
                Log.e(TAG, " DST : " + msg.getDest());
                Log.e(TAG, " ID  " + msg.getTransId());
                Log.e(TAG, " Delay time after Event(ms) : " + (System.currentTimeMillis() - msg.getmEventTime()));
                Log.e(TAG, "====================================");
                break;
            default:
                Log.e(TAG, " handleSysMessage!! from UNKNOWN");
        }

    }

    @Override
    public void handleCtrlMessage(CMSG msg) {
        int msgFrom = msg.getMsgFrom();
        switch (msgFrom) {
            case WORK_DEFINE.FIRST_WORK:
                Log.e(TAG, "====================================");
                Log.e(TAG, " handleCtrlMessage!! from FIRST_WORK");
                Log.e(TAG, " SRC : " + msg.getSrc());
                Log.e(TAG, " DST : " + msg.getDest());
                Log.e(TAG, " ID  " + msg.getTransId());
                Log.e(TAG, " Delay time after Event(ms) : " + (System.currentTimeMillis() - msg.getmEventTime()));
                Log.e(TAG, "====================================");
                break;
            case WORK_DEFINE.SECOND_WORK:
                Log.e(TAG, "====================================");
                Log.e(TAG, " handleCtrlMessage!! from SECOND_WORK");
                Log.e(TAG, " SRC : " + msg.getSrc());
                Log.e(TAG, " DST : " + msg.getDest());
                Log.e(TAG, " ID  " + msg.getTransId());
                Log.e(TAG, " Delay time after Event(ms) : " + (System.currentTimeMillis() - msg.getmEventTime()));
                Log.e(TAG, "====================================");
                break;
            case WORK_DEFINE.THIRD_WORK:
                Log.e(TAG, "====================================");
                Log.e(TAG, " handleCtrlMessage!! from THIRD_WORK");
                Log.e(TAG, " SRC : " + msg.getSrc());
                Log.e(TAG, " DST : " + msg.getDest());
                Log.e(TAG, " ID  " + msg.getTransId());
                Log.e(TAG, " Delay time after Event(ms) : " + (System.currentTimeMillis() - msg.getmEventTime()));
                Log.e(TAG, "====================================");
                break;
            default:
                Log.e(TAG, " handleSysMessage!! from UNKNOWN");
        }

    }

    @Override
    public void handleWorksMessage(CMSG msg) {
        int msgFrom = msg.getMsgFrom();
        switch (msgFrom) {
            case WORK_DEFINE.FIRST_WORK:
                Log.e(TAG, "====================================");
                Log.e(TAG, " handleWorksMessage!! from FIRST_WORK");
                Log.e(TAG, " SRC : " + msg.getSrc());
                Log.e(TAG, " DST : " + msg.getDest());
                Log.e(TAG, " ID  " + msg.getTransId());
                Log.e(TAG, " Delay time after Event(ms) : " + (System.currentTimeMillis() - msg.getmEventTime()));
                Log.e(TAG, "====================================");
                break;
            case WORK_DEFINE.SECOND_WORK:
                Log.e(TAG, "====================================");
                Log.e(TAG, " handleWorksMessage!! from SECOND_WORK");
                Log.e(TAG, " SRC : " + msg.getSrc());
                Log.e(TAG, " DST : " + msg.getDest());
                Log.e(TAG, " ID  " + msg.getTransId());
                Log.e(TAG, " Delay time after Event(ms) : " + (System.currentTimeMillis() - msg.getmEventTime()));
                Log.e(TAG, "====================================");
                break;
            case WORK_DEFINE.THIRD_WORK:
                Log.e(TAG, "====================================");
                Log.e(TAG, " handleWorksMessage!! from THIRD_WORK");
                Log.e(TAG, " SRC : " + msg.getSrc());
                Log.e(TAG, " DST : " + msg.getDest());
                Log.e(TAG, " ID  " + msg.getTransId());
                Log.e(TAG, " Delay time after Event(ms) : " + (System.currentTimeMillis() - msg.getmEventTime()));
                Log.e(TAG, "====================================");
                break;
            default:
                Log.e(TAG, " handleWorksMessage!! from UNKNOWN");
        }

    }
}