package nskang.std.com.AI_Handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import nskang.std.com.MSG.WHAT;

public abstract class BaseHandler extends Handler {
    protected BaseHandler(Looper looper) {
        super(looper);
    }
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case WHAT.MSG1: {
                handleSysMessage(msg);
            }
            break;

            case WHAT.MSG2: {
                handleCtrlMessage(msg);
            }
            break;

            case WHAT.MSG3: {
                handleWorksMessage(msg);
            }
            break;

            default:
                super.handleMessage(msg);
                break;
        }
    }

    public Message makeHandlerMsg(String obj, int what) {
        Message msg = Message.obtain(null, what);
        {
            msg.obj = obj;
        }
        return msg;
    }

    protected abstract void handleSysMessage(Message msg);

    protected abstract void handleCtrlMessage(Message msg);

    protected abstract void handleWorksMessage(Message msg);
}
