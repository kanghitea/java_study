package nskang.std.com.AI_Handler;

import android.os.Looper;
import android.util.Log;

import nskang.std.com.MSG.ICtrlMsg;
import nskang.std.com.MSG.IMainMsg;
import nskang.std.com.MSG.ISysMsg;

public class MainHandler extends BaseHandler {
    private final static String TAG = "MainHandler";
    public MainHandler(Looper looper) {
        super(looper);
    }

    @Override
    public void handleSysMessage(ISysMsg sysMsg) {
        Log.e(TAG, "==== nskang ==== handleSysMessage!! :");
    }

    @Override
    public void handleCtrlMessage(ICtrlMsg ctrlMsg) {
        Log.e(TAG, "==== nskang ==== handleCtrlMessage!!");
    }

    @Override
    public void handleUgsMessage(IMainMsg ugsMsg) {
        Log.e(TAG, "==== nskang ==== handleUgsMessage!!");
    }
}