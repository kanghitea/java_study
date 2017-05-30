package nskang.std.com.works;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import nskang.std.com.DLOG.DebugLog;
import nskang.std.com.callback_1.CallbackEvent;
import nskang.std.com.callback_1.EventRegistration;

/**
 * Created by PC4_kangnamsu on 2017-05-17.
 */
public class first_class extends sub_class {
    private static final String TAG = "First_Class";
    private HandlerThread mThread;
    private static Handler topHandler;
    private int current_count = 0;
    private int Trigger_Base = 5;
    public int Get_current_count() {
        current_count = super.Get_current_count(TAG,current_count,Trigger_Base);
        return current_count;
    }
    public static void Set_Handler(Handler upHandler) {

        topHandler = upHandler;
        return;
    }

    public static EventRegistration create() {
    CallbackEvent callbackEvent = new CallbackEvent() {

        @Override
        public void callbackMethod() {
            // TODO Auto-generated method stub
            DebugLog.e(TAG, "===============   first call callback method from callee   ==================");
            Message msg;
            msg = new Message();
            msg.what = 1;
            topHandler.sendMessage(msg);
        }

    };

    EventRegistration eventRegistration = new EventRegistration(callbackEvent);
    return eventRegistration;
   }

}
