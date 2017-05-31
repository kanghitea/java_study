package nskang.std.com.AI_Handler;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

    public class MainHandler extends BaseHandler {
    private final static String TAG = "MainHandler";
    public MainHandler(Looper looper) {
        super(looper);
    }

    @Override
    public void handleSysMessage(Message msg) {
        Log.e(TAG, "==== nskang ==== handleSysMessage!! :" + msg.obj);
    }

    @Override
    public void handleCtrlMessage(Message msg) {
        Log.e(TAG, "==== nskang ==== handleCtrlMessage!! :" + msg.obj);
    }

    @Override
    public void handleWorksMessage(Message msg) {
        Log.e(TAG, "==== nskang ==== handleUgsMessage!! :" + msg.obj);
    }
}