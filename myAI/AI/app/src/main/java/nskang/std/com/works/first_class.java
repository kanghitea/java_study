package nskang.std.com.works;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import nskang.std.com.AI_Handler.TOPHandler;
import nskang.std.com.AI_Handler.MainHandler;
import nskang.std.com.DEFINE.WORK_DEFINE;
import nskang.std.com.MSG.CMSG;
import nskang.std.com.MSG.WHAT;
import nskang.std.com.callback_1.CallbackEvent;
import nskang.std.com.callback_1.EventRegistration;

/**
 * Created by PC4_kangnamsu on 2017-05-17.
 */
public class first_class {
    private static final String TAG = "First_Class";
    private static MainHandler topHandler;

    private  HandlerThread mThread;
    private  NetHandler mHandler;

    public void prepare_handler() {
        mThread = new HandlerThread("first Thread");
        mThread.start();
        mHandler = new NetHandler(mThread.getLooper());
    }

    public void Set_Handler(MainHandler upHandler) {

        topHandler = upHandler;
        return;
    }




    public EventRegistration create() {
    CallbackEvent callbackEvent = new CallbackEvent() {

        @Override
        public void callbackMethod() {
            // TODO Auto-generated method stub
            first_class_sub_work mfirst_class_sub_work = new first_class_sub_work();
            mfirst_class_sub_work.setSrc(mfirst_class_sub_work.getMsgFrom());
            mfirst_class_sub_work.setDest(WORK_DEFINE.toDest1);
            Message msg = mHandler.makeHandlerMsg(mfirst_class_sub_work,WHAT.MSG1);
            mHandler.sendMessage(msg);

        }
    };

    EventRegistration eventRegistration = new EventRegistration(callbackEvent);
    return eventRegistration;
   }

    private static class NetHandler extends TOPHandler {
        public NetHandler(Looper looper) {
            super(looper);
        }

        @Override
        protected void handleSysMessage(CMSG msg) {
            topHandler.handleSysMessage(msg);
        }

        @Override
        protected void handleCtrlMessage(CMSG msg) {

        }

        @Override
        protected void handleWorksMessage(CMSG msg) {

        }
    }
}
