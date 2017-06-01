package nskang.std.com.works;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import nskang.std.com.AI_Handler.BaseHandler;
import nskang.std.com.AI_Handler.MainHandler;
import nskang.std.com.DEFINE.WORK_DEFINE;
import nskang.std.com.DLOG.DebugLog;
import nskang.std.com.MSG.CMSG;
import nskang.std.com.MSG.WHAT;
import nskang.std.com.callback_1.CallbackEvent;
import nskang.std.com.callback_1.EventRegistration;

/**
 * Created by PC4_kangnamsu on 2017-05-17.
 */
public class second_class{
    private static final String TAG = "Second_Class";
    private static MainHandler topHandler;

    private  HandlerThread mThread;
    private  NetHandler mHandler;

    public void prepare_handler() {
        mThread = new HandlerThread("second Thread");
        mThread.start();
        mHandler = new NetHandler(mThread.getLooper());
    }

    public void Set_Handler(MainHandler upHandler) {
        topHandler = upHandler;
    }

    public EventRegistration create() {

    CallbackEvent callbackEvent = new CallbackEvent() {

        @Override
        public void callbackMethod() {
            // TODO Auto-generated method stub
            second_class_sub_work msecond_class_sub_work = new second_class_sub_work();
            msecond_class_sub_work.setSrc(msecond_class_sub_work.getMsgFrom());
            msecond_class_sub_work.setDest(WORK_DEFINE.toDest2);
            Message msg = mHandler.makeHandlerMsg(msecond_class_sub_work,WHAT.MSG2);
            mHandler.sendMessage(msg);
        }

    };



    EventRegistration eventRegistration = new EventRegistration(callbackEvent);
    return eventRegistration;
   }

    private static class NetHandler extends BaseHandler {
        public NetHandler(Looper looper) {
            super(looper);
        }

        @Override
        protected void handleSysMessage(CMSG msg) {

        }

        @Override
        protected void handleCtrlMessage(CMSG msg) {
          topHandler.handleCtrlMessage(msg);
        }

        @Override
        protected void handleWorksMessage(CMSG msg) {

        }
    }
}
